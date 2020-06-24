package cab.andrew.nycschools.ui.list;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavAction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cab.andrew.nycschools.R;
import cab.andrew.nycschools.data.model.School;
import cab.andrew.nycschools.databinding.ItemSchoolBinding;
import cab.andrew.nycschools.di.module.ContextModule;

public class SchoolListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private List<School> schools = new ArrayList<>();
	private ItemSchoolBinding binding;
	private static String TAG = "SchoolListAdapter";
	private SchoolSelectedListener schoolSelectedListener;

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		ItemSchoolBinding binding = ItemSchoolBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
//		SchoolViewHolder viewHolder = new SchoolViewHolder(binding);
//		binding.getRoot().setOnClickListener(onClickListener -> {
//
//		});
		return new SchoolViewHolder(binding, schoolSelectedListener);
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		((SchoolViewHolder)holder).bind(schools.get(position));
	}

	@Override
	public int getItemCount() {
		Log.d(TAG, schools.toString());
		return schools.size();
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
		notifyDataSetChanged();
	}




	public static class SchoolViewHolder extends RecyclerView.ViewHolder implements SchoolSelectedListener {
		private TextView schoolAddress;
		private TextView schoolName;
		private TextView schoolNumber;
		private ItemSchoolBinding binding;
		private View itemView;
//		private ImageView schoolImg;

		public SchoolViewHolder(@NonNull ItemSchoolBinding binding, SchoolSelectedListener schoolSelectedListener) {
			super(binding.getRoot());
//			schoolImg = binding.image;
			schoolAddress = binding.schoolAddressTv;
			schoolName = binding.schoolNameTv;
			schoolNumber = binding.schoolNumberTv;
			itemView = binding.getRoot();

			itemView.setOnClickListener(v -> schoolSelectedListener.onSchoolSelected(v));
		}


		public void bind(School school) {
			schoolAddress.setText(school.getPrimaryAddressLine());
			schoolName.setText(school.getSchoolName());
			schoolNumber.setText(school.getPhoneNumber());

			schoolNumber.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Log.d("Phone number", "Clicked: " + schoolNumber);
					String uri = "tel:" + schoolNumber.getText();
					Log.d("Phone uri", "Clicked: " + uri);
					Intent callIntent = new Intent(Intent.ACTION_DIAL);
					callIntent.setData(Uri.parse(uri));
//					context.startActivity(callIntent);
					itemView.getContext().startActivity(callIntent);
				}
			});
		}

		@Override
		public void onSchoolSelected(View view) {
			FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
					.addSharedElement(view, "shared_element")
					.build();
			NavDirections action = ListFragmentDirections.actionNavigationHomeToDetailsFragment();
			Navigation.findNavController(view).navigate(action, extras);
		}

//		@Override
//		public void onSchoolSelected(School school) {
//			schoolSelectedListener.onSchoolSelected(school);
//		}
	}
}
