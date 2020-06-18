package cab.andrew.nycschools.ui.main;

import androidx.annotation.Nullable;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import cab.andrew.nycschools.databinding.ActivityMainBinding;
import cab.andrew.nycschools.ui.list.ListFragment;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
	final static String TAG = "MainActivity";
	@Inject
	ListFragment injectedFragment;
	private static ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		View view = binding.getRoot();
		testFragment();
		setContentView(view);
//		ListFragment fragment = (ListFragment) getSupportFragmentManager().findFragmentById(binding.contentFrame.getId());
//		if (fragment == null) {
//			fragment = injectedFragment;
//			ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, binding.contentFrame.getId());
//		}
	}

	private void init(){
//		BottomNavigationView navView = binding.navView;
//		AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//		R.id.navigation_home, R.id.navigation_maps, R.id.navigation_about)
//				.build();
//		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//		NavigationUI.setupActionBarWithNavController(this, navController);
//		NavigationUI.setupWithNavController(navView, navController);
//		navView.setOnNavigationItemSelectedListener(this);
	}

	private void testFragment() {
		getSupportFragmentManager().beginTransaction().replace(binding.contentFrame.getId(), new ListFragment())
				.commit();
	}


}
