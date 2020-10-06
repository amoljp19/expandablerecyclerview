package com.softaai.expandablerecyclerviewdemo;
import androidx.core.app.*;
import android.view.*;
import android.os.*;
import androidx.appcompat.widget.*;

import java.util.*;
import android.graphics.drawable.*;
import android.content.*;
import android.graphics.*;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softaai.expandablerecyclerviewdemo.model.*;

public class BasicFragment extends Fragment
{
	private static final int VERTICAL_ITEM_SPACE = 10;

	final String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

	final ArrayList<BasicResponseModel> items = new ArrayList<BasicResponseModel>();

	RecyclerView recyclerView;
	
	public BasicFragment()
	{
		BasicResponseModel riddham = new BasicResponseModel("Riddham", "Sub Title1", description , "6999011");
		BasicResponseModel aditya = new BasicResponseModel("Aditya", "Sub Title2", description , "7899011");
		BasicResponseModel nirav = new BasicResponseModel("Nirav", "Sub Title3", description , "9899011");
		BasicResponseModel kamlesh = new BasicResponseModel("Kamlesh", "Sub Title4", description , "4399011");
		BasicResponseModel raghu = new BasicResponseModel("Raghu", "Sub Title5", description , "7399011");
		BasicResponseModel sachin = new BasicResponseModel("Sachin", "Sub Title6", description , "8599011");
		BasicResponseModel tikku = new BasicResponseModel("Tikku", "Sub Title7", description , "4739011");

		items.add(riddham);
		items.add(aditya);
		items.add(nirav);
		items.add(kamlesh);
		items.add(raghu);
		items.add(sachin);
		items.add(tikku);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v =  inflater.inflate(R.layout.fragment_list_view, container, false);
            final RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		
		    recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
		    recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
		    recyclerView.setAdapter(new BasicRecyclerAdapter(getActivity(), items));

		return v;
	}
	

	public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
		private Drawable mDivider;

		public SimpleDividerItemDecoration(Context context) {
			mDivider = context.getResources().getDrawable(R.drawable.line_divider);
		}

		@Override
		public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
			int left = parent.getPaddingLeft();
			int right = parent.getWidth() - parent.getPaddingRight();

			int childCount = parent.getChildCount();
			for (int i = 0; i < childCount; i++) {
				View child = parent.getChildAt(i);

				RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

				int top = child.getBottom() + params.bottomMargin;
				int bottom = top + mDivider.getIntrinsicHeight();

				mDivider.setBounds(left, top, right, bottom);
				mDivider.draw(c);
			}
		}
	}
	
	public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

		private final int space;

		public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
			this.space = verticalSpaceHeight;
		}

		@Override
		public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
								   RecyclerView.State state) {
		
			outRect.left = space;
			outRect.right = space;
			outRect.bottom = space;

			// Add top margin only for the first item to avoid double space between items
			if(parent.getChildPosition(view) == 0)
				outRect.top = space;
		}
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onResume()
	{
		// TODO: Implement this method
		super.onResume();
	}

	@Override
	public void onPause()
	{
		// TODO: Implement this method
		super.onPause();
	}


	@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
	
}
