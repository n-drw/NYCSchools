package cab.andrew.nycschools.base;

import cab.andrew.nycschools.di.component.AppComponent;
import cab.andrew.nycschools.di.component.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {
	@Override
	protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
		return DaggerAppComponent.builder().application(this).build();
	}
}
