package com.example.widgetdemo.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.widgetdemo.R;
import com.example.widgetdemo.util.MyLog;
import com.example.widgetdemo.widget.SportView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */
public class SportViewActivity extends AppCompatActivity
{
    @BindView(R.id.sportView2_sv)
    SportView sportViewSv;
    @BindView(R.id.ok_bt)
    Button okBt;
    @BindView(R.id.sportView2_sb)
    SeekBar sportView2Sb;
    @BindView(R.id.sportView2_sb2)
    SeekBar sportView2Sb2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sportview2);
        ButterKnife.bind(this);
        sportView2Sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                MyLog.e("SportViewActivity---progress:" + progress);
                sportViewSv.setValues(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
        sportView2Sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                sportViewSv.setPaintWidth(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }


    @OnClick(R.id.ok_bt)
    public void setOnClick()
    {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat().ofFloat(0, 100);
        valueAnimator.setInterpolator(new LinearInterpolator());//new FastOutLinearInInterpolator()
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                float roate = (float) animation.getAnimatedValue();
                sportViewSv.setValues((int) roate);
            }
        });
        valueAnimator.setDuration(4000);
        valueAnimator.start();
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
