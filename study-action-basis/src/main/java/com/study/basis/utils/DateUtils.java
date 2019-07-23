package com.study.basis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author valiantzh
 * @version 1.0
 */
public class DateUtils {
    public static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String nowTime2String(){
        return sdfTime.format(new Date());
    }

    public static String nowDate2String(){
        return sdfDate.format(new Date());
    }

    public static String nowDateTime2String(){
        return sdfDateTime.format(new Date());
    }
}
