package com.example.loic.myapplication;

import android.app.ActionBar;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URL;

import static android.R.attr.onClick;
import static android.content.ContentValues.TAG;
import static com.example.loic.myapplication.GetBiersService.*;
import static com.example.loic.myapplication.GetBiersService.startActionBiers;
import static com.example.loic.myapplication.R.id.activity_main2;
import static com.example.loic.myapplication.R.id.button_notif;
import static com.example.loic.myapplication.R.string.notification;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    NotificationCompat.Builder notif;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String TAG;

        Button button_notif = (Button) findViewById(R.id.button_notif);
        IntentFilter intentFilter = new IntentFilter(Biers_Update);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(), intentFilter);
        Intent intent = new Intent(this, Main2Activity.class);
        startService(intent);

        button_notif.setOnClickListener(this);
    }

    public void Notification_test(){
        NotificationCompat.Builder notif = new NotificationCompat.Builder(this);
        notif.setSmallIcon(R.mipmap.ic_launcher);
        notif.setContentTitle("Notifications");
        notif.setContentText("Téléchargement terminé");
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(0,notif.build());
    }
    public void notifyMe (View view){
        Intent i = new Intent();
        i.setAction("com.example.loic.myapplication");
        i.addFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES);
        sendBroadcast(i);
    }

    public static final String Biers_Update = "com.octip.cours.inf4042_11.Biers_Update";

    public class BierUpdate extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                }
            };
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_notif:
                Notification_test();
                break;

            default:
                break;
        }
    }
}
