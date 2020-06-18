package cab.andrew.nycschools.data.source.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import cab.andrew.nycschools.data.model.SatScore;
import cab.andrew.nycschools.data.model.School;
import cab.andrew.nycschools.data.source.SchoolsDataSource;
import io.reactivex.Observable;
import io.reactivex.Single;

public class SchoolsRemoteDataSource implements SchoolsDataSource {
	private static final String TAG = "RemoteDataSource";

	@NonNull
	private NycOpenDataWebService nycOpenDataWebService;

	@Inject
	public SchoolsRemoteDataSource(@NonNull NycOpenDataWebService nycOpenDataWebService) {
		this.nycOpenDataWebService = nycOpenDataWebService;
	}

	@NonNull
	@Override
	public Single<List<School>> getSchools() {
		return nycOpenDataWebService.getSchools()
			.flatMap(response -> Observable.fromIterable(response).toList());
	}

	@NonNull
	@Override
	public Single<List<SatScore>> getSatScores() {
		return nycOpenDataWebService.getSatScores()
			.flatMap(response -> Observable.fromIterable(response).toList());
	}

	@NonNull
	@Override
	public Single<School> getSchool(@NonNull String dbn) {
		Log.d(TAG, nycOpenDataWebService.getSchools().toString());
		return nycOpenDataWebService.getSchool(dbn);
	}

	@NonNull
	@Override
	public Single<SatScore> getSatScore(@NonNull String dbn) {
		Log.d(TAG, nycOpenDataWebService.getSatScores().toString());
		return nycOpenDataWebService.getSatScore(dbn);
	}

	@Override
	public void saveSchools(@NonNull List<School> schools) {
	}

	@Override
	public void saveSchool(@NonNull School school) {
	}

	@Override
	public void saveSatScores(@NonNull List<SatScore> satScores) {
	}

	@Override
	public void saveSatScore(@NonNull SatScore satScore) {
	}

	@Override
	public void deleteAllSchools() {
	}

	@Override
	public void deleteSchool(@NonNull String dbn) {
	}

	@Override
	public void deleteSatScore(@NonNull String dbn) {
	}

	@Override
	public void deleteAllSatScores() {
	}
}
