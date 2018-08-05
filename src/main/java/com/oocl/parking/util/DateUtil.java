package com.oocl.parking.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String parseDateToString(Date date)  {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        Date newDate = calendar.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yy/MM/dd HH:mm");
        return sdf.format(newDate);
    }

}
