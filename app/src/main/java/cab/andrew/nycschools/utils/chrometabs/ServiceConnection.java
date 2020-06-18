package cab.andrew.nycschools.utils.chrometabs;

import android.content.ComponentName;

import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;

import java.lang.ref.WeakReference;

public class ServiceConnection extends CustomTabsServiceConnection {
	private WeakReference<ServiceConnectionCallback> connectionCallback;

	public ServiceConnection(ServiceConnectionCallback connectionCallback) {
		this.connectionCallback = new WeakReference<>(connectionCallback);
	}

	@Override
	public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
		ServiceConnectionCallback connectionCallback = this.connectionCallback.get();
		if(connectionCallback != null) connectionCallback.onServiceConnected(client);
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		ServiceConnectionCallback connectionCallback = this.connectionCallback.get();
		if (connectionCallback != null) connectionCallback.onServiceDisconnected();;
	}
}
