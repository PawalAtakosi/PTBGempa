package com.example.ptbgempa.Retrofit;

import com.example.ptbgempa.Models.DetailData.DetailResponse;
import com.example.ptbgempa.Models.ListData.ListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfaceData {

    @GET("feed/v1.0/summary/2.5_day.geojson")
    Call<ListResponse> listGempa (

    );

    @GET("feed/v1.0/detail/{id_gempa}.geojson")
    Call<DetailResponse> detailGempa (
            @Path("id_gempa") String id
    );

}
