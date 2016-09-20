package com.hqu.weil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作者：www on 2016/8/11 10:54
 * 邮箱：2030730029@qq.com
 */
public class MyFragment1_3 extends Fragment {
    public MyFragment1_3(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        TextView txt_content1 = (TextView) view.findViewById(R.id.txt_content);
 //       TextView txt_content2 = (TextView) view.findViewById(R.id.txt_content_two);
        txt_content1.setText("第三个子Frament");
 //       txt_content2.setText("第三个子模块");
        Log.e("1111","33333");
        return view;
    }
}
