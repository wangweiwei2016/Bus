package com.hqu.weil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：www on 2016/8/10 15:29
 * 邮箱：2030730029@qq.com
 */
public class MyFragment4 extends Fragment {

    public MyFragment4(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content_four,container,false);
//        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
//        txt_content.setText("第四个Frament");
        Log.e("1234","4444");
        return view;
    }
}
