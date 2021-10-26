package com.cookandroid.my_study_android;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class cp4_4 extends AppCompatActivity {

    Switch switch1;
    TextView textview;
    RadioButton radioButton1, radioButton2, radioButton3;
    RadioGroup radioGroup;
    ImageView imageView;
    Button btnstart, btnend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutpet2);

        switch1 = (Switch)findViewById(R.id.switch1);
        textview = (TextView)findViewById(R.id.textview);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        radioButton1 = (RadioButton)findViewById(R.id.rdobtn1);
        radioButton2 = (RadioButton)findViewById(R.id.rdobtn2);
        radioButton3 = (RadioButton)findViewById(R.id.rdobtn3);
        imageView = (ImageView)findViewById(R.id.img);
        btnstart = (Button)findViewById(R.id.btnstart);
        btnend = (Button)findViewById(R.id.btnend);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switch1.isChecked() == true) {
                    textview.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    btnstart.setVisibility(View.VISIBLE);
                    btnend.setVisibility(View.VISIBLE);
                } else {
                    //체크가 해지되면 INVISIBLE로 변경
                    textview.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    btnstart.setVisibility(View.INVISIBLE);
                    btnend.setVisibility(View.INVISIBLE);
                }
            }
        });

        //리스너로 바로바로 변경하기
        radioButton1.setOnClickListener(radio_listener);
        radioButton2.setOnClickListener(radio_listener);
        radioButton3.setOnClickListener(radio_listener);

        //버튼 클릭시 앱이 종료됨
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        //버튼 클릭시 스위치를 False로 바꿔 다시 첨으로 돌아감
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch1.setChecked(false);
            }
        });

    }

    //라디오 버튼 클릭시 바로 바꾸기 위해 작성한것
    View.OnClickListener radio_listener = new View.OnClickListener() {
        public void onClick(View arg0) {
            switch (radioGroup.getCheckedRadioButtonId()) {
                // 라디오그룹 안의 버튼이 머 선택한지
                // 버튼마다 이미지가 무엇이 나올지 설정한다
                case R.id.radio1 :
                    imageView.setImageResource(R.drawable.dog);
                    break;
                case R.id.radio2 :
                    imageView.setImageResource(R.drawable.cat);
                    break;
                case  R.id.radio3 :
                    imageView.setImageResource(R.drawable.horse);
                    break;
                default:
                    //만약 버튼을 선택안했다면 Toast메시지 출력
                    Toast.makeText(getApplicationContext(),"선택안함 선택하셈", Toast.LENGTH_SHORT).show();
            }
        }
    };


}