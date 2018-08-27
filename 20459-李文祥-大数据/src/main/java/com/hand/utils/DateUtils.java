package com.hand.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WenxiangLi on 2018/8/23.
 */
public class DateUtils {
    public static String getNowDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = simpleDateFormat.format(date);
        return string;
    }
}
