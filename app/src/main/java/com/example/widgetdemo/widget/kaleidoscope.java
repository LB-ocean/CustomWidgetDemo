package com.example.widgetdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.widgetdemo.bean.Pie;
import com.example.widgetdemo.util.MyLog;


/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */

/**
 * 万花筒View
 */
public class kaleidoscope extends View
{

    /**
     * 确定思路:
     * 1.利用paint 画笔填充 画圆
     * 2.不断改变半径
     * 3.重复
     */
    /**
     * 万花筒颜色
     */
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private Paint paint = new Paint();
    private int nWidth,nHeight;
    private boolean flag = false;
    private Pie pie = new Pie();
    public kaleidoscope(Context context)
    {
        super(context);
    }

    public kaleidoscope(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        nWidth = w;
        nHeight =h;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        MyLog.e("onDraw()---:");
        int centre = (int) (Math.min(nWidth,nHeight)/2*0.8);
        canvas.translate(nWidth/2,nHeight/2);
        paint.setColor(pie.getColor());
        canvas.drawCircle(0,0,pie.getRadius(),paint);
    }


    public void setFlag(Pie pie)
    {
        this.pie =pie;
        invalidate();
    }

}
