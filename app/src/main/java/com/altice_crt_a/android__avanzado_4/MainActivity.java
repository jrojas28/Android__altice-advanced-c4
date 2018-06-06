package com.altice_crt_a.android__avanzado_4;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;

import com.altice_crt_a.android__avanzado_4.classes.HTTPClient;
import com.altice_crt_a.android__avanzado_4.classes.Photo;
import com.altice_crt_a.android__avanzado_4.classes.PhotoAdapter;
import com.altice_crt_a.android__avanzado_4.classes.User;
import com.altice_crt_a.android__avanzado_4.interfaces.JSONPlaceholderService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private HTTPClient http;
    private Handler httpHandler;
    RecyclerView recyclerView;
    PhotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new PhotoAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapter);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceholderService service = retrofit.create(JSONPlaceholderService.class);

        Call<List<Photo>> photos = service.listPhotos();
        photos.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                List<Photo> photos = response.body();
                adapter.updateData(photos);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.wtf("JSONPLACEHOLDERSERVICE", t.toString());
            }
        });
    }
}
