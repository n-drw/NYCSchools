package cab.andrew.nycschools.data.source.local;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import cab.andrew.nycschools.data.model.SatScore;
import cab.andrew.nycschools.data.model.School;
import io.reactivex.Single;

@Dao
public interface SchoolsDao {
	@Query("SELECT * FROM schools")
	Single<List<School>> getSchools();

	@Query("SELECT * FROM sat_scores")
	Single<List<SatScore>> getSatScores();

	@Query("SELECT * FROM schools WHERE dbn = :dbn")
	Single<School> getSchoolByDbn(String dbn);

	@Query("SELECT * FROM sat_scores WHERE dbn = :dbn")
	Single<SatScore> getSatScoreByDbn(String dbn);

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insertSchool(School school);

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insertSatScore(SatScore satScore);

	@Query("DELETE FROM schools WHERE dbn = :dbn")
	int deleteSchoolByDbn(String dbn);

	@Query("DELETE FROM sat_scores WHERE dbn = :dbn")
	int deleteSatScoreByDbn(String dbn);

	@Query("DELETE FROM sat_scores")
	void deleteSatScores();

	@Query("DELETE FROM schools")
	void deleteSchools();


	@Update
	int updateSchool(School school);

	@Update
	int updateSatScore(SatScore satScore);
}
