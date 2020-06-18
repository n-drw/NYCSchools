package cab.andrew.nycschools.data.source;

import androidx.annotation.NonNull;

import java.util.List;

import cab.andrew.nycschools.data.model.SatScore;
import cab.andrew.nycschools.data.model.School;
import io.reactivex.Single;
import retrofit2.http.Path;

public interface SchoolsDataSource {
	@NonNull
	Single<List<School>> getSchools();

	@NonNull
	Single<List<SatScore>> getSatScores();

	@NonNull
	Single<School> getSchool(@NonNull String dbn);

	@NonNull
	Single<SatScore> getSatScore(@NonNull String dbn);

	void saveSchools(@NonNull List<School> schools);

	void saveSchool(@NonNull School school);

	void saveSatScores(@NonNull List<SatScore> satScores);

	void saveSatScore(@NonNull SatScore satScore);

	void deleteAllSchools();

	void deleteSchool(@NonNull String dbn);

	void deleteSatScore(@NonNull String dbn);

	void deleteAllSatScores();
}
