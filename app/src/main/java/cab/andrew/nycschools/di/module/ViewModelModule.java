package cab.andrew.nycschools.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import cab.andrew.nycschools.di.scopes.AppScope;
import cab.andrew.nycschools.di.util.ViewModelKey;
import cab.andrew.nycschools.di.util.ViewModelProviderFactory;
import cab.andrew.nycschools.ui.about.AboutViewModel;
import cab.andrew.nycschools.ui.detail.DetailsViewModel;
import cab.andrew.nycschools.ui.list.ListViewModel;
import cab.andrew.nycschools.ui.maps.MapsViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
	@Binds
	@IntoMap
	@ViewModelKey(ListViewModel.class)
	public abstract ViewModel bindListViewModel(ListViewModel listViewModel);

	@Binds
	@IntoMap
	@ViewModelKey(DetailsViewModel.class)
	public abstract ViewModel bindDetailsViewModel(DetailsViewModel detailsViewModel);

	@Binds
	@IntoMap
	@ViewModelKey(MapsViewModel.class)
	public abstract ViewModel bindsMapsViewModel(MapsViewModel mapsViewModel);

	@Binds
	@IntoMap
	@ViewModelKey(AboutViewModel.class)
	public abstract ViewModel bindAboutViewModel(AboutViewModel aboutViewModel);

	@Binds
	@AppScope
	abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);
}
