package com.example.ptbgempa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ptbgempa.Models.DetailData.DetailResponse;
import com.example.ptbgempa.Retrofit.InterfaceData;
import com.example.ptbgempa.Retrofit.RetroGempa;
import com.example.ptbgempa.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    Button backbutton, urlbutton;
    Intent getIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        backbutton = findViewById(R.id.buttonBack);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(DetailActivity.this, com.example.ptbgempa.ListActivity.class);
                startActivity(back);
                finish();
            }
        });

        getIntent = getIntent();
        if (getIntent != null){
            InterfaceData InterfaceData = RetroGempa.getService();
            String idgempa = getIntent.getStringExtra("id_gempa");
            Call<DetailResponse> call = InterfaceData.detailGempa(idgempa);
            call.enqueue(new Callback<DetailResponse>() {
                @Override
                public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                    DetailResponse DetailResponse = response.body();
                    Log.e("Suc", response.toString());
                    DetailResponse.getProperties().getProducts().getOrigin().get(0).getProperties().getLatitude();

                    TextView replaceLokasi = findViewById(R.id.isiLokasi);
                    TextView replaceWaktu = findViewById(R.id.isiWaktu);
                    TextView replaceSkala = findViewById(R.id.isiSkala);
                    TextView replaceLatti = findViewById(R.id.isiLatitude);
                    TextView replaceLongi = findViewById(R.id.isiLongitude);
                    TextView replacetsunami = findViewById(R.id.isiTsunami);
                    TextView replaceUrl = findViewById(R.id.isiURL);

                    String lokasi = DetailResponse.getProperties().getPlace();
                    String waktu = DetailResponse.getProperties().getTime();
                    String skalaaa = DetailResponse.getProperties().getMag();
                    String Laaatt = DetailResponse.getProperties().getProducts().getOrigin().get(0).getProperties().getLatitude();
                    String Lonng = DetailResponse.getProperties().getProducts().getOrigin().get(0).getProperties().getLongitude();
                    String tsunami = DetailResponse.getProperties().getTsunami();
                    String URL = DetailResponse.getProperties().getUrl();

                    replaceLokasi.setText(lokasi);
                    replaceWaktu.setText(waktu);
                    replaceSkala.setText(skalaaa);
                    replaceLatti.setText(Laaatt);
                    replaceLongi.setText(Lonng);
                    replacetsunami.setText(tsunami);
                    replaceUrl.setText(URL);

                    urlbutton = findViewById(R.id.buttonMaps);
                    urlbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String url = URL+"/map";
                            Intent map = new Intent(Intent.ACTION_VIEW);
                            map.setData(Uri.parse(url));
                            startActivity(map);
                        }
                    });

                }

                @Override
                public void onFailure(Call<DetailResponse> call, Throwable t) {
                    Log.e("error", t.getLocalizedMessage());
                }
            });
        }
    }
}