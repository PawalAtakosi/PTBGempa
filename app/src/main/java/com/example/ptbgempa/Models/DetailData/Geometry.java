package com.example.ptbgempa.Models.DetailData;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Geometry{

    @SerializedName("coordinates")
    private List<Object> coordinates;

    @SerializedName("type")
    private String type;

    public List<Object> getCoordinates(){
        return coordinates;
    }

    public String getType(){
        return type;
    }
}