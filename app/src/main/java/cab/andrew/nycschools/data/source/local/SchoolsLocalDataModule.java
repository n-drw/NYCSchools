package cab.andrew.nycschools.data.source.local;

import android.app.Application;

import androidx.room.Room;

import cab.andrew.nycschools.data.model.SatScore;
import cab.andrew.nycschools.di.scopes.AppScope;
import cab.andrew.nycschools.utils.Constants;
import dagger.Module;
import dagger.Provides;

@Module
public class SchoolsLocalDataModule {
	@AppScope
	@Provides
	SchoolsDatabase provideDb(Application context) {
		return Room.databaseBuilder(context.getApplicationContext(),
			SchoolsDatabase.class, Constants.SCHOOLS_ROOM_DB_STRING).build();
	}

	@AppScope
	@Provides
	SchoolsDao provideSchoolsDao(SchoolsDatabase db) {
		return db.schoolsDao();
	}
}
