package com.example.widgetdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.widgetdemo.util.MyLog;


/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */
public class MyView extends View
{
    private Paint paint1,paint2,paint3,paint4,paint5;

    public MyView(Context context)
    {
        super(context);
        init();
        MyLog.e("MyView--MyView(Context context)");
    }

    public MyView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
        MyLog.e("MyView--MyView(Context context, AttributeSet attrs)");
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        MyLog.e("MyView--MyView(Context context, AttributeSet attrs, int defStyleAttr)");
    }
    private void init()
    {
       /*
        paint1.setStyle()
       STROKE                //描边
       FILL                  //填充
       FILL_AND_STROKE       //描边加填充
       */
        paint1 = new Paint();
        paint1.setColor(Color.BLUE);
        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.STROKE);
        paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(Color.GREEN);
        paint1.setStyle(Paint.Style.FILL);
        paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(Color.RED);
        paint4 = new Paint();
        paint4.setAntiAlias(true);
        paint4.setColor(Color.YELLOW);
        paint5 = new Paint();
        paint5.setAntiAlias(true);
        paint5.setColor(Color.LTGRAY);
    }
    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);

        canvas.drawRect(0,0,300,300,paint1);

        Rect rect = new Rect(80,50,200,250);
        canvas.drawRect(rect,paint2);

        RectF rectF= new RectF(80+400,50+400,600,250+400);
        canvas.drawRoundRect(rectF,50,70,paint3);

        RectF rectF2= new RectF(80+600,50+600,600+300,250+600);
        canvas.drawOval(rectF2,paint4);
//        canvas.drawOval(80+600,50+600,600+300,250+600,paint4);//必须在API21以上才能使用

        RectF rectF3= new RectF(80,50+600,600,250+600);
        canvas.drawArc(rectF3,0,90,true,paint5);

        RectF rectF4= new RectF(80+200,50+600,600+200,250+600);
        canvas.drawArc(rectF4,0,90,false,paint1);

        canvas.drawCircle(800,200,100,paint2);

    }



}
