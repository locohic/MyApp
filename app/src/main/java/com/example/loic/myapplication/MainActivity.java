package com.example.loic.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
Calendar calendar = Calendar.getInstance();
    TextView TV1;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            TV1 = (TextView) findViewById(R.id.TV1);
            Button ConnectButton = (Button) findViewById(R.id.ConnectButton);
            TextView TV1 = (TextView) findViewById(R.id.TV1);
            getString(R.string.view_text);
            Button datebutton = (Button) findViewById(R.id.Datebutton);
            datebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                    public void onClick(View v){
                        new DatePickerDialog(MainActivity.this, listener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                     }
            });
        }
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
                public void onDateSet (DatePicker view, int year, int monthOfYear, int dayOfMonth){

                    TV1.setText("Bonjour nous sommes le: " +dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
            }
        };

    public void connexion(View v) {
        Intent connexion = new Intent(this,Main3Activity.class);
        startActivity(connexion);
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
};


