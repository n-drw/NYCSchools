package cab.andrew.nycschools.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class ScrollChildSwipeRefresh extends SwipeRefreshLayout {
	private View mScrollUpChild;

	public ScrollChildSwipeRefresh(Context context) {
												  super(context);
																 }

	public ScrollChildSwipeRefresh(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean canChildScrollUp() {
		if (mScrollUpChild != null) {
			return canScrollHorizontally(-1);
		}
		return super.canChildScrollUp();
	}

	public void setScrollUpChild(View view) {
		mScrollUpChild = view;
	}
}
