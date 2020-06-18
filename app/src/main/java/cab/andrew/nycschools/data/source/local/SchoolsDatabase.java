package cab.andrew.nycschools.data.source.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import cab.andrew.nycschools.data.model.SatScore;
import cab.andrew.nycschools.data.model.School;

@Database(entities = {School.class, SatScore.class}, version = 1, exportSchema = false)
public abstract class SchoolsDatabase extends RoomDatabase {
	public abstract SchoolsDao schoolsDao();
}
