package com.softaai.expandablerecyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.*;
import com.softaai.expandablerecyclerviewdemo.R;
import com.softaai.expandablerecyclerviewdemo.model.*;
import android.os.*;
import java.util.concurrent.*;
import android.util.*;
import android.app.*;

/**

 */
public class BasicRecyclerAdapter extends RecyclerView.Adapter<BasicRecyclerAdapter.ViewHolder> 
{
    Activity activity;
    public List<BasicResponseModel> mItems;
	
	
	
    public BasicRecyclerAdapter(Activity activity, List<BasicResponseModel> items) {
        this.activity = activity;
		mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        BasicResponseModel item = mItems.get(i);
        viewHolder.titleTextView.setText(item.getTitle());
		viewHolder.subTitleTextView.setText(item.getSubTitle());
	
	    
		new CountDownTimer(Long.parseLong(item.getTimeStamp()), 1000) { 

			public void onTick(final long millisUntilFinished) {
				
				activity.runOnUiThread(new Runnable() {
						@Override
						public void run() {
						
							String hms = String.format("%02d : %02d : %02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
													   TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
													   TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
							viewHolder.timeStampTextView.setText(hms);					   
							
						}
					});
				
			}

			public void onFinish() {
				
		       
				activity.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Log.e("time", "0 called");

							String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(0),
													   TimeUnit.MILLISECONDS.toMinutes(0) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(0)),
													   TimeUnit.MILLISECONDS.toSeconds(0) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(0)));
							viewHolder.timeStampTextView.setText(hms);					   

						}
					});
				
			   
				
			}
		}.start();
	
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
	{

        private final TextView titleTextView;
		private final TextView subTitleTextView;
		private final TextView timeStampTextView;

        ViewHolder(View v) {
            super(v);
            titleTextView = (TextView)v.findViewById(R.id.title);
			
			subTitleTextView = (TextView)v.findViewById(R.id.sub_title);
			
			timeStampTextView = (TextView)v.findViewById(R.id.time);
        }
    }
}
	
	

	
