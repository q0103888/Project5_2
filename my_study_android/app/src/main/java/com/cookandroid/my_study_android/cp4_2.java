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

public class cp4_2 extends AppCompatActivity {

    CheckBox checkbox;
    TextView textview;
    RadioGroup radiog;
    RadioButton btn1, btn2, btn3;
    Button btnok;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btnedit);

        checkbox = (CheckBox)findViewById(R.id.check);
        textview = (TextView)findViewById(R.id.textview);
        radiog = (RadioGroup)findViewById(R.id.radiog);
        btnok = (Button)findViewById(R.id.btnok);
        img = (ImageView)findViewById(R.id.img);
        btn1 = (RadioButton)findViewById(R.id.rdobtn1);
        btn2 = (RadioButton)findViewById(R.id.rdobtn2);
        btn3 = (RadioButton)findViewById(R.id.rdobtn3);
        //XML에서 작성한 위젯들을 가져옴

        //체크박스 버튼을 누르면 INVISIBLE이였던 위젯들을 VISIBLE로 변경되게 작성한다.
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //체크박스가 체크되어 있으면 위젯들이 VISIBLE이 되게함
                if(checkbox.isChecked() == true) {
                    textview.setVisibility(View.VISIBLE);
                    radiog.setVisibility(View.VISIBLE);
                    btnok.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                } else {
                    //체크가 해지되면 INVISIBLE로 변경
                    textview.setVisibility(View.INVISIBLE);
                    radiog.setVisibility(View.INVISIBLE);
                    btnok.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            //ok버튼을 누르면 라디오 버튼 누른거에 따라 이미지를 출력
            @Override
            public void onClick(View v) {
                //버튼이 여러개 이므로 Switch문을 사용한다
                switch (radiog.getCheckedRadioButtonId()) {
                    // 라디오그룹 안의 버튼이 머 선택한지
                    // 버튼마다 이미지가 무엇이 나올지 설정한다
                    case R.id.radio1 :
                        img.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radio2 :
                        img.setImageResource(R.drawable.cat);
                        break;
                    case  R.id.radio3 :
                        img.setImageResource(R.drawable.horse);
                        break;
                    default:
                        //만약 버튼을 선택안했다면 Toast메시지 출력
                        Toast.makeText(getApplicationContext(),"선택안함 선택하셈", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}