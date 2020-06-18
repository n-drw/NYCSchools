package cab.andrew.nycschools.utils.chrometabs;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;

import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.core.content.ContextCompat;

import cab.andrew.nycschools.R;

public class ChromeTabsWrapper implements ServiceConnectionCallback {
	private static final String CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";

	private CustomTabsServiceConnection connection;
	private CustomTabsClient client;
	private Context context;

	public ChromeTabsWrapper(Context context) {
		this.context = context;
	}

	public void openCustomTab(String url) {
		CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
		builder.setExitAnimations(context, R.anim.fade_in, R.anim.fade_out);
		builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary));
		CustomTabsIntent customTabsIntent = builder.build();
		customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		customTabsIntent.launchUrl(context, Uri.parse(url));
	}

	public void bindCustomTabsService() {
		if (client != null) return;
		if (connection == null) {
			connection = new ServiceConnection(this);
		}
		CustomTabsClient.bindCustomTabsService(context, CUSTOM_TAB_PACKAGE_NAME, connection);
	}

	public void unbindCustomTabsService() {
		if (connection == null) return;
		context.unbindService(connection);
		client = null;
		connection = null;
	}

	@Override
	public void onServiceDisconnected() {
		this.client = null;
	}

	@Override
	public void onServiceConnected(CustomTabsClient client) {
		this.client = client;
	}
}
