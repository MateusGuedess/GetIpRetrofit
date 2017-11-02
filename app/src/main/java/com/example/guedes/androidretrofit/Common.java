package com.example.guedes.androidretrofit;

import com.example.guedes.androidretrofit.Remote.IpService;
import com.example.guedes.androidretrofit.Remote.RetrofitClient;

/**
 * Created by Guedes on 01/11/2017.
 */

public class Common {

    private static final String BASE_URL = "http://ip.jsontest.com/";

    public static IpService getIpService() {
        return RetrofitClient.getClient(BASE_URL).create(IpService.class);
    }

}
