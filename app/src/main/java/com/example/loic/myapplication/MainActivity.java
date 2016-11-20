package com.example.loic.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
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
        Button InscButton = (Button) findViewById(R.id.Inscbutton);
        Button ConnectButton = (Button) findViewById(R.id.ConnectButton);
        TextView TV1 = (TextView) findViewById(R.id.TV1);
        getString(R.string.view_text);
        String now = DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL);
        TV1.setText(now);
        InscButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_text) {

                Toast.makeText(getApplicationContext(), getString(R.string.view_text), Toast.LENGTH_LONG).show();
            }

            ;
        });
        ConnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_text) {

                Toast.makeText(getApplicationContext(), getString(R.string.view_text), Toast.LENGTH_LONG).show();
            };
        });
    };
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


