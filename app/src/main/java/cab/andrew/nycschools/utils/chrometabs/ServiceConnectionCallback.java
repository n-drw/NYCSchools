package cab.andrew.nycschools.utils.chrometabs;

import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;

public interface ServiceConnectionCallback {
	void onServiceConnected(CustomTabsClient client);

	void onServiceDisconnected();
}
