package cn.mvc.tools;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class timeUtil {
    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date now() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp _dtime = new Timestamp(date.getTime());
        Date dtime = null;
        try {
            dtime = sdf.parse(_dtime.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dtime;
    }

    /**
     * Timestamp 转 date
     *
     * @param time
     * @return
     */
    public static Date timeToDate(Timestamp time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dtime = null;
        try {
            dtime = sdf.parse(time.toString());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dtime;
    }

    /**
     * string转timestamp
     */
    public static Timestamp strToTimetamp(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp times = null;
        try {
            Date date = sdf.parse(time);
            String str = sdf.format(date);
            times = Timestamp.valueOf(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return times;
    }

    /**
     * 功能描述：返回年
     *
     * @param date Date 日期
     * @return 返回年份
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 功能描述：返回月
     *
     * @param date Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日期
     *
     * @param date Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫
     *
     * @param date 日期
     * @return 返回毫
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 返回当前日期
     */
    public static String getdate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        String currentDate = dateFormat.format(new Date());
        return currentDate;
    }

    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    //日期加一天
    public static String addDay(String date) {
        String date2 = null;
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            Date _date = (Date) format1.parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(_date);
            c.add(Calendar.DAY_OF_MONTH, 1);
            date2 = format1.format(c.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date2;
    }

    //当前时日期加一天
    public static String getNextDay() {
        String date2 = null;

        try {
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            Date _date = (Date) format1.parse(format1.format(new Date()));
            Calendar c = Calendar.getInstance();
            c.setTime(_date);
            c.add(Calendar.DAY_OF_MONTH, 1);
            date2 = format1.format(c.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date2;
    }

    //当前时日期加一天
    public static String getLastDay(String date) {
        String date2 = null;

        try {
            DateFormat format1 = new SimpleDateFormat(date);
            Date _date = (Date) format1.parse(format1.format(new Date()));
            Calendar c = Calendar.getInstance();
            c.setTime(_date);
            c.add(Calendar.DAY_OF_MONTH, -1);
            date2 = format1.format(c.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date2;
    }
}
