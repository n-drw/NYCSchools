package cab.andrew.nycschools.utils.providers;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import dagger.internal.Preconditions;

public class ResourceProvider implements BaseResourceProvider{
	@NonNull
	private final Context context;

	public ResourceProvider(@NonNull Context context) {
		this.context = Preconditions.checkNotNull(context, "context cannot be null");
	}

	@NonNull
	@Override
	public String getString(@StringRes final int id) {
		return context.getString(id);
	}

	@NonNull
	@Override
	public String getString(@StringRes final int id, final Object... formatArgs) {
		return context.getString(id, formatArgs);
	}
}
