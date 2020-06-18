package cab.andrew.nycschools.data.source;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import cab.andrew.nycschools.data.model.SatScore;
import cab.andrew.nycschools.data.model.School;
import cab.andrew.nycschools.data.source.scopes.Local;
import cab.andrew.nycschools.data.source.scopes.Remote;
import cab.andrew.nycschools.di.scopes.AppScope;
import cab.andrew.nycschools.utils.connectivity.OnlineChecker;
import dagger.internal.Preconditions;
import io.reactivex.Single;

@AppScope
public class SchoolsRepository implements SchoolsDataSource {
	private final SchoolsDataSource schoolsRemoteDataSource;
	private final SchoolsDataSource schoolsLocalDataSource;
	private final OnlineChecker onlineChecker;

	@Inject
	public SchoolsRepository(@Remote SchoolsDataSource schoolsRemoteDataSource,
							 @Local SchoolsDataSource schoolsLocalDataSource,
							 OnlineChecker onlineChecker){
		this.schoolsRemoteDataSource = schoolsRemoteDataSource;
		this.schoolsLocalDataSource = schoolsLocalDataSource;
		this.onlineChecker = onlineChecker;
	}

	@NonNull
	@Override
	public Single<List<School>> getSchools() {
		return schoolsLocalDataSource.getSchools()
			.flatMap(data -> {
				if(onlineChecker.isOnline() && (data.isEmpty())) {
					return getFreshSchools();
				}
				return Single.just(sortByNewest(data));
			});
	}

	@NonNull
	@Override
	public Single<List<SatScore>> getSatScores() {
		return schoolsLocalDataSource.getSatScores();
	}

	@NonNull
	@Override
	public Single<School> getSchool(@NonNull String dbn) {
		return schoolsLocalDataSource.getSchool(dbn);
	}

	@NonNull
	@Override
	public Single<SatScore> getSatScore(@NonNull String dbn) {
		return schoolsLocalDataSource.getSatScore(dbn);
	}

	@Override
	public void saveSchools(@NonNull List<School> schools) {
		Preconditions.checkNotNull(schools);
		schoolsLocalDataSource.saveSchools(schools);
		schoolsRemoteDataSource.saveSchools(schools);
	}

	@Override
	public void saveSchool(@NonNull School school) {
		Preconditions.checkNotNull(school);
		schoolsLocalDataSource.saveSchool(school);
		schoolsRemoteDataSource.saveSchool(school);
	}

	@Override
	public void saveSatScores(@NonNull List<SatScore> satScores) {
		Preconditions.checkNotNull(satScores);
		schoolsLocalDataSource.saveSatScores(satScores);
		schoolsRemoteDataSource.saveSatScores(satScores);
	}

	@Override
	public void saveSatScore(@NonNull SatScore satScore) {
		Preconditions.checkNotNull(satScore);
		schoolsLocalDataSource.saveSatScore(satScore);
		schoolsRemoteDataSource.saveSatScore(satScore);
	}

	@Override
	public void deleteAllSchools() {
		schoolsLocalDataSource.deleteAllSchools();
		schoolsRemoteDataSource.deleteAllSchools();
	}

	@Override
	public void deleteSchool(@NonNull String dbn) {
		schoolsLocalDataSource.deleteSchool(dbn);
		schoolsRemoteDataSource.deleteSchool(dbn);
	}

	@Override
	public void deleteSatScore(@NonNull String dbn) {
		schoolsLocalDataSource.deleteSatScore(dbn);
		schoolsRemoteDataSource.deleteSatScore(dbn);
	}

	@Override
	public void deleteAllSatScores() {

	}

	private List<School> sortByNewest(List<School> list) {
		Collections.sort(list, (e1, e2) -> e1.getDbn().compareTo(e2.getDbn()));
		return list;
	}

	private Single<List<School>> getFreshSchools() {
		deleteAllSchools();
		return schoolsRemoteDataSource.getSchools().doOnSuccess(this::saveSchools);
	}
}
