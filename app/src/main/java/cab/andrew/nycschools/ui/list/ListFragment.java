package cab.andrew.nycschools.ui.list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.Toast;
import javax.inject.Inject;

import cab.andrew.nycschools.R;
import cab.andrew.nycschools.base.BaseView;
import cab.andrew.nycschools.data.model.School;
import cab.andrew.nycschools.databinding.ListFragmentBinding;
import cab.andrew.nycschools.ui.detail.DetailsViewModel;
import dagger.android.support.DaggerFragment;

public class ListFragment extends DaggerFragment {

	private ListFragmentBinding binding;
    private ListViewModel listViewModel;
    private RecyclerView recyclerView;

    @Inject
	SchoolListAdapter adapter;

    private static final String TAG = "ListFragment";

    @Inject
	ViewModelProvider.Factory viewModelFactory;

    @Inject
	public ListFragment() {
	}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
		Toast.makeText(getActivity(), "List fragment", Toast.LENGTH_SHORT);
		binding = ListFragmentBinding.inflate(inflater, container, false);
		return binding.getRoot();
    }

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    	Log.d(TAG, "AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
    	recyclerView = binding.recyclerView;
		listViewModel = new ViewModelProvider(this, viewModelFactory).get(ListViewModel.class);
		initRecyclerView();
		subscribeObservers();
	}

	private void subscribeObservers(){
    	listViewModel.observeSchools().removeObservers(getViewLifecycleOwner());
    	listViewModel.observeSchools().observe(getViewLifecycleOwner(), listResource -> {
			if(listResource != null) {
				switch(listResource.status){
					case LOADING:
						Log.d(TAG, "onChanged: Loading...");
						break;
					case SUCCESS:
						Log.d(TAG, "onChanged: received schools");
//						recyclerView.setVisibility(View.VISIBLE);
						adapter.setSchools(listResource.data);
						break;
					case ERROR:
						Log.d(TAG, "onChanged: everything fucked up..." + listResource.message);
						break;
				}
			}
		});
	}

	private void initRecyclerView() {
    	recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    	BottomSpacingItemDecoration bottomSpacingItemDecoration = new BottomSpacingItemDecoration(getResources().getDimensionPixelSize(R.dimen.grid_2));
    	recyclerView.addItemDecoration(bottomSpacingItemDecoration);
    	recyclerView.setAdapter(adapter);
	}

}
