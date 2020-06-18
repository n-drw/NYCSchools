package cab.andrew.nycschools.ui.maps;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.inject.Inject;

import cab.andrew.nycschools.data.source.SchoolsRepository;

public class MapsViewModel extends ViewModel {
	@NonNull
	private final SchoolsRepository repository;

	@Inject
	public MapsViewModel(@NonNull SchoolsRepository repository) {
		this.repository = repository;
	}
}
