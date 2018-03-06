package com.softaai.expandablerecyclerviewdemo.model;
import android.os.*;

public class DescriptionModel implements Parcelable
{
	private String description;

	public DescriptionModel(Parcel in)
	{
		description = in.readString();
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DescriptionModel(String description) {
        this.description = description;
    }

	@Override
	public int describeContents()
	{
		// TODO: Implement this method
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		// TODO: Implement this method
		dest.writeString(description);
	}

	public static final Creator<DescriptionModel> CREATOR = new Creator<DescriptionModel>() {
        @Override
        public DescriptionModel createFromParcel(Parcel in) {
            return new DescriptionModel(in);
        }

        @Override
        public DescriptionModel[] newArray(int size) {
            return new DescriptionModel[size];
        }
    };
}
