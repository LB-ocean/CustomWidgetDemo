package com.example.widgetdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */
public class EightDiagramsView extends View
{

    /**
     * 绘制 太极八卦图
     * 1.首先根据图，可分两个 大圆:黑，白；
     * 2.每个大圆里边 又有 1/2的反色圆,再就是 眼睛,又是1/4
     *
     * @param context
     */

    private Paint paint1 = new Paint();
    private Paint paint2 = new Paint();
    private Paint paint3 = new Paint();
    private int nWidth,nHeight;
    /**
     * 旋转角度
     */
    private int roate = 0;
    public EightDiagramsView(Context context)
    {
        super(context);
        init();
    }

    public EightDiagramsView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();

    }

    private void init()
    {
        paint1.setAntiAlias(true);
        paint1.setColor(Color.BLACK);
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.WHITE);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint3.setAntiAlias(true);
        paint3.setColor(Color.GRAY);
        paint3.setStyle(Paint.Style.STROKE);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        this.nWidth = w;
        this.nHeight = h;
    }


    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        int radius = (int) (Math.min(nWidth,nHeight)/2*0.8);
        canvas.translate(nWidth/2,nHeight/2);
        /**
         * 记得要在画布之前选装
         */
        canvas.rotate(roate,0,0);
        RectF rectF = new RectF(-radius,-radius,radius,radius);
        canvas.drawArc(rectF,0,180,true,paint1);
        canvas.drawArc(rectF,180,180,true,paint2);
        canvas.drawCircle(-radius/2,0,radius/2,paint1);
        canvas.drawCircle(-radius/2,0,radius/8,paint2);
        canvas.drawCircle(radius/2,0,radius/2,paint2);
        canvas.drawCircle(radius/2,0,radius/8,paint1);
    }

    public void setRoate(int roate)
    {
        this.roate = roate;
        invalidate();
    }


}
