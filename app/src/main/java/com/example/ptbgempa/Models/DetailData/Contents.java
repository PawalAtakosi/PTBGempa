package com.example.ptbgempa.Models.DetailData;

import com.google.gson.annotations.SerializedName;

public class Contents{

    @SerializedName("quakeml.xml")
    private QuakemlXml quakemlXml;

    @SerializedName("contents.xml")
    private ContentsXml contentsXml;

    public QuakemlXml getQuakemlXml(){
        return quakemlXml;
    }

    public ContentsXml getContentsXml(){
        return contentsXml;
    }
}