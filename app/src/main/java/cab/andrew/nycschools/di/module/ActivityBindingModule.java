package cab.andrew.nycschools.di.module;

import cab.andrew.nycschools.di.scopes.ActivityScope;
import cab.andrew.nycschools.ui.main.MainActivity;
import cab.andrew.nycschools.ui.main.MainFragmentBinding;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = ViewModelModule.class)
public abstract class ActivityBindingModule {
	@ActivityScope
	@ContributesAndroidInjector(modules = {MainFragmentBinding.class})
	abstract MainActivity mainActivity();
}
