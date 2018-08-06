package com.zy.myutil;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/25.
 */
public class Time {
    public static String time(){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    public static String timeDay1(){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(calendar.getTime());
    }
    public static String time2(){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    public static String timeHMS(){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }
    public static long startTime9(){
        String starttime="09:00:00";
        String [] array=starttime.split(":");
        int hour=Integer.parseInt(array[0]);
        int min=Integer.parseInt(array[1]);
        int sec=Integer.parseInt(array[2]);
        long starttime9=(hour*3600+min*60+sec)*1000;
        return starttime9;
    }
    public static long startTime6(){
        String starttime="18:00:00";
        String [] array=starttime.split(":");
        int hour=Integer.parseInt(array[0]);
        int min=Integer.parseInt(array[1]);
        int sec=Integer.parseInt(array[2]);
        long starttime6=(hour*3600+min*60+sec)*1000;
        return starttime6;
    }
    public static long startTime2(String startTime){
        String [] array=startTime.split(":");
        int hour=Integer.parseInt(array[0]);
        int min=Integer.parseInt(array[1]);
        int sec=Integer.parseInt(array[2]);
        long starttime2=(hour*3600+min*60+sec)*1000;
        return starttime2;
    }

    public static String firstDay(){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //获取前一个月第一天
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH,1);
        String firstDay = sdf.format(calendar1.getTime());
        System.out.println(firstDay);
        return firstDay;
    }

    public static String lastDay(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //获取前一个月最后一天
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH,0);
        calendar1.set(Calendar.DAY_OF_MONTH, 0);
        String lastDay = sdf.format(calendar1.getTime());
        return lastDay;
    }
}
