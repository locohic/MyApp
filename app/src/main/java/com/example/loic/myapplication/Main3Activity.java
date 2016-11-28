package com.example.loic.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

    public static final String Biers_Update = "com.octip.cours.inf4042_11.Biers_Update";

    public class BierUpdate extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("msg", getIntent().getAction());
        }
    }
    private void save(){
        Toast.makeText(this,R.string.action_save,Toast.LENGTH_LONG).show();
    }

    private void delete(){
        Toast.makeText(this,R.string.action_delete,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.action_save:
                save();
                return true;
            case R.id.action_delete:
                delete();
                return true;
            case R.id.action_mode_close_button:
                closeContextMenu();
                return true;
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


