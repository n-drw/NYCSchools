package cab.andrew.nycschools.data.source.remote;

import java.util.List;

import cab.andrew.nycschools.data.model.SatScore;
import cab.andrew.nycschools.data.model.School;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NycOpenDataWebService {

	@GET("s3k6-pzi2.json")
	Single<List<School>> getSchools();

	@GET("f9bf-2cp4.json")
	Single<List<SatScore>> getSatScores();

	@GET("f9bf-2cp4.json")
	//API is spotty when single querying a borough due to faulty data entries and SODA uses SQL for querying
	//https://data.cityofnewyork.us/resource/s3k6-pzi2.json?$where=starts_with(borough,%20%27BROOKLYN%27)
	Single<School> getSchool(@Query("dbn") String dbn);

	@GET("f9bf-2cp4.json")
	Single<SatScore> getSatScore(@Query("dbn") String dbn);
}
