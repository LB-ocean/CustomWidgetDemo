package com.example.widgetdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import com.example.widgetdemo.util.MyLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */
public class SpiderWebView extends View
{

    /**
     * 绘制蜘蛛网思路分析：
     * 1.先绘制第一层
     * 2.涉及到path
     * 3.逐层递增
     *
     */

    private Paint paint = new Paint();
    private Paint paint2 = new Paint();
    private int nWidth,nHeight;
    private List<PointF> xyList;
    public SpiderWebView(Context context)
    {
        super(context);
        init();
    }

    public SpiderWebView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    private void init()
    {
        xyList = new ArrayList<>();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(Color.BLUE);
        paint2.setStrokeWidth(2);
        paint2.setAlpha(60);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        nWidth = w;
        nHeight = h;
    }


    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.translate(nWidth/2,nHeight/2);
        canvas.scale(1,-1);
        /**
         * 六边形的半径
         */
        int radius = (int) (Math.min(nWidth,nHeight)/2*0.8);
        int count = radius/50;
        for (int i = 0; i <count ; i++)
        {
            Path path = new Path();
            path.setLastPoint(-radius,0);
            path.lineTo(-radius/2,radius);
            path.lineTo(radius/2,radius);
            path.lineTo(radius,0);
            path.lineTo(radius/2,-radius);
            path.lineTo(-radius/2,-radius);
            path.close();
            if(i==0)
            {
                MyLog.e("i==count-1-----radius:"+radius);
                PointF pointF4 = new PointF();
                pointF4.set(-radius/2,radius);
                xyList.add(pointF4);
                PointF pointF5 = new PointF();
                pointF5.set(radius,0);
                xyList.add(pointF5);
                Path path2 = new Path();
                path2.setLastPoint(-radius,0);
                path2.lineTo(radius,0);

                Path path3 = new Path();
                path3.setLastPoint(-radius/2,radius);
                path3.lineTo(radius/2,-radius);

                Path path4 = new Path();
                path4.setLastPoint(radius/2,radius);
                path4.lineTo(-radius/2,-radius);
                /**
                 * 将其他path添加到其中
                 */
                path.addPath(path2);
                path.addPath(path3);
                path.addPath(path4);
            }
            if(i==count/2)
            {
                MyLog.e("i==count/2:+"+count/2+"-----radius:"+radius);
                PointF pointF1 = new PointF();
                pointF1.set(radius/2,-radius);
                xyList.add(pointF1);
                PointF pointF2 = new PointF();
                pointF2.set(-radius/2,-radius);
                xyList.add(pointF2);
                PointF pointF3 = new PointF();
                pointF3.set(-radius,0);
                xyList.add(pointF3);
                Path path5= new Path();
                MyLog.e("xyList.size():"+xyList.size());
                for (int j = 0; j <xyList.size() ; j++)
                {
                    if(j==0)
                    {
                        path5.setLastPoint(xyList.get(0).x,xyList.get(0).y);
                    }
                    else
                    {
                        path5.lineTo(xyList.get(j).x,xyList.get(j).y);
                        if(j==xyList.size()-1)
                        {
                            path5.close();
                            canvas.drawPath(path5,paint2);
                        }
                    }

                }
            }

            canvas.drawPath(path,paint);
            radius -=50;
        }





    }



}
