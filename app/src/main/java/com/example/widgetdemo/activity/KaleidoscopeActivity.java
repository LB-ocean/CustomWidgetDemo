package com.example.widgetdemo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Button;

import com.example.widgetdemo.R;
import com.example.widgetdemo.bean.Pie;
import com.example.widgetdemo.util.MyLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */

/**
 * 万花筒
 */
public class KaleidoscopeActivity extends AppCompatActivity
{
    private int[] mColors = {0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00, 0xFF2BCB00, 0xFFFAFC00, 0xFF641100, 0xFF559900};
    private int[] mRadius ={5,10,40,70,120,180,250,300,350,400};

    @BindView(R.id.kaleidoscope)
    com.example.widgetdemo.widget.kaleidoscope kaleidoscope;
    @BindView(R.id.click)
    Button click;
    private int i = 0;
    private Timer timer = new Timer();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            i++;
            if(i>=pieList.size())
            {
                i  = 0;
            }
            kaleidoscope.setFlag(pieList.get(i));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();

    }

    List<Pie> pieList;

    private void initData()
    {
        /**
         * 万花筒初始数据
         */
        pieList = new ArrayList<>();
        for (int j = 0; j <mColors.length ; j++)
        {
            Pie pie = new Pie();
            pie.setColor(mColors[j]);
            pie.setRadius(mRadius[j]);
            pieList.add(pie);
        }
    }

    @OnClick(R.id.click)
    public void click()
    {
        MyLog.e("click()");
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                handler.sendEmptyMessage(10);
            }
        },0,500);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//当返回按键被按下
            finish();
        }
        return false;
    }
}
