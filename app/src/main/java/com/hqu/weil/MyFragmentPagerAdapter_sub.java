package com.hqu.weil;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * 作者：www on 2016/8/11 11:03
 * 邮箱：2030730029@qq.com
 */
public class MyFragmentPagerAdapter_sub  extends FragmentPagerAdapter {

    private  final  int PAGER_COUNT = 3 ;
    private  MyFragment1_1 myFragment1_1 = null ;
    private  MyFragment1_2 myFragment1_2 = null ;
    private  MyFragment1_3 myFragment1_3 = null ;


    public MyFragmentPagerAdapter_sub(FragmentManager fm) {
        super(fm);
        myFragment1_1 = new MyFragment1_1();
        myFragment1_2 = new MyFragment1_2();
        myFragment1_3 = new MyFragment1_3();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case MainActivity.PAGE_ONE:
                fragment = myFragment1_1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment1_2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment1_3;
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup vg, int position, Object object) {
        System.out.println("position Destory : " + position);
        super.destroyItem(vg, position, object);
    }
}

