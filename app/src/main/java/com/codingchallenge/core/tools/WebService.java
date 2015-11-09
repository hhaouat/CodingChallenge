package com.codingchallenge.core.tools;

import com.codingchallenge.core.model.AlbumService;
import com.codingchallenge.core.model.PhotoService;
import com.codingchallenge.core.model.UserService;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Toshiba on 08/11/2015.
 */
public class WebService {

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    static public UserService userService       = retrofit.create(UserService.class);
    static public AlbumService albumService     = retrofit.create(AlbumService.class);
    static public PhotoService photoService     = retrofit.create(PhotoService.class);

}
