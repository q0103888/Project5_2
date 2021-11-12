package com.cookandroid.android_class_7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    LinearLayout baselayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("베경색 바꾸기");

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        baselayout = (LinearLayout)findViewById(R.id.baselayout);

        registerForContextMenu(btn1);
        registerForContextMenu(btn2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == btn1) {
            menu.setHeaderTitle("배경색 변경");
            menu.add(0, 1, 0, "배경색(빨강");
            menu.add(0, 2, 0, "배경색(초록");
            menu.add(0, 3, 0, "배경색(파랑");

        }
        if(v == btn2) {
            menu.add(0,4,0,"버튼45도 회전");
            menu.add(0,5,0,"버튼2배 확대");
        }
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1 :
                baselayout.setBackgroundColor(Color.RED);
                return true;
            case 2 :
                baselayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3 :
                baselayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4 :
                btn2.setRotation(45);
                return true;
            case 5 :
                btn2.setScaleX(2);
                return true;
        }
            return false;
    }
}