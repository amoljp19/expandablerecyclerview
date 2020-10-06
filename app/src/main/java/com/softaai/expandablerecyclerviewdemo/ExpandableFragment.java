package com.softaai.expandablerecyclerviewdemo;
import androidx.core.app.*;
import android.view.*;
import android.os.*;
import androidx.appcompat.widget.*;
import java.util.*;
import com.softaai.expandablerecyclerviewdemo.adapter.*;
import com.softaai.expandablerecyclerviewdemo.model.*;
import android.graphics.drawable.*;
import android.content.*;
import android.graphics.*;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExpandableFragment extends Fragment
{
	private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

	final String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

	final ArrayList<TitleModel> items = new ArrayList<TitleModel>();


	public ExpandableFragment()
	{
		TitleModel riddham = new TitleModel("Riddham", description);
		TitleModel aditya = new TitleModel("Aditya", description);
		TitleModel nirav = new TitleModel("Nirav", description);
		TitleModel kamlesh = new TitleModel("Kamlesh", description);
		TitleModel raghu = new TitleModel("Raghu", description);
		TitleModel sachin = new TitleModel("Sachin", description);
		TitleModel tikku = new TitleModel("Tikku", description);

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
			View v =  inflater.inflate(R.layout.activity_expand, container, false);
			recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);

			//setData();
			LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
			recyclerView.setLayoutManager(layoutManager);

		recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
		recyclerView.setAdapter(new RecyclerAdapter(getActivity(), items));

			return v;
		}
		
		
	public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
		private Drawable mDivider;

		public SimpleDividerItemDecoration(Context context) {
			mDivider = context.getResources().getDrawable(R.drawable.exp_line_divider);
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
