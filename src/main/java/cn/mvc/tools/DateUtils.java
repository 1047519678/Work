package cn.mvc.tools;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class DateUtils {
    public static Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
    public static int year = c.get(Calendar.YEAR);
    public static int month = c.get(Calendar.MONTH) + 1;
    public static int date = c.get(Calendar.DATE);
    public static int hour = c.get(Calendar.HOUR_OF_DAY);
    public static int minute = c.get(Calendar.MINUTE);
    public static int second = c.get(Calendar.SECOND);
    public static int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

    public static String GetDateTime(String format){
        String Datetime = "";
        if("yyyy-MM-dd HH:mm:ss".equals(format)) {
            Datetime = year + "-";
            if (month < 10) {
                Datetime = Datetime + "0" + month + "-";
            } else {
                Datetime = Datetime + month + "-";
            }
            if (date < 10) {
                Datetime = Datetime + "0" + date + " ";
            } else {
                Datetime = Datetime + date + " ";
            }
            if (hour < 10) {
                Datetime = Datetime + "0" + hour + ":";
            } else {
                Datetime = Datetime + hour + ":";
            }
            if (minute < 10) {
                Datetime = Datetime + "0" + minute + ":";
            } else {
                Datetime = Datetime + minute + ":";
            }
            if (second < 10) {
                Datetime = Datetime + "0" + second;
            } else {
                Datetime = Datetime + second;
            }
        }else if("yyyy/MM/dd HH:mm:ss".equals(format)){
            Datetime = year + "/";
            if (month < 10) {
                Datetime = Datetime + "0" + month + "/";
            } else {
                Datetime = Datetime + month + "/";
            }
            if (date < 10) {
                Datetime = Datetime + "0" + date + " ";
            } else {
                Datetime = Datetime + date + " ";
            }
            if (hour < 10) {
                Datetime = Datetime + "0" + hour + ":";
            } else {
                Datetime = Datetime + hour + ":";
            }
            if (minute < 10) {
                Datetime = Datetime + "0" + minute + ":";
            } else {
                Datetime = Datetime + minute + ":";
            }
            if (second < 10) {
                Datetime = Datetime + "0" + second;
            } else {
                Datetime = Datetime + second;
            }
        }else if("yyyy/MM/dd".equals(format)){
            Datetime = year + "/";
            if (month < 10) {
                Datetime = Datetime + "0" + month + "/";
            } else {
                Datetime = Datetime + month + "/";
            }
            if (date < 10) {
                Datetime = Datetime + "0" + date;
            } else {
                Datetime = Datetime + date;
            }
        }else if("yyyy-MM-dd".equals(format)){
            Datetime = year + "-";
            if (month < 10) {
                Datetime = Datetime + "0" + month + "-";
            } else {
                Datetime = Datetime + month + "-";
            }
            if (date < 10) {
                Datetime = Datetime + "0" + date;
            } else {
                Datetime = Datetime + date;
            }
        }else if("yyyyMMdd".equals(format)){
            Datetime = "" + year;
            if (month < 10) {
                Datetime =  Datetime + "0" + month;
            } else {
                Datetime = Datetime + month;
            }
            if (date < 10) {
                Datetime = Datetime + "0" + date;
            } else {
                Datetime = Datetime + date;
            }
        }
        return Datetime;
    }

    public static String getDateTime2(String format){
        return new SimpleDateFormat(format).format(new Date());
    }

    public static int GetYear(){
        return year;
    }

    public static int GetMonth(){
        return month;
    }

    public static int GetDate(){
        return date;
    }

    public static int GetHour(){
        return hour;
    }

    public static int GetMinute(){
        return minute;
    }

    public static int GetSecond(){
        return second;
    }

    public static int GetDayOFWeek(){
        return dayOfWeek;
    }

    public static void main(String[] args) throws IOException {
//        DateUtils du = new DateUtils();
//        int day = du.GetDayOFWeek();
//        System.out.println(day);
//        String date = "20200606";
//        String a = date.substring(0,4);
//        System.out.println(a);
//        String b = date.substring(4,6);
//        System.out.println(b);
//        String c = date.substring(6,8);
//        System.out.println(c);
    }
}
