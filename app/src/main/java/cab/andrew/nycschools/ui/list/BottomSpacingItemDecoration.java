package cab.andrew.nycschools.ui.list;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.Px;
import androidx.recyclerview.widget.RecyclerView;

public class BottomSpacingItemDecoration extends RecyclerView.ItemDecoration {
	@Px
	private final int spacing;

	private boolean lastItem;

	public BottomSpacingItemDecoration(int spacing) {
		this.spacing = spacing;
	}

	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
		lastItem = parent.getChildAdapterPosition(view) == state.getItemCount() - 1;
		if(!lastItem) {
			outRect.bottom = spacing;
		} else {
			outRect.bottom = 0;
		}
	}
}
