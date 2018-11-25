package com.example.yanmi.wuqingyu.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.yanmi.wuqingyu.R;

import java.util.Random;

public class FirstFragment extends Fragment {
    EditText etsum,etmin,etmax;
    TextView tvresult;
    RadioGroup RG;
    Button btgenerate;
    View mview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mview==null){
            mview=inflater.inflate(R.layout.layout_firstfragment,null);
        }
        initViews();
        setListener();
        return mview;
    }

    private void setListener() {
        btgenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum=Integer.parseInt(etsum.getText().toString());
                int min=Integer.parseInt(etmin.getText().toString());
                int max=Integer.parseInt(etmax.getText().toString());
                Random random=new Random();
                for(int i=0;i<sum;i++){
                    int temp=random.nextInt(max-min)+min;
                    tvresult.append(temp+" ");
                }
            }
        });
    }

    private void initViews() {
        etsum= (EditText) mview.findViewById(R.id.etsum);
        etmin= (EditText) mview.findViewById(R.id.etmin);
        etmax= (EditText) mview.findViewById(R.id.etmax);
        tvresult= (TextView) mview.findViewById(R.id.tvresult);
        RG= (RadioGroup) mview.findViewById(R.id.radioGroup);
        btgenerate= (Button) mview.findViewById(R.id.btgenerte);
    }
}
