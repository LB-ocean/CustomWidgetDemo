package com.example.widgetdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.widgetdemo.bean.Pie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */

/**
 * 画饼
 */
public class PieChartView extends View
{

    /**
     * 确定思路：
     * 1.饼块 种类数量
     * 2.饼块 所占百分比
     * 3.饼块颜色
     */

    /**
     * 饼状颜色
     */
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private Paint paint = new Paint();
    private int nWidth,nHeight;
    private List<Pie> pieList = new ArrayList<>();
    public PieChartView(Context context)
    {
        super(context);
        initData(null);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    public PieChartView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initData(null);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        nWidth = w;
        nHeight =h;
    }
    private void initData(List<Pie> pieList2)
    {
        if(pieList2==null)
        {
            Pie pie = new Pie();
            pie.setColor(mColors[0]);
            pie.setPercentage(20);
            pieList.add(pie);

            Pie pie2 = new Pie();
            pie2.setColor(mColors[1]);
            pie2.setPercentage(80);
            pieList.add(pie2);

            Pie pie3 = new Pie();
            pie3.setColor(mColors[2]);
            pie3.setPercentage(80);
            pieList.add(pie3);

            Pie pie4 = new Pie();
            pie4.setColor(mColors[3]);
            pie4.setPercentage(90);
            pieList.add(pie4);

            Pie pie5 = new Pie();
            pie5.setColor(mColors[4]);
            pie5.setPercentage(45);
            pieList.add(pie5);

            Pie pie6 = new Pie();
            pie6.setColor(mColors[5]);
            pie6.setPercentage(45);
            pieList.add(pie6);
        }
        else
        {
            pieList = pieList2;
        }


    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float  radius = (float) (Math.min(nWidth,nHeight)/2*0.9);
        int startAngle = 0;
        canvas.translate(nWidth/2,nHeight/2);
        if(pieList==null)
        {
            return;
        }
        RectF rectF = new RectF(-radius,-radius,radius,radius);
        for (int i = 0; i <pieList.size() ; i++)
        {
            paint.setColor(pieList.get(i).getColor());
            canvas.drawArc(rectF,startAngle,pieList.get(i).getPercentage(),true,paint);
            startAngle +=pieList.get(i).getPercentage();
        }

    }

    /**
     * 外部改变数据
     * @param pieList
     */
    public void setFixData(List<Pie> pieList)
    {
        initData(pieList);
        invalidate();
    }

}
