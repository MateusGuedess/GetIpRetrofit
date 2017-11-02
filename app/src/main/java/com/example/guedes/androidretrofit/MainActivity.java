package com.example.guedes.androidretrofit;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guedes.androidretrofit.Model.Ip;
import com.example.guedes.androidretrofit.Remote.IpService;

import org.w3c.dom.Text;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    IpService mService;
    TextView txtIp;
    Button btnGetIp;
    SpotsDialog dialog;
    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = Common.getIpService();
        btnGetIp = findViewById(R.id.btnGetIp);
        txtIp = findViewById(R.id.txtIP);
        dialog = new SpotsDialog(MainActivity.this);

        btnGetIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                getIpEndereco();
            }
        });
    }

    private void getIpEndereco() {
        mService.getIp().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                dialog.dismiss();
                txtIp.setText(response.body().getIp());
                Log.d(TAG, "onResponse: "+response.body().getIp()  );
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
