package com.example.widgetdemo.util;

import android.util.Log;

/**
 * Created by li biao
 * 2017/8/10
 * email:207563927@qq.com
 */
public class MyLog
{
    private static boolean isDebug = true;
    public static void setDebug(boolean debug)
    {
        if(debug)
        {
            isDebug = true;
        }
        else
        {
            isDebug = false;
        }
    }
    public static void e(String info)
    {
        if(isDebug)
        {
            Log.e("TAG",info);
        }
    }
    public static void d(String info)
    {
        if(isDebug)
        {
            Log.d("TAG",info);
        }
    }
}
