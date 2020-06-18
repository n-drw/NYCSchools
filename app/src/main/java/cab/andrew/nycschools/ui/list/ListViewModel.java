package cab.andrew.nycschools.ui.list;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataKt;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NonNls;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cab.andrew.nycschools.data.model.SatScore;
import cab.andrew.nycschools.data.model.School;
import cab.andrew.nycschools.data.source.SchoolsRepository;
import cab.andrew.nycschools.data.source.remote.NycOpenDataWebService;
import cab.andrew.nycschools.di.scopes.AppScope;
import cab.andrew.nycschools.ui.Resource;
import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subscribers.DisposableSubscriber;

@AppScope
public class ListViewModel extends ViewModel {
	private static String TAG = "heheheheh hi im a listy m00model";
	private final SchoolsRepository repository;
	private MediatorLiveData<Resource<List<School>>> schools;

	@Inject
	public ListViewModel(SchoolsRepository repository) {
		this.repository = repository;
	}

	public LiveData<Resource<List<School>>> observeSchools() {
		if(schools == null) {
			schools = new MediatorLiveData<>();
			schools.setValue(Resource.loading(null));

			final LiveData<Resource<List<School>>> source = LiveDataReactiveStreams.fromPublisher(
					repository.getSchools().toFlowable()
					.onErrorReturn(throwable -> {
						Log.d(TAG, "apply: ", throwable);
						School school = new School();
						school.setId(-1);
						ArrayList<School> schools = new ArrayList<>();
						schools.add(school);
						return schools;
					})
					.map((Function<List<School>, Resource<List<School>>>) schools -> {
						if(schools.size() > 0) {
							if(schools.get(0).getId() == -1) {
								return Resource.error("Error loading schools", null);
							}
						}
						return Resource.success(schools);
					})
					.subscribeOn(Schedulers.io())
			);

			schools.addSource(source, listSchools -> {
				Log.d(TAG, "onChanged: " + schools.toString());
				schools.setValue(listSchools);
				schools.removeSource(source);
			});
		}
		Log.d(TAG, "my schools don't fucking exist " + schools.toString());
		return schools;
	}
}
