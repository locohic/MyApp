package com.example.loic.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
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
import java.util.GregorianCalendar;
import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button InscButton = (Button) findViewById(R.id.Inscbutton);
        Button ConnectButton = (Button) findViewById(R.id.ConnectButton);
        TextView TV1 = (TextView) findViewById(R.id.TV1);
        getString(R.string.view_text);

        /*String now = DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL);
        TV1.setText(now);*/

        };

    /*public void onStart(){
        super.onStart();
        EditText txtDate=(EditText) findViewById(R.id.txtdate);
        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v,boolean hasFocus){
                if (hasFocus){
            DateDialog dialog= new DateDialog(v);
                    FragmentTransaction ft= getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");
                }
        }
    }
        );
    } <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/txtdate"
        android:textSize="20sp"
        android:hint="Tapez ici pour choisir la date"
        android:layout_below="@+id/TV1"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="42dp" />*/

    /*public void datePicker(View view){
        DatePickerFragment fragment= new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "date");
    }
    private void setDate(final Calendar calendar) {
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.TV1)).setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    public static class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle saveInstanceState){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(year, month, day));
        }
    }

    @Override
    public void onDateset(DatePicker view, int year, int month, int day ) {
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);
    }*/
    public void inscription(View v){
        Intent inscription = new Intent(this,Main2Activity.class);
        startActivity(inscription);
    }
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


