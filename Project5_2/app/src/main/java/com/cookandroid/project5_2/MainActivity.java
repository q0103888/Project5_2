package com.cookandroid.project5_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    RadioButton rdoCal, rdoTime;
    DatePicker dpickerView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMin;
    int selectYear, selectMonth, selectDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeset);
        setTitle("시간 예약");


        chrono = (Chronometer)findViewById(R.id.chronometer1);

        rdoCal = (RadioButton)findViewById(R.id.rdoCal);
        rdoTime = (RadioButton)findViewById(R.id.rdoTime);

        tPicker = (TimePicker)findViewById(R.id.timePicker1);
        dpickerView = (DatePicker)findViewById(R.id.dpickerView1);

        tvYear = (TextView)findViewById(R.id.tvYear);
        tvMonth = (TextView)findViewById(R.id.tvMonth);
        tvDay = (TextView)findViewById(R.id.tvDay);
        tvHour = (TextView)findViewById(R.id.tvHour);
        tvMin = (TextView)findViewById(R.id.tvMin);

        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);
        dpickerView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                dpickerView.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                dpickerView.setVisibility(View.INVISIBLE);
            }
        });


        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });



        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                tvYear.setText(Integer.toString(dpickerView.getYear()));
                tvMonth.setText(Integer.toString(dpickerView.getMonth()+1));
                tvDay.setText(Integer.toString(dpickerView.getDayOfMonth()));

                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMin.setText(Integer.toString(tPicker.getCurrentMinute()));

                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                dpickerView.setVisibility(View.INVISIBLE);
                return false;
            }
        });



    }
}