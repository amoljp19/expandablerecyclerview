package com.softaai.expandablerecyclerviewdemo.viewHolder;

import android.widget.*;
import android.view.*;
import com.softaai.expandablerecyclerviewdemo.model.*;
import com.softaai.expandablerecyclerviewdemo.*;
import com.softaai.expandablerecyclerviewdemo.expandablerecyclerview.viewholders.*;
import com.softaai.expandablerecyclerviewdemo.expandablerecyclerview.models.*;

public class DescriptionViewHolder extends ChildViewHolder
{
	private TextView descriptionTv;

    public DescriptionViewHolder(View itemView) {
        super(itemView);

        descriptionTv = (TextView) itemView.findViewById(R.id.description_tv);
    }

//    public void onBind(DescriptionModel descriptionModel, ExpandableGroup group) {
//        descriptionTv.setText(descriptionModel.getDescription());
////        if (group.getTitle().equals("Android")) {
////            descriptionTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher, 0, 0, 0);
////        } else if (group.getTitle().equals("iOS")) {
////            descriptionTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher, 0, 0, 0);
////        } else {
////            descriptionTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_done, 0, 0, 0);
////        }
//    }
	
	
    
	
	public void onBind(String description, ExpandableGroup group) {
        descriptionTv.setText(description);
//        if (group.getTitle().equals("Android")) {
//            descriptionTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher, 0, 0, 0);
//        } else if (group.getTitle().equals("iOS")) {
//            descriptionTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher, 0, 0, 0);
//        } else {
//            descriptionTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_done, 0, 0, 0);
//        }
    }
}
