package com.cookandroid.project5_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.TabActivity;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

import java.util.Date;
//기존은 AppCompatAcivity
//
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taphost);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabdog = tabHost.newTabSpec("Dog").setIndicator("강아지");
        tabdog.setContent(R.id.tabdog);
        tabHost.addTab(tabdog);

        TabHost.TabSpec tabcat = tabHost.newTabSpec("Cat").setIndicator("고양이");
        tabcat.setContent(R.id.tabcat);
        tabHost.addTab(tabcat);

        TabHost.TabSpec tabrabbit = tabHost.newTabSpec("Rabbit").setIndicator("토끼");
        tabrabbit.setContent(R.id.tabrabbit);
        tabHost.addTab(tabrabbit);

        TabHost.TabSpec tabhorse = tabHost.newTabSpec("Horse").setIndicator("말");
        tabhorse.setContent(R.id.tabhorse);
        tabHost.addTab(tabhorse);

        tabHost.setCurrentTab(0);
    }
}