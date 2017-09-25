package com.weatherapp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Xpieon on 25/09/2017.
 */

public class DateTimeUtil {

    public static String getDay(Date date){
        DateFormat format = new SimpleDateFormat("EEEEEEEEE", Locale.ENGLISH);
        return format.format(date);
    }

    public static String getTime(Date date){
        DateFormat format = new SimpleDateFormat("hh-aa", Locale.ENGLISH);
        return format.format(date);
    }

}
