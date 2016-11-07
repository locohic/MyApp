package com.example.loic.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView TV1 =(TextView) findViewById(R.id.TV1);
        getString(R.string.view_text);
        String now= DateUtils.formatDateTime(getApplicationContext(),(new Date()).getTime(), DateFormat.FULL);
        TV1.setText(now);
    }
}
