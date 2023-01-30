package com.example.ptbgempa.Models.DetailData;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Products{

    @SerializedName("phase-data")
    private List<PhaseDataItem> phaseData;

    @SerializedName("origin")
    private List<OriginItem> origin;

    public List<PhaseDataItem> getPhaseData(){
        return phaseData;
    }

    public List<OriginItem> getOrigin(){
        return origin;
    }
}