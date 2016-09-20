package com.hqu.weil;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener
        {

    //UI Objects
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_ticket;
    private RadioButton rb_line;
    private RadioButton rb_service;
    private RadioButton rb_my;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;
    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
//    public static final int PAGE_ONE_ONE = 4;
//    public static final int PAGE_ONE_TWO = 5;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    private Context mcontext ;
    private long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mcontext=MainActivity.this;
        bindViews();
        rb_ticket.setChecked(true);
    }

    private void bindViews(){
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_ticket = (RadioButton) findViewById(R.id.rb_ticket);
        rb_line = (RadioButton) findViewById(R.id.rb_line);
        rb_service = (RadioButton) findViewById(R.id.rb_service);
        rb_my = (RadioButton) findViewById(R.id.rb_my);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        //vpager.setCurrentItem(1);  //设置当前项，默认为第一个
        vpager.addOnPageChangeListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.rb_ticket:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_line:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_service:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_my:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
//state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_ticket.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_line.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_service.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_my.setChecked(true);
                    break;
            }
        }
    }

            public boolean onKeyDown(int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    if ((System.currentTimeMillis() - mExitTime) > 2000) {
                        Object mHelperUtils;
                        Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                        mExitTime = System.currentTimeMillis();

                    } else {
                        finish();
                    }
                    return true;
                }
                return super.onKeyDown(keyCode, event);
            }
}
