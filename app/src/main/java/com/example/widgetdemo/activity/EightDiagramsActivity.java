package com.example.widgetdemo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.example.widgetdemo.util.MyLog;
import com.example.widgetdemo.widget.EightDiagramsView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */
public class EightDiagramsActivity extends AppCompatActivity
{
    private EightDiagramsView eightDiagramsView;
    private int roate = 0;
    private Timer timer = new Timer();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            roate +=20;
            if(roate>=360)
            {
                roate = 0;
            }
            MyLog.e("EightDiagramsActivity----");
            eightDiagramsView.setRoate(roate);
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        eightDiagramsView = new EightDiagramsView(this);
        setContentView(eightDiagramsView);
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                handler.sendEmptyMessage(0);
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
