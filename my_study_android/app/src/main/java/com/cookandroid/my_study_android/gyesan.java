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

        //XML에서 작성한 위젯들을 Java코드에 선언을 해준다.
        edit1  = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        btnadd = (Button)findViewById(R.id.btnadd);
        btnsub = (Button)findViewById(R.id.btnsub);
        btnmul = (Button)findViewById(R.id.btnmul);
        btndiv = (Button)findViewById(R.id.btndiv);
        btnna = (Button)findViewById(R.id.btnna);
        text1 = (TextView)findViewById(R.id.textresult);


        //위젯들이 각각 맡은 계산식을 만들기위해 setOnClickListener을 써준다.
        //계산을 해야하므로 num1, num2를 선언해준다

        //editText에서 작성한 숫자를 num1,2에 각각 대입해준다.
        //num1 = edit.getText().toString();

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                //문제에서 값을 입력하지 않으면 Toast메시지를 나타내야함 그러므로 if문을 사용한다
                if(num1.trim().equals("")||num2.trim().equals("")) {
                    //num1.trim().equals("") = num1의 문자열을 equals("")로 비교하여 아무것도 입력되지 않으면 True처리함
                    //trim은 문자열의 공백을 없애준다
                    Toast.makeText(getApplicationContext(),"숫자는?", Toast.LENGTH_SHORT).show();
                    //Toast를 출력하기 위한 코드 걍 외우자
                } else {
                    //만약 edit1,2가 비어있지 않으면 원래대로 계산식을 써준다.
                    //결과를 위해 변수를 result로 하나 만든뒤
                    //Integer.parseInt는 String을 int형으로 바꿔주는 역할을 한다
                    //그다음은 그냥 사칙연산 넣고 하면 끝
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