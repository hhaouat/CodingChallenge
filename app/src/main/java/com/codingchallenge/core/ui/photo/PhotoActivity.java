package com.codingchallenge.core.ui.photo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codingchallenge.R;
import com.codingchallenge.core.model.Photo;
import com.codingchallenge.core.tools.WebService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Created by Toshiba on 08/11/2015.
 */
public class PhotoActivity  extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Photo> mPhotoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_recyclerview);

        int albumId = getIntent().getExtras().getInt("albumId") != 0 ? getIntent().getExtras().getInt("albumId") : 1;

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<List<Photo>> photoList = WebService.photoService.listOfPhoto(albumId);

        photoList.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(retrofit.Response<List<Photo>> response, Retrofit retrofit) {
                mPhotoList = response.body();
                MyPhotoAdapter adapt = new MyPhotoAdapter(getApplicationContext(), R.layout.photo_row, mPhotoList);
                recyclerView.setAdapter(adapt);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
