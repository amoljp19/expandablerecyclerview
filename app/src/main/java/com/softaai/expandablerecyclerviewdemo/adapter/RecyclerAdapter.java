package com.softaai.expandablerecyclerviewdemo.adapter;
import android.app.*;
import java.util.*;
import android.view.*;
import com.softaai.expandablerecyclerviewdemo.model.*;
import com.softaai.expandablerecyclerviewdemo.viewHolder.*;
import com.softaai.expandablerecyclerviewdemo.R;
import com.softaai.expandablerecyclerviewdemo.expandablerecyclerview.*;
import com.softaai.expandablerecyclerviewdemo.expandablerecyclerview.models.*;

public class RecyclerAdapter extends ExpandableRecyclerViewAdapter<TitleViewHolder, DescriptionViewHolder> {

    private Activity activity;

//    public RecyclerAdapter(Activity activity, List<? extends ExpandableGroup> groups) {
//        super(groups);
//        this.activity = activity;
//    }
	
	public RecyclerAdapter(Activity activity, List<TitleModel> groups) {
        super(groups);
        this.activity = activity;
    }

    @Override
    public TitleViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.group_view_holder, parent, false);

        return new TitleViewHolder(view);
    }

    @Override
    public DescriptionViewHolder onCreateChildViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.child_view_holder, parent, false);

        return new DescriptionViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(DescriptionViewHolder descriptionHolder, int flatPosition, ExpandableGroup group, int childIndex) {
       // final DescriptionModel description = ((TitleModel) group).getItems().get(childIndex);
		final String description = (String) group.getDescription();
        descriptionHolder.onBind(description, group);
    }

    @Override
    public void onBindGroupViewHolder(TitleViewHolder descriptionHolder, int flatPosition, ExpandableGroup group) {
        descriptionHolder.setGroupName(group);
    }
}

