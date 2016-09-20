package com.hqu.weil;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * 作者：www on 2016/8/11 12:23
 * 邮箱：2030730029@qq.com
 */
public class Activity_One extends AppCompatActivity implements
        ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener
        {

//UI Objects
private TextView txt_topbar_one;
private RadioGroup rg_tab_bar_one;
private RadioButton rb_ticket_one;
private RadioButton rb_line_one;
private RadioButton rb_service_one;
//private RadioButton rb_my_one;
private ViewPager vpager_one;

private MyFragmentPagerAdapter_sub mAdapter_sub;
//几个代表页面的常量
public static final int ONE_PAGE_ONE = 0;
public static final int ONE_PAGE_TWO = 1;
public static final int ONE_PAGE_THREE = 2;
//public static final int PAGE_FOUR = 3;
private Context mcontext ;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        mAdapter_sub = new MyFragmentPagerAdapter_sub(getSupportFragmentManager());
        mcontext=Activity_One.this;
        bindViews();
        rb_ticket_one.setChecked(true);
        }

private void bindViews(){
        txt_topbar_one = (TextView) findViewById(R.id.txt_topbar_one);
        rg_tab_bar_one = (RadioGroup) findViewById(R.id.rg_tab_bar_one);
        rb_ticket_one = (RadioButton) findViewById(R.id.rb_ticket_one);
        rb_line_one = (RadioButton) findViewById(R.id.rb_line_one);
        rb_service_one = (RadioButton) findViewById(R.id.rb_service_one);
       // rb_my_one = (RadioButton) findViewById(R.id.rb_my_one);
        rg_tab_bar_one.setOnCheckedChangeListener(this);

        vpager_one = (ViewPager) findViewById(R.id.vpager_one);
        vpager_one.setAdapter(mAdapter_sub);
        vpager_one.setCurrentItem(0);  //设置当前项，默认为第一个
        vpager_one.addOnPageChangeListener(this);
        }
@Override
public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
        case R.id.rb_ticket_one:
        vpager_one.setCurrentItem(ONE_PAGE_ONE);
        break;
        case R.id.rb_line_one:
        vpager_one.setCurrentItem(ONE_PAGE_TWO);
        break;
        case R.id.rb_service_one:
        vpager_one.setCurrentItem(ONE_PAGE_THREE);
        break;
//        case R.id.rb_my_one:
//        vpager_one.setCurrentItem(PAGE_FOUR);
//        break;
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
        switch (vpager_one.getCurrentItem()) {
        case ONE_PAGE_ONE:
        rb_ticket_one.setChecked(true);
        break;
        case ONE_PAGE_TWO:
        rb_line_one.setChecked(true);
        break;
        case ONE_PAGE_THREE:
        rb_service_one.setChecked(true);
        break;
//        case PAGE_FOUR:
//        rb_my_one.setChecked(true);
//        break;
        }
        }
        }
        }

