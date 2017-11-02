package com.example.guedes.androidretrofit.Remote;

import com.example.guedes.androidretrofit.Model.Ip;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Guedes on 01/11/2017.
 */

public interface IpService {
    @GET("/")
    Call<Ip> getIp();
}
