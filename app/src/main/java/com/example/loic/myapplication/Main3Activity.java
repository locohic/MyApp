package com.example.loic.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Get_Biers_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetBiersService.startActionBiers(getApplicationContext(),"" );
            }
            });
    }
}

