package cab.andrew.nycschools.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.jetbrains.annotations.NotNull;

public class ActivityUtils {
	public static void addFragmentToActivity(FragmentManager manager, Fragment fragment, int frameId) {
			FragmentTransaction transaction = manager.beginTransaction();
			transaction.add(frameId, fragment);
			transaction.commit();
		}
	}
