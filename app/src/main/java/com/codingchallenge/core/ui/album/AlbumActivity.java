package com.codingchallenge.core.ui.album;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codingchallenge.R;
import com.codingchallenge.core.model.Album;
import com.codingchallenge.core.tools.WebService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Created by Toshiba on 08/11/2015.
 */
public class AlbumActivity  extends AppCompatActivity {

        private RecyclerView recyclerView;
        List<Album> mAlbumList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_album_recyclerview);

            int userId = getIntent().getExtras().getInt("userId") != 0 ? getIntent().getExtras().getInt("userId") : 1;
            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            Call<List<Album>> albumList = WebService.albumService.listOfAlbum(userId);

            albumList.enqueue(new Callback<List<Album>>() {
                @Override
                public void onResponse(retrofit.Response<List<Album>> response, Retrofit retrofit) {
                    mAlbumList = response.body();
                    MyAlbumAdapter adapt = new MyAlbumAdapter(getApplicationContext(), R.layout.album_row, mAlbumList);
                    recyclerView.setAdapter(adapt);
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
