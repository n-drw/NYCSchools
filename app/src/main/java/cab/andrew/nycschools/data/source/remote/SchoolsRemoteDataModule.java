package cab.andrew.nycschools.data.source.remote;

import android.app.Application;

import androidx.room.Room;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import cab.andrew.nycschools.data.source.local.SchoolsDao;
import cab.andrew.nycschools.data.source.local.SchoolsDatabase;
import cab.andrew.nycschools.data.source.remote.util.RequestInterceptor;
import cab.andrew.nycschools.di.scopes.AppScope;
import cab.andrew.nycschools.utils.Constants;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class SchoolsRemoteDataModule {
	private static final int CONNECT_TIMEOUT_IN_MS = 30000;

	@AppScope
	@Provides
	OkHttpClient provideOkHttpClient(RequestInterceptor requestInterceptor){
		HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
		loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

		return new OkHttpClient.Builder()
				.connectTimeout(CONNECT_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
				.addInterceptor(loggingInterceptor)
				.addInterceptor(requestInterceptor)
				.build();
	}

	@AppScope
	@Provides
	Retrofit retrofit(OkHttpClient okHttpClient){
		return new Retrofit
				.Builder()
				.baseUrl(Constants.NYC_OPEN_DATA_BASE_URL)
				.addConverterFactory(MoshiConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(okHttpClient)
				.build();
	}

	@AppScope
	@Provides
	static NycOpenDataWebService provideRetrofit(Retrofit retrofit) {
		return retrofit.create(NycOpenDataWebService.class);
	}
}
