package cab.andrew.nycschools.ui.list;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cab.andrew.nycschools.data.model.School;
import cab.andrew.nycschools.databinding.ItemSchoolBinding;

public class SchoolListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements SchoolSelectedListener{
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

	@Override
	public void onSchoolSelected(View view) {
		FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
				.addSharedElement(view, "shared_element")
				.build();
	}


	public static class SchoolViewHolder extends RecyclerView.ViewHolder {
		private TextView schoolAddress;
		private TextView schoolName;
		private TextView schoolNumber;
		private SchoolSelectedListener schoolSelectedListener;
//		private ImageView schoolImg;

		public SchoolViewHolder(@NonNull ItemSchoolBinding binding, SchoolSelectedListener schoolSelectedListener) {
			super(binding.getRoot());
			this.schoolSelectedListener = schoolSelectedListener;
//			schoolImg = binding.image;
			schoolAddress = binding.schoolAddressTv;
			schoolName = binding.schoolNameTv;
			schoolNumber = binding.schoolNumberTv;
		}

		public void bind(School school) {
			schoolAddress.setText(school.getPrimaryAddressLine());
			schoolName.setText(school.getSchoolName());
			schoolNumber.setText(school.getPhoneNumber());
		}

//		@Override
//		public void onSchoolSelected(School school) {
//			schoolSelectedListener.onSchoolSelected(school);
//		}
	}
}
