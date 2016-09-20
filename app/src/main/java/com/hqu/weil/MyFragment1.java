package com.hqu.weil;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * 作者：www on 2016/8/10 15:23
 * 邮箱：2030730029@qq.com
 */
public class MyFragment1 extends Fragment implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener{
    private MyFragmentPagerAdapter_sub mAdapter_sub;
    private FragmentManager fm;

    private TextView txt_topbar;
    private TextView txt_downbar;
    private RadioGroup rg_tab_bar_sub;
    private RadioButton rb_ticket_sub;
    private RadioButton rb_line_sub;
    private RadioButton rb_service_sub;
//    private RadioButton rb_my_sub;

    private ViewPager vpager_sub;
    private TextView txt_content;
    private TextView txt_content2;

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public Context context =null;

    private String mArgument ;
    public static final String ARGUMENT ="argument";
    int mNum; //页号

    public MyFragment1(){

    }
//       @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //这里我只是简单的用num区别标签，其实具体应用中可以使用真实的fragment对象来作为叶片
//        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
//        // mArgument = getActivity().getIntent().getStringExtra(ARGUMENT);
////        Bundle bundle = getArguments();
////        if (bundle != null)
////            mArgument = bundle.getString(ARGUMENT);
//    }
//    public static MyFragment1 newInstance(int num) {
//        MyFragment1 fragment = new MyFragment1();
//        // Supply num input as an argument.
//        Bundle args = new Bundle();
//        args.putInt("num", num);
//        fragment.setArguments(args);
//        return fragment;
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content_one,container,false);
        txt_topbar = (TextView) view.findViewById(R.id.txt_content_sub1);
        txt_downbar = (TextView) view.findViewById(R.id.txt_content_sub2);
        rg_tab_bar_sub = (RadioGroup) view.findViewById(R.id.rg_tab_bar_sub);
        rb_ticket_sub = (RadioButton) view.findViewById(R.id.rb_ticket_sub);
        rb_line_sub= (RadioButton) view.findViewById(R.id.rb_line_sub);
        rb_service_sub= (RadioButton) view.findViewById(R.id.rb_service_sub);
//        rb_my_sub= (RadioButton) view.findViewById(R.id.rb_my_sub);
        vpager_sub = (ViewPager) view.findViewById(R.id.vpager_sub);
       // fm=getActivity().getSupportFragmentManager();
        fm=getChildFragmentManager();
        mAdapter_sub =new MyFragmentPagerAdapter_sub(fm);
        vpager_sub.setAdapter(mAdapter_sub);
        vpager_sub.setCurrentItem(0);

        bindViews();
        rb_ticket_sub.setChecked(true);
        Log.e("1234","1111");
        return view;
    }

    private void bindViews() {
        txt_topbar.setText("第一个Frament");
        txt_downbar.setText("第一个Frament的第一个子模块");
        rg_tab_bar_sub.setOnCheckedChangeListener(this);
        vpager_sub.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        //Toast.makeText(context,"111",Toast.LENGTH_SHORT).show();
       // System.out.print("I="+checkedId);
        switch (checkedId) {
            case R.id.rb_ticket_sub:
                vpager_sub.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_line_sub:
                vpager_sub.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_service_sub:
                vpager_sub.setCurrentItem(PAGE_THREE);
                break;

        }
    }


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
            switch (vpager_sub.getCurrentItem()) {
                case PAGE_ONE:
                    rb_ticket_sub.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_line_sub.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_service_sub.setChecked(true);
                    break;

            }
        }
    }
}
