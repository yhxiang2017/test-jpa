package cn.xyh.testjpa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by syj on 2018/3/29.
 *
 * 日期工具类
 */
public class DateUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat();

    public static String getNow(){
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static String getNow(String pattern){
        sdf.applyPattern(pattern);
        return sdf.format(new Date());
    }

    public static String getDateString(Date date, String pattern){
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }
}
