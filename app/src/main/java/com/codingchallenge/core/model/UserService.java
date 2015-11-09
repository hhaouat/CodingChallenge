package com.codingchallenge.core.model;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Toshiba on 03/11/2015.
 */

public interface UserService {
    @GET("http://jsonplaceholder.typicode.com/users")
    Call<List<User>> getListUsers();
}
