package com.example.yanmi.wuqingyu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import com.example.yanmi.wuqingyu.Adapter.MyFragmentPagerAdapter;
import com.example.yanmi.wuqingyu.Fragment.FirstFragment;
import com.example.yanmi.wuqingyu.Fragment.FourthFragment;
import com.example.yanmi.wuqingyu.Fragment.SecondFragment;
import com.example.yanmi.wuqingyu.Fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    public static String TAG="MainActivity";
    ViewPager viewPager;
    RadioGroup rg;
    FragmentManager mFragmentManager;
    List<Fragment> mFragmentlist=new ArrayList<>();
    MyFragmentPagerAdapter mFragmentadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initFragmetlist();
        mFragmentManager=getSupportFragmentManager();
        initViewPager();
        setListeners();
    }

    private void setListeners() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        Log.d(TAG, "onCheckedChanged: 点击了第一个页面");
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        Log.d(TAG, "onCheckedChanged: 点击了第二个页面");
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        Log.d(TAG, "onCheckedChanged: 点击了第三个页面");
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        Log.d(TAG, "onCheckedChanged: 点击了第四个页面");
                        viewPager.setCurrentItem(3);
                        break;
                }

            }
        });
    }

    private void initViewPager() {
        mFragmentadapter=new MyFragmentPagerAdapter(mFragmentManager,mFragmentlist);
        viewPager.setOnPageChangeListener(new ViewPagetOnPagerChangedLisenter());
        viewPager.setAdapter(mFragmentadapter);
        viewPager.setCurrentItem(0);
    }

    private void initViews() {
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        rg=(RadioGroup) findViewById(R.id.radioGroup);

    }
    private void initFragmetlist(){
        mFragmentlist.add(new FirstFragment());
        mFragmentlist.add(new SecondFragment());
        mFragmentlist.add(new ThirdFragment());
        mFragmentlist.add(new FourthFragment());
    }
    class ViewPagetOnPagerChangedLisenter implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int i, float v, int i1) {
            Log.d(TAG, "onPageScrolled: 当前页面滑动时，调用，当前页面为"+i);
        }

        @Override
        public void onPageSelected(int i) {
            switch (i){
                case 0:
                    rg.check(R.id.rb1);
                    break;
                case 1:
                    rg.check(R.id.rb2);
                    break;
                case 2:
                    rg.check(R.id.rb3);
                    break;
                case 3:
                    rg.check(R.id.rb4);
                    break;
            }
            Log.d(TAG, "onPageSelected: 跳转结束后的页面"+i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {
            Log.d(TAG, "onPageScrollStateChanged: 状态改变时调用，0，什么都么有，1，正在滑动，2，滑动结束"+i);
        }
    }
}
