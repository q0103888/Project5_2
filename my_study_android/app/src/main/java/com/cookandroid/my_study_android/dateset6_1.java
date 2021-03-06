package com.cookandroid.my_study_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.time.Year;

public class dateset6_1 extends AppCompatActivity {

    Chronometer chrono;
    RadioGroup radiogroup;
    RadioButton btncal, btntime;
    CalendarView calview;
    TimePicker timepicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvmin;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateset);

        chrono = (Chronometer)findViewById(R.id.chrono);
        btncal = (RadioButton)findViewById(R.id.btncal);
        btntime = (RadioButton)findViewById(R.id.btntime);
        calview = (CalendarView)findViewById(R.id.calview);
        timepicker = (TimePicker)findViewById(R.id.timeview);

        tvYear = (TextView)findViewById(R.id.tvYear);
        tvMonth = (TextView)findViewById(R.id.tvMonth);
        tvDay = (TextView)findViewById(R.id.tvDay);
        tvHour = (TextView)findViewById(R.id.tvHour);
        tvmin = (TextView)findViewById(R.id.tvMin);


        calview.setVisibility(View.INVISIBLE);
        timepicker.setVisibility(View.INVISIBLE);
        btncal.setVisibility(View.INVISIBLE);
        btntime.setVisibility(View.INVISIBLE);


        //????????? ?????? ????????? ?????? ??????????????? ??????????????? ????????? ???????????? ??????
        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepicker.setVisibility(View.INVISIBLE);
                calview.setVisibility(View.VISIBLE);
            }
        });

        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepicker.setVisibility(View.VISIBLE);
                calview.setVisibility(View.INVISIBLE);
            }
        });

        //?????????????????? ????????? ?????????????????? ???????????????
        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btncal.setVisibility(View.VISIBLE);
                btntime.setVisibility(View.VISIBLE);
                // ?????? ?????????????????? ?????? ????????? ?????????????????? 1??? ????????? ?????? ??????
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });
        //???????????? ?????? ????????? ?????????????????? ???????????????
        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                //????????????????????? ????????? ????????? ????????? ?????? ??????
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                //?????????????????? ????????? ????????? ???, ?????? ?????? ?????????
                tvHour.setText(Integer.toString(timepicker.getCurrentHour()));
                tvmin.setText(Integer.toString(timepicker.getCurrentMinute()));

                calview.setVisibility(View.INVISIBLE);
                timepicker.setVisibility(View.INVISIBLE);
                btncal.setVisibility(View.INVISIBLE);
                btntime.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        calview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // ????????????????????? ????????? ?????? ????????? ????????? ???????????????
                selectYear = year;
                selectMonth = month+1;
                selectDay = dayOfMonth;
            }
        });

    }



}