package com.cookandroid.my_study_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class gyesan extends AppCompatActivity {

    Button btnadd, btnsub, btnmul, btndiv, btnna;
    EditText edit1, edit2;
    TextView text1;
    String num1, num2;
    Integer result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyesan);

        edit1  = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        btnadd = (Button)findViewById(R.id.btnadd);
        btnsub = (Button)findViewById(R.id.btnsub);
        btnmul = (Button)findViewById(R.id.btnmul);
        btndiv = (Button)findViewById(R.id.btndiv);
        btnna = (Button)findViewById(R.id.btnna);

        text1 = (TextView)findViewById(R.id.textresult);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),"숫자는?", Toast.LENGTH_SHORT).show();
                } else {
                    result = Integer.parseInt(num1) + Integer.parseInt(num2);
                    text1.setText("계산 결과 : "+result.toString());
                }
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),"숫자는?", Toast.LENGTH_SHORT).show();
                } else {
                    result = Integer.parseInt(num1) - Integer.parseInt(num2);
                    text1.setText("계산 결과 : "+result.toString());
                }
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),"숫자는?", Toast.LENGTH_SHORT).show();
                } else {
                    result = Integer.parseInt(num1) * Integer.parseInt(num2);
                    text1.setText("계산 결과 : "+result.toString());
                }
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),"숫자는?", Toast.LENGTH_SHORT).show();
                } else {
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    text1.setText("계산 결과 : "+result.toString());
                }
            }
        });
        btnna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),"숫자는?", Toast.LENGTH_SHORT).show();
                } else {
                    result = Integer.parseInt(num1) % Integer.parseInt(num2);
                    text1.setText("계산 결과 : "+result.toString());
                }
            }
        });
    }
}