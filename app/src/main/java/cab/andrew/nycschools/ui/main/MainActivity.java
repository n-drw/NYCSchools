package cab.andrew.nycschools.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import javax.inject.Inject;

import cab.andrew.nycschools.R;
import cab.andrew.nycschools.databinding.ActivityMainBinding;
import cab.andrew.nycschools.ui.list.ListFragment;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
	private static ActivityMainBinding binding;
	private BottomNavigationView navigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		View view = binding.getRoot();
		setContentView(view);
		navigationView = binding.navView;
		init();
	}

	private void init(){
		AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
		R.id.navigation_home, R.id.navigation_maps, R.id.navigation_about)
				.build();
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
		NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
		NavigationUI.setupWithNavController(navigationView, navController);
		navigationView.setOnNavigationItemSelectedListener(this);
	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
		switch (item.getItemId())	{
			case R.id.navigation_home: {
				NavOptions navOptions = new NavOptions.Builder()
						.setPopUpTo(R.id.mobile_navigation, true)
						.build();

				Navigation.findNavController(this, R.id.nav_host_fragment).navigate(
						R.id.navigation_home,
						null,
						navOptions
				);
				break;
			}

			case R.id.navigation_maps: {
				if(isValidDestination(R.id.navigation_maps)) {
					Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.navigation_maps);
				}
				break;
			}

			case R.id.navigation_about: {
				if(isValidDestination(R.id.navigation_about)) {
					Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.navigation_about);
				}
				break;
			}
		}
		item.setChecked(true);
		return true;
	}


	private boolean isValidDestination(int destination){
		return destination != Navigation.findNavController(this, R.id.nav_host_fragment).getCurrentDestination().getId();
	}

}
