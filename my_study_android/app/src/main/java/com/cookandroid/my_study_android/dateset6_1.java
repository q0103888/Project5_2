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


        //라디오 버튼 클릭시 각각 타임피커와 캘린더뷰가 보이고 안보이게 해줌
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

        //크로노미터을 누르면 크로노미터가 실행되도록
        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btncal.setVisibility(View.VISIBLE);
                btntime.setVisibility(View.VISIBLE);
                // 밑은 크로노미터의 시간 단위를 시스템시계의 1초 단위와 같게 지정
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });
        //년부분을 길게 누르면 크로노미터가 스탑되도록
        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                //데이트피커에서 지정한 변수를 위치에 맞게 설정
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                //타임피커에서 지정한 시간을 시, 분에 각각 대입입
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
                // 데이트피커에서 설정한 값을 각각의 변수에 지정해준다
                selectYear = year;
                selectMonth = month+1;
                selectDay = dayOfMonth;
            }
        });

    }



}