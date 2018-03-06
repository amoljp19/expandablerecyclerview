package com.softaai.expandablerecyclerviewdemo.model;

public class BasicResponseModel
{
	private String title;
    private String subTitle;
	private String desc;
    private String timeStampMillis;

    public BasicResponseModel(String title, String subTitle, String desc, String timeStampMillis)
    {
        this.title = title;
        this.subTitle = subTitle;
        this.desc = desc;
        this.timeStampMillis = timeStampMillis;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
	
	public String getDescription()
	{
		return desc;
	}

    public String getTimeStamp() {
        return timeStampMillis;
    }
}
