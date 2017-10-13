package com.example.widgetdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */

/**
 * 贝塞尔曲线 图
 */
public class BezierView extends View
{


    private Paint paint = new Paint();
    private PointF start,end,control1,control2;
    private int centreX,centreY;
    private boolean mode = false;
    public BezierView(Context context)
    {
        super(context);
        init();
    }

    public BezierView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }


    private void init()
    {
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setTextSize(20);
        paint.setColor(Color.RED);
        paint.setDither(true);//防抖动
        start = new PointF(0,0);
        end = new PointF(0,0);
        control1 = new PointF(0,0);
        control2 = new PointF(0,0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        centreX =w/2;
        centreY =h/2;

        start.x =-w/4;
        start.y =0;
        end.x = w/4;
        end.y =0;
        control1.x = centreX;
        control1.y = centreY - 100;
        control2.x = centreX;
        control2.y = centreY - 100;

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        /**
         * 绘制数据点和控制点
         */
        canvas.translate(centreX,centreY);
        //start
        canvas.drawPoint(start.x,start.y,paint);
        //end
        canvas.drawPoint(end.x,end.y,paint);
        //control1
        canvas.drawPoint(control1.x,control1.y,paint);
        //control2
        canvas.drawPoint(control2.x,control2.y,paint);
        //绘制辅助线 针对二阶
//        paint.setColor(Color.BLUE);
//        canvas.drawLine(start.x,start.y,control1.x,control1.y,paint);
//        canvas.drawLine(end.x,end.y,control1.x,control1.y,paint);


        //用path绘制贝塞尔曲线
        Path path = new Path();
        path.moveTo(start.x,start.y);
//        path.quadTo(control1.x,control1.y,end.x,end.y);//二阶曲线对应的方法是quadTo
        path.cubicTo(control1.x,control1.y,control2.x,control2.y,end.x,end.y);//三阶曲线对应的方法是cubicTo
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        mode = !mode;
        if(mode)
        {
            control1.x = event.getX();
            control1.y = event.getY();
        }
        else
        {

            control2.x = event.getX();
            control2.y = event.getY();
        }


        invalidate();
        return true;
    }
}
