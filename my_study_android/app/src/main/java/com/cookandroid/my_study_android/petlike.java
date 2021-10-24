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

public class petlike extends AppCompatActivity {

    Switch aSwitch;
    TextView textview;
    RadioGroup radiog;
    RadioButton btn1, btn2, btn3;
    Button btnstart, btnend;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btnedit);

        aSwitch = (Switch)findViewById(R.id.aswich);
        textview = (TextView)findViewById(R.id.textview);
        radiog = (RadioGroup)findViewById(R.id.radiogroup);
        btn1 = (RadioButton)findViewById(R.id.rdobtn1);
        btn2 = (RadioButton)findViewById(R.id.rdobtn2);
        btn3 = (RadioButton)findViewById(R.id.rdobtn3);
        btnstart = (Button)findViewById(R.id.btnstart);
        btnend = (Button)findViewById(R.id.btnend);
        img = (ImageView)findViewById(R.id.img);

        btn1.setOnClickListener(viewlistener);
        btn2.setOnClickListener(viewlistener);
        btn3.setOnClickListener(viewlistener);


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(aSwitch.isChecked() == true) {
                    textview.setVisibility(View.VISIBLE);
                    radiog.setVisibility(View.VISIBLE);
                    btnend.setVisibility(View.VISIBLE);
                    btnstart.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                } else {
                    textview.setVisibility(View.INVISIBLE);
                    radiog.setVisibility(View.INVISIBLE);
                    btnstart.setVisibility(View.INVISIBLE);
                    btnend.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setVisibility(View.INVISIBLE);
                radiog.setVisibility(View.INVISIBLE);
                btnstart.setVisibility(View.INVISIBLE);
                btnend.setVisibility(View.INVISIBLE);
                img.setVisibility(View.INVISIBLE);
            }
        });

    }

    View.OnClickListener viewlistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (radiog.getCheckedRadioButtonId()) {
                case R.id.dog :
                    img.setImageResource(R.drawable.dog);
                    break;
                case R.id.cat :
                    img.setImageResource(R.drawable.cat);
                    break;
                case R.id.rabbit :
                    img.setImageResource(R.drawable.horse);
                    break;
                default:
                    Toast.makeText(getApplicationContext(),"없어 시발", Toast.LENGTH_SHORT).show();
            }
        }
    };
}