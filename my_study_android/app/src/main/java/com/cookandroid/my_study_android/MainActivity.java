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
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

import java.time.Year;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vierflipper);

        Button btnPrev, btnNext;
        final ViewFlipper viewFlipper;

        btnPrev = (Button)findViewById(R.id.btn1);
        btnNext = (Button)findViewById(R.id.btn2);
        viewFlipper = (ViewFlipper)findViewById(R.id.viewflipper);

        //뷰플리퍼의 넘어가는 시간 설정
        viewFlipper.setFlipInterval(1000);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //누르면 자동으로 시작
                viewFlipper.startFlipping();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 누르면 멈춤
                viewFlipper.stopFlipping();
            }
        });

    }



}