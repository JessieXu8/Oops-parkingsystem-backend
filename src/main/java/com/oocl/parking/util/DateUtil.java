package com.oocl.parking.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String parseDateToString(Date date)  {
        SimpleDateFormat sdf=new SimpleDateFormat("yy/MM/dd HH:mm");
    return sdf.format(date);
    }
}
