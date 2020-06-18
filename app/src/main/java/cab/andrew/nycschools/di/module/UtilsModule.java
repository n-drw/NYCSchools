package cab.andrew.nycschools.di.module;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import cab.andrew.nycschools.di.scopes.AppScope;
import cab.andrew.nycschools.utils.chrometabs.ChromeTabsWrapper;
import cab.andrew.nycschools.utils.connectivity.DefaultOnlineChecker;
import cab.andrew.nycschools.utils.connectivity.OnlineChecker;
import cab.andrew.nycschools.utils.schedulers.BaseSchedulerProvider;
import cab.andrew.nycschools.utils.schedulers.SchedulerProvider;
import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {
	@Provides
	@AppScope
	ConnectivityManager provideConnectivityManager(Application context){
		return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	}

	@Provides
	@AppScope
	ChromeTabsWrapper provideChromeTabsWrapper(Application context) {
		return new ChromeTabsWrapper(context);
	}

	@Provides
	@AppScope
	OnlineChecker onlineChecker(ConnectivityManager cm) {
		return new DefaultOnlineChecker(cm);
	}

	@Provides
	@AppScope
	BaseSchedulerProvider provideSchedulerProvider() {
		return SchedulerProvider.getInstance();
	}
}
