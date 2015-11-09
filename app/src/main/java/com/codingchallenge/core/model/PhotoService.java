package com.codingchallenge.core.model;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Hawazine on 06/11/2015.
 */
public interface PhotoService {
    @GET("http://jsonplaceholder.typicode.com/photos")
    Call<List<Photo>> listOfPhoto(@Query("albumId") int userId);
}
