package cab.andrew.nycschools.utils.connectivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.IntRange;

public class DefaultOnlineChecker implements OnlineChecker {
	private final ConnectivityManager connectivityManager;
	private boolean isConnected = false;
	private static final int NO_NETWORK_AVAILABLE = -1;
	public static final int TRANSPORT_CELLULAR = 0;
	public static final int TRANSPORT_WIFI = 1;

	public DefaultOnlineChecker(ConnectivityManager connectivityManager) {
		this.connectivityManager = connectivityManager;
	}

	@Override
	public boolean isOnline() {
		Network[] networks  = connectivityManager.getAllNetworks();
		for (Network network : networks) {
			NetworkCapabilities networkAvailability = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
			if(networkAvailability != null && networkAvailability.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) && networkAvailability.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
				if(networkAvailability.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || networkAvailability.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
					isConnected = true;
				}
			}
		}
		return isConnected;
	}
}
