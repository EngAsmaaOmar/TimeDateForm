package com.example.omar.timedateform;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar  c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month1 = c.get(Calendar.MONTH);
        final int day = c. get(Calendar.DAY_OF_MONTH);
        final int hour = c.get(Calendar.HOUR);
        final int minut = c.get(Calendar.MINUTE);

        final EditText txttime = (EditText)findViewById(R.id.enttime);
        final EditText txtdate = (EditText)findViewById(R.id.entdate);

        txttime .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog time = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        txttime.setText( hourOfDay  +":"+ minute );
                    }
                },hour , minut ,true
                );
                time.setTitle("selectTime");
                time.show();
            }
        });




        txtdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog date = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtdate.setText( year + "- " +  month +" -" + dayOfMonth);
                    }
                }, year ,month1,day
                );
                date.setTitle("select Date");
                date.show();
            }
        });
    }
}
