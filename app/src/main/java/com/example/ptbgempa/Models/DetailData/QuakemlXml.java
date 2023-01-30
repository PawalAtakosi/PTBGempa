package com.example.ptbgempa.Models.DetailData;

import com.google.gson.annotations.SerializedName;

public class QuakemlXml{

    @SerializedName("length")
    private int length;

    @SerializedName("lastModified")
    private long lastModified;

    @SerializedName("contentType")
    private String contentType;

    @SerializedName("url")
    private String url;

    public int getLength(){
        return length;
    }

    public long getLastModified(){
        return lastModified;
    }

    public String getContentType(){
        return contentType;
    }

    public String getUrl(){
        return url;
    }
}