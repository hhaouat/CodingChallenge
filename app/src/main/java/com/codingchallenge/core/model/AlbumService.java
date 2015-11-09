package com.codingchallenge.core.model;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Hawazine on 05/11/2015.
 */
public interface AlbumService
{
    @GET("http://jsonplaceholder.typicode.com/albums")
    Call<List<Album>> listOfAlbum(@Query("userId") int userId);

}


