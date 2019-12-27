package com.example.test.data.income;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("chart_interval/gold/{interval}")
    Single<Gold> getGoldData(@Path("interval") int interval);
}