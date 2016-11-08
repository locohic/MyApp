package com.example.loic.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button VALIDERbutton = (Button) findViewById(R.id.VALIDERbutton);
        Button ANNULERbutton = (Button) findViewById(R.id.ANNULERbutton);
        TextView TV1 = (TextView) findViewById(R.id.TV1);
        getString(R.string.view_text);
        String now = DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL);
        TV1.setText(now);
        VALIDERbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_text) {

                Toast.makeText(getApplicationContext(), getString(R.string.view_text), Toast.LENGTH_LONG).show();
            }

            ;
        });
        ANNULERbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_text) {

                Toast.makeText(getApplicationContext(), getString(R.string.view_text), Toast.LENGTH_LONG).show();
            };
        });
    };
};


