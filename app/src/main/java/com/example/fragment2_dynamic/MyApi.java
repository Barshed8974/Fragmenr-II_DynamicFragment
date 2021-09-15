package com.example.fragment2_dynamic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApi {
    @GET("nobroker")
    Call<List<Example>> getmodels();
}