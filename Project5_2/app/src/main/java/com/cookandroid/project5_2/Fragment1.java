package com.cookandroid.project5_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment1, container, false);
        //inflater 는 팽창한다는 뜻이고 해당 xml파일을 읽어와서 프로그래밍 객처로 만들어 주는 것
        //false는 parent에 나중에 FragmentManager가 프래그먼트 추가
        //true는 현재 뷰를 parent에 즉시 추가
    }
}
