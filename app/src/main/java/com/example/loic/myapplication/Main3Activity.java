package com.example.loic.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.net.URL;

import static com.example.loic.myapplication.GetBiersService.*;
import static com.example.loic.myapplication.GetBiersService.startActionBiers;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button Get_Biers_Button = (Button) findViewById(R.id.Get_Biers_Button);
        IntentFilter intentFilter = new IntentFilter(Biers_Update);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(), intentFilter);
        Get_Biers_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetBiersService.startActionBiers(getApplicationContext(), "");
            }
        });

    }

    private static final String Biers_Update = "com.octip.cours.inf4042_11.Biers_Update";

    public class BierUpadate extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("msg", getIntent().getAction());
        }
    }
}


