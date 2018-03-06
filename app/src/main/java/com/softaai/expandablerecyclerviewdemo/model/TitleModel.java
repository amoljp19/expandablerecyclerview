package com.softaai.expandablerecyclerviewdemo.model;

import android.annotation.*;
import java.util.*;
import com.softaai.expandablerecyclerviewdemo.expandablerecyclerview.models.*;

@SuppressLint("ParcelCreator")
public class TitleModel extends ExpandableGroup
{
	public TitleModel(String title, String desc)
	{
		super(title, desc);
	}
}
