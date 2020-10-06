package com.softaai.expandablerecyclerviewdemo.expandablerecyclerview.viewholders;
import androidx.appcompat.widget.*;
import com.softaai.expandablerecyclerviewdemo.expandablerecyclerview.listeners.*;
import android.view.*;
import android.view.View.*;

import androidx.recyclerview.widget.RecyclerView;

public abstract class GroupViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

	private OnGroupClickListener listener;

	public GroupViewHolder(View itemView) {
		super(itemView);
		itemView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (listener != null) {
			listener.onGroupClick(getAdapterPosition());
		}
	}

	public void setOnGroupClickListener(OnGroupClickListener listener) {
		this.listener = listener;
	}

	public void expand() {}

	public void collapse() {}
}
