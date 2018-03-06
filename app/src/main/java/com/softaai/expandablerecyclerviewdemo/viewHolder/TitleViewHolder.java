package com.softaai.expandablerecyclerviewdemo.viewHolder;
import android.view.*;
import android.widget.*;
import android.util.*;
import com.softaai.expandablerecyclerviewdemo.*;
import com.softaai.expandablerecyclerviewdemo.expandablerecyclerview.viewholders.*;
import com.softaai.expandablerecyclerviewdemo.expandablerecyclerview.models.*;

public class TitleViewHolder extends GroupViewHolder
{
	private TextView titleTextView;
	public TitleViewHolder(View itemView)
	{
		super(itemView);
		
		titleTextView = (TextView) itemView.findViewById(R.id.title_text_view);
	}
		
	@Override
    public void expand() {
        titleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_up, 0);
        Log.i("Adapter", "expand");
    }

    @Override
    public void collapse() {
        Log.i("Adapter", "collapse");
        titleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down, 0);
    }

    public void setGroupName(ExpandableGroup group) {
        titleTextView.setText(group.getTitle());
    }
	
}
