package com.example.ptbgempa.Models.DetailData;

import com.google.gson.annotations.SerializedName;

public class OriginItem{

    @SerializedName("indexTime")
    private long indexTime;

    @SerializedName("code")
    private String code;

    @SerializedName("contents")
    private Contents contents;

    @SerializedName("indexid")
    private String indexid;

    @SerializedName("preferredWeight")
    private int preferredWeight;

    @SerializedName("updateTime")
    private long updateTime;

    @SerializedName("id")
    private String id;

    @SerializedName("source")
    private String source;

    @SerializedName("type")
    private String type;

    @SerializedName("properties")
    private Properties properties;

    @SerializedName("status")
    private String status;

    public long getIndexTime(){
        return indexTime;
    }

    public String getCode(){
        return code;
    }

    public Contents getContents(){
        return contents;
    }

    public String getIndexid(){
        return indexid;
    }

    public int getPreferredWeight(){
        return preferredWeight;
    }

    public long getUpdateTime(){
        return updateTime;
    }

    public String getId(){
        return id;
    }

    public String getSource(){
        return source;
    }

    public String getType(){
        return type;
    }

    public Properties getProperties(){
        return properties;
    }

    public String getStatus(){
        return status;
    }
}