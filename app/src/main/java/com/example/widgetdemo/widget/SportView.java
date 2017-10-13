package com.example.widgetdemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.widgetdemo.R;
import com.example.widgetdemo.util.MyLog;


/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */

/**
 * 计步器
 */
public class SportView extends View
{
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private int centre,nWidth,nHeight;
    private int angle;
    private float paintWidth = 80;
    private float paintTextSize = 40;
    private RectF rectF;
    //背景颜色
    private int paintColorBg = Color.GRAY;
    //填充颜色
    private int paintColorFill = Color.RED;
    //文字颜色
    private int paintTextColor = Color.BLUE;
    public SportView(Context context)
    {
        super(context);
    }
    //布局里边静态添加
    public SportView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SportView);
        paintColorBg = typedArray.getColor(R.styleable.SportView_paintColorBg,Color.GRAY);
        paintColorFill = typedArray.getColor(R.styleable.SportView_paintColorFill,Color.RED);
        paintTextColor = typedArray.getColor(R.styleable.SportView_paintTextFill,Color.BLUE);
        paintWidth = typedArray.getDimension(R.styleable.SportView_paintWidth,paintWidth);
        paintTextSize = typedArray.getDimension(R.styleable.SportView_paintTextSize,paintTextSize);

        paint1 = new Paint();
        paint2 = new Paint();
        paint3 = new Paint();
        init();
        typedArray.recycle();
    }

    public SportView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }
    private void init()
    {

        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(paintColorBg);
        paint1.setStrokeWidth(paintWidth);
        paint1.setStrokeCap(Paint.Cap.ROUND);


        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(paintColorFill);
        paint2.setStrokeWidth(paintWidth);
        paint2.setStrokeCap(Paint.Cap.ROUND);


        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setColor(paintTextColor);
        paint3.setTextSize(paintTextSize);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setStrokeCap(Paint.Cap.ROUND);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        nWidth = getMeasuredWidth();
        nHeight = getMeasuredHeight();
        setMeasuredDimension(nWidth,nHeight);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        centre = (int) (Math.min(w,h)/2*0.8);
        rectF = new RectF(-centre+paintWidth/2,-centre+paintWidth/2,centre-paintWidth/2,centre-paintWidth/2);
        MyLog.e("onSizeChanged-  nHeight:"+h+";nWidth:"+w);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        MyLog.e("onDraw------");
        canvas.translate(nWidth/2,nHeight/2);
        canvas.drawText("步数:"+angle,0,0,paint3);
        canvas.save();
        canvas.rotate(135);


        canvas.drawArc(rectF,0,270,false,paint1);
        canvas.drawArc(rectF,0,270 * angle / 100,false,paint2);
        canvas.restore();

    }


    public void setValues(int angle)
    {
        this.angle = angle;
        invalidate();
    }

    public void setPaintWidth(int paintWidth)
    {
        this.paintWidth = paintWidth;
        init();
        invalidate();
    }
}
