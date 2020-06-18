package cab.andrew.nycschools.ui.detail;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import cab.andrew.nycschools.data.model.School;
import cab.andrew.nycschools.databinding.DetailsFragmentBinding;
import dagger.android.support.DaggerFragment;

import static android.content.ContentValues.TAG;

public class DetailsFragment extends DaggerFragment {
	@Inject
	ViewModelProvider.Factory viewModelFactory;

	private DetailsFragmentBinding binding;
    private DetailsViewModel detailsViewModel;
    private RecyclerView recyclerView;
	private School school;

	@Inject
	public DetailsFragment() {

	}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
    	binding = DetailsFragmentBinding.inflate(inflater, container, false);
    	return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        detailsViewModel = new ViewModelProvider(this, viewModelFactory).get(DetailsViewModel.class);
    }

    private void subscribeObserver(){
    	detailsViewModel.observeSchool(school.getDbn()).removeObservers(getViewLifecycleOwner());
    	detailsViewModel.observeSchool(school.getDbn()).observe(getViewLifecycleOwner(), detailsResource -> {
			if(detailsResource != null) {
				if (school.getDbn().equals(detailsViewModel.getSchoolDbn())) {
					switch (detailsResource.status) {
						case LOADING:
							Log.d(TAG, "onChanged: Loading...");
							break;
						case SUCCESS:
							Log.d(TAG, "onChanged: received schools");
							break;
						case ERROR:
							Log.d(TAG, "onChanged: Error");
							break;
					}
				}
			}
		});
	}
}
