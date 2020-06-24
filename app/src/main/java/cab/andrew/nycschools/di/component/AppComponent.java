package cab.andrew.nycschools.di.component;

import android.app.Application;

import cab.andrew.nycschools.base.BaseApplication;
import cab.andrew.nycschools.data.source.SchoolsRepositoryModule;
import cab.andrew.nycschools.di.module.ActivityBindingModule;
import cab.andrew.nycschools.di.module.ContextModule;
import cab.andrew.nycschools.di.module.UtilsModule;
import cab.andrew.nycschools.di.scopes.AppScope;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@AppScope
@Component(modules = {
		AndroidSupportInjectionModule.class,
		ActivityBindingModule.class,
		UtilsModule.class,
		SchoolsRepositoryModule.class,
		ContextModule.class
	}
)

public interface AppComponent extends AndroidInjector<BaseApplication> {
	@Component.Builder
	interface Builder {
		@BindsInstance
		Builder application(Application application);
		AppComponent build();
	}
}
