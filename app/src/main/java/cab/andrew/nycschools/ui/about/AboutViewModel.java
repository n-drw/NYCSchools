package cab.andrew.nycschools.ui.about;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import cab.andrew.nycschools.data.model.School;
import cab.andrew.nycschools.data.source.SchoolsRepository;

public class AboutViewModel extends ViewModel {
	@NonNull
	private final SchoolsRepository repository;

	@Inject
	public AboutViewModel(@NonNull SchoolsRepository repository) {
		this.repository = repository;
	}
}
