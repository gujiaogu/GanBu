package com.uestc.ganbu.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeFormatUtil {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
    public static final SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA);
    public static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
    public static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM", Locale.CHINA);
    public static final SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-M-d", Locale.CHINA);
    public static final SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    public static final SimpleDateFormat sdf7 = new SimpleDateFormat("yyyy", Locale.CHINA);
    public static final SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy年MM月", Locale.CHINA);
    public static final SimpleDateFormat sdf9 = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA);
    public static final SimpleDateFormat sdf10 = new SimpleDateFormat("MM-dd", Locale.CHINA);
}
