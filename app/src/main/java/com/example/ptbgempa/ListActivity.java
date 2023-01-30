package com.example.ptbgempa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptbgempa.R;
import com.example.ptbgempa.Adapter.AdapterList;
import com.example.ptbgempa.Models.ListData.FeaturesItem;
import com.example.ptbgempa.Models.ListData.ListResponse;
import com.example.ptbgempa.Retrofit.InterfaceData;
import com.example.ptbgempa.Retrofit.RetroGempa;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity implements AdapterList.ItemGempaClickListener {

    private RecyclerView rvLG;
    private AdapterList adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rvLG = findViewById(R.id.rv_listgempa);
        rvLG.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterList();
        adapter.setListenerGMP(this);
        rvLG.setAdapter(adapter);

        InterfaceData InterfaceData = RetroGempa.getService();
        Call<ListResponse> call = InterfaceData.listGempa();
        call.enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                ListResponse ListResponse = response.body();
                Log.e("success", ListResponse.toString());
                if(ListResponse != null){
                    List<FeaturesItem> featuresItems = ListResponse.getFeatures();
                    adapter.setListGempa((ArrayList<FeaturesItem>) featuresItems);
                }
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {
                Log.e("success", t.getLocalizedMessage());
            }
        });

    }

    @Override
    public void onItemGempaClick(FeaturesItem gempa) {

        Intent listGempa = new Intent(this, DetailActivity.class);
        listGempa.putExtra("id_gempa", gempa.getId());
        startActivity(listGempa);
        finish();
    }

}
