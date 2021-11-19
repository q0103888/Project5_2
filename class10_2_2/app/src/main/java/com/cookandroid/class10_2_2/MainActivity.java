package com.cookandroid.class10_2_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");
        final EditText edt1 = (EditText)findViewById(R.id.edtNum1);
        final EditText edt2 = (EditText)findViewById(R.id.edtNum2);
        RadioGroup rdoGroup = (RadioGroup)findViewById(R.id.rdoGroup);

        Button btnNewActivity = (Button)findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), second.class);

                switch (rdoGroup.getCheckedRadioButtonId()) {
                    case R.id.rdoADD:
                        intent.putExtra("Calc", "+");
                        break;
                    case R.id.rdoSub:
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.rdoMul:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.rdoDiv:
                        intent.putExtra("Calc", "/");
                        break;
                    default:
                        break;
                }
                intent.putExtra("Num1", Integer.parseInt(edt1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edt2.getText().toString()));
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "test: " + hap,Toast.LENGTH_SHORT).show();
        }
    }
}