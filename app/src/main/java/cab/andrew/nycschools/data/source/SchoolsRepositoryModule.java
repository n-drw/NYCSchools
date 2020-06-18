package cab.andrew.nycschools.data.source;

import cab.andrew.nycschools.data.source.local.SchoolsDao;
import cab.andrew.nycschools.data.source.local.SchoolsLocalDataModule;
import cab.andrew.nycschools.data.source.local.SchoolsLocalDataSource;
import cab.andrew.nycschools.data.source.remote.NycOpenDataWebService;
import cab.andrew.nycschools.data.source.remote.SchoolsRemoteDataModule;
import cab.andrew.nycschools.data.source.remote.SchoolsRemoteDataSource;
import cab.andrew.nycschools.data.source.scopes.Local;
import cab.andrew.nycschools.data.source.scopes.Remote;
import cab.andrew.nycschools.di.scopes.AppScope;
import cab.andrew.nycschools.utils.schedulers.BaseSchedulerProvider;
import dagger.Module;
import dagger.Provides;

@Module(includes = {SchoolsLocalDataModule.class, SchoolsRemoteDataModule.class})
public class SchoolsRepositoryModule {
	@Provides
	@Local
	@AppScope
	SchoolsDataSource provideSchoolsLocalDataSource(SchoolsDao schoolsDao, BaseSchedulerProvider schedulerProvider){
		return new SchoolsLocalDataSource(schoolsDao, schedulerProvider);
	}

	@Provides
	@Remote
	@AppScope
	SchoolsDataSource provideSchoolsRemoteDataSource(NycOpenDataWebService nycOpenDataWebService) {
		return new SchoolsRemoteDataSource(nycOpenDataWebService);
	}
}
