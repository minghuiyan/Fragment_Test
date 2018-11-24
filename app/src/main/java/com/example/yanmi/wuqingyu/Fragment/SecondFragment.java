package com.example.yanmi.wuqingyu.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yanmi.wuqingyu.R;

public class SecondFragment extends Fragment {
    View mview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mview==null){
            mview=inflater.inflate(R.layout.layout_secondfragment,null);
        }
        return mview;
    }
}
