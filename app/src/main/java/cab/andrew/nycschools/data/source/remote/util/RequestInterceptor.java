package cab.andrew.nycschools.data.source.remote.util;

import java.io.IOException;

import javax.inject.Inject;

import cab.andrew.nycschools.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {
	@Inject
	public RequestInterceptor(){}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request originalRequest = chain.request();
		HttpUrl originalUrl = originalRequest.url();

		HttpUrl url = originalUrl.newBuilder()
			.addQueryParameter("$$app_token", BuildConfig.APP_TOKEN)
			.build();
		Request request = originalRequest.newBuilder().url(url).build();
		return chain.proceed(request);
	}
}
