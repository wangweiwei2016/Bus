package com.hqu.weil;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * 作者：www on 2016/8/10 15:33
 * 邮箱：2030730029@qq.com
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

    private  final  int PAGER_COUNT = 4 ;
    private MyFragment1 myFragment1 = null ;
    private Activity_One activity_one = null;
    private  MyFragment2 myFragment2 = null ;
    private  MyFragment3 myFragment3 = null ;
    private  MyFragment4 myFragment4 = null ;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();
        myFragment4 = new MyFragment4();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case MainActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = myFragment4;
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
