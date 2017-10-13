package com.example.widgetdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.widgetdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */

public class HomeActivity extends AppCompatActivity
{
    @BindView(R.id.buttonPieChart)
    Button buttonPieChart;
    @BindView(R.id.buttonKaleidoscope)
    Button buttonKaleidoscope;
    @BindView(R.id.buttonEightDiagrams)
    Button buttonEightDiagrams;
    @BindView(R.id.buttonSpiderWeb)
    Button buttonSpiderWeb;
    @BindView(R.id.buttonSportView)
    Button buttonSportView;
    @BindView(R.id.buttonBezier)
    Button buttonBezier;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.buttonPieChart, R.id.buttonKaleidoscope, R.id.buttonEightDiagrams, R.id.buttonSpiderWeb, R.id.buttonSportView, R.id.buttonBezier})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.buttonPieChart:
                startActivity(new Intent(this,PieChartActivity.class));
                break;
            case R.id.buttonKaleidoscope:
                startActivity(new Intent(this,KaleidoscopeActivity.class));
                break;
            case R.id.buttonEightDiagrams:
                startActivity(new Intent(this,EightDiagramsActivity.class));
                break;
            case R.id.buttonSpiderWeb:
                startActivity(new Intent(this,SpiderWebActivity.class));
                break;
            case R.id.buttonSportView:
                startActivity(new Intent(this,SportViewActivity.class));
                break;
            case R.id.buttonBezier:
                startActivity(new Intent(this,BezierActivity.class));
                break;
        }
    }
}
