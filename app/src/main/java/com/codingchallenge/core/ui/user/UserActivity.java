package com.codingchallenge.core.ui.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codingchallenge.R;
import com.codingchallenge.core.model.User;
import com.codingchallenge.core.tools.WebService;

import java.util.Collections;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Created by Toshiba on 08/11/2015.
 */
public class UserActivity extends AppCompatActivity {

        private RecyclerView recyclerView;
        List<User> mUserList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_recyclerview);

            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            Call<List<User>> listUsers = WebService.userService.getListUsers();

            listUsers.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(retrofit.Response<List<User>> response, Retrofit retrofit) {
                    mUserList = response.body();
                    MyUserAdapter adapt = new MyUserAdapter(getApplicationContext(), R.layout.user_row, mUserList);

                    Collections.sort(mUserList);
                    recyclerView.setAdapter(adapt);
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
