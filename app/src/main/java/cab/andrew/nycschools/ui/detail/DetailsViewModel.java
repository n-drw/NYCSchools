package cab.andrew.nycschools.ui.detail;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cab.andrew.nycschools.data.model.School;
import cab.andrew.nycschools.data.source.SchoolsRepository;
import cab.andrew.nycschools.ui.Resource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class DetailsViewModel extends ViewModel {
	private MediatorLiveData<Resource<School>> school;
	private static String TAG = "details view model";
	private String schoolDbn;

	@NonNull
	private final SchoolsRepository repository;

	@Inject
	public DetailsViewModel(@NonNull SchoolsRepository repository) {
		this.repository = repository;
	}

	public LiveData<Resource<School>> observeSchool(String schoolDbn) {
		if (school == null) {
			school = new MediatorLiveData<>();
			school.setValue(Resource.loading(null));
			this.schoolDbn = schoolDbn;

			final LiveData<Resource<School>> source = LiveDataReactiveStreams.fromPublisher(
					repository.getSchool(schoolDbn).toFlowable()
					.onErrorReturn(throwable -> {
						Log.d(TAG, "apply: ", throwable);
						School school = new School();
						school.setId(-1);
						school.setDbn(schoolDbn);
						return school;
					})
					.map((Function<School, Resource<School>>) school -> {
						if(school != null) {
							if (school.getId() == -1) {
								return Resource.error("Error loading school", null);
							}
						}
						return Resource.success(school);
					})
					.subscribeOn(Schedulers.io())
			);
			school.addSource(source, schoolResource -> {
				Log.d(TAG, "onChanged: " + school.toString());
				school.setValue(schoolResource);
				school.removeSource(source);
			});
		}
		Log.d(TAG, "school where art thou " + school.toString());
		return school;
	}

	public String getSchoolDbn() {
		return schoolDbn;
	}
}
