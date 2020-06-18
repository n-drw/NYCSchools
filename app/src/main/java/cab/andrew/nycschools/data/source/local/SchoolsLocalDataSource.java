package cab.andrew.nycschools.data.source.local;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.google.common.base.Preconditions;

import java.util.List;

import javax.inject.Inject;

import cab.andrew.nycschools.data.model.SatScore;
import cab.andrew.nycschools.data.model.School;
import cab.andrew.nycschools.data.source.SchoolsDataSource;
import cab.andrew.nycschools.di.scopes.AppScope;
import cab.andrew.nycschools.utils.Constants;
import cab.andrew.nycschools.utils.schedulers.BaseSchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Completable;
import io.reactivex.Single;

@AppScope
public class SchoolsLocalDataSource implements SchoolsDataSource {
	private final SchoolsDao schoolsDao;
	private BaseSchedulerProvider schedulerProvider;

	@Inject
	public SchoolsLocalDataSource(@NonNull SchoolsDao schoolsDao,
								  @NonNull BaseSchedulerProvider schedulerProvider) {
		Preconditions.checkNotNull(schoolsDao, "schoolsDao cannot be null");
		Preconditions.checkNotNull(schedulerProvider, "schedulerProvider cannot be null");

		this.schoolsDao = schoolsDao;
		this.schedulerProvider = schedulerProvider;
	}

	@NonNull
	@Override
	public Single<List<School>> getSchools() {
		return schoolsDao.getSchools();
	}

	@NonNull
	@Override
	public Single<List<SatScore>> getSatScores() {
		return schoolsDao.getSatScores();
	}

	@NonNull
	@Override
	public Single<School> getSchool(@NonNull String dbn) {
		return schoolsDao.getSchoolByDbn(dbn);
	}

	@NonNull
	@Override
	public Single<SatScore> getSatScore(@NonNull String dbn) {
		return schoolsDao.getSatScoreByDbn(dbn);
	}

	@Override
	public void saveSchools(@NonNull List<School> schools) {
		Preconditions.checkNotNull(schools);
		for (School school : schools) saveSchool(school);
	}

	@Override
	public void saveSchool(@NonNull School school) {
		Preconditions.checkNotNull(school);
		Completable.fromRunnable(() -> schoolsDao.insertSchool(school))
			.subscribeOn(schedulerProvider.io()).subscribe();
	}

	@Override
	public void saveSatScores(@NonNull List<SatScore> satScores) {
		Preconditions.checkNotNull(satScores);
		for (SatScore satScore : satScores) saveSatScore(satScore);
	}

	@Override
	public void saveSatScore(@NonNull SatScore satScore) {
		Preconditions.checkNotNull(satScore);
		Completable.fromRunnable(() -> schoolsDao.insertSatScore(satScore))
			.subscribeOn(schedulerProvider.io()).subscribe();
	}

	@Override
	public void deleteAllSchools() {
		Completable.fromRunnable(schoolsDao::deleteSchools).subscribeOn(schedulerProvider.io()).subscribe();
	}

	@Override
	public void deleteSchool(@NonNull String dbn) {
		Completable.fromRunnable(() -> schoolsDao.deleteSchoolByDbn(dbn))
			.subscribeOn(schedulerProvider.io()).subscribe();
	}

	@Override
	public void deleteSatScore(@NonNull String dbn) {
		Completable.fromRunnable(() -> schoolsDao.deleteSatScoreByDbn(dbn))
			.subscribeOn(schedulerProvider.io()).subscribe();
	}

	@Override
	public void deleteAllSatScores() {
		Completable.fromRunnable(schoolsDao::deleteSatScores).subscribeOn(schedulerProvider.io()).subscribe();
	}
}
