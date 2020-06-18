package cab.andrew.nycschools.ui.main;

import android.widget.ListAdapter;

import cab.andrew.nycschools.di.scopes.ActivityScope;
import cab.andrew.nycschools.di.scopes.AppScope;
import cab.andrew.nycschools.di.scopes.FragmentScope;
import cab.andrew.nycschools.ui.about.AboutFragment;
import cab.andrew.nycschools.ui.detail.DetailsFragment;
import cab.andrew.nycschools.ui.list.ListFragment;
import cab.andrew.nycschools.ui.list.SchoolListAdapter;
import cab.andrew.nycschools.ui.list.SchoolSelectedListener;
import cab.andrew.nycschools.ui.maps.MapsFragment;
import cab.andrew.nycschools.utils.providers.BaseResourceProvider;
import cab.andrew.nycschools.utils.providers.ResourceProvider;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {MainFragmentBinding.ListAbstractModule.class, MainFragmentBinding.DetailsAbstractModule.class, MainFragmentBinding.AboutAbstractModule.class, MainFragmentBinding.MapsAbstractModule.class})
public class MainFragmentBinding {
	@ActivityScope
	@Provides
	BaseResourceProvider provideResourceProvider(MainActivity context){
		return new ResourceProvider(context);
	}

	@Module
	public interface ListAbstractModule {

		@FragmentScope
		@ContributesAndroidInjector
		ListFragment listFragment();

		@Provides
		static SchoolListAdapter provideAdapter() {
			return new SchoolListAdapter();
		}
	}

	@Module
	public interface DetailsAbstractModule {
		@FragmentScope
		@ContributesAndroidInjector
		DetailsFragment detailsFragment();
	}

	@Module
	public interface AboutAbstractModule {
		@FragmentScope
		@ContributesAndroidInjector
		AboutFragment aboutFragment();
	}

	@Module
	public interface MapsAbstractModule {
		@FragmentScope
		@ContributesAndroidInjector
		MapsFragment mapsFragment();
	}
}
