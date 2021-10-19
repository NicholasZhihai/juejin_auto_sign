package com.example.mytestpro.util;

import io.netty.util.internal.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatUtil {
    public static String YYYYMMDD="yyyyMMdd";
    public static String DateToString(Date date,String strDateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        return sdf.format(date);
    }
    public static Double DateToDouble(Date date,String strDateFormat){
        return Double.valueOf(DateToString(date,strDateFormat));
    }
}
