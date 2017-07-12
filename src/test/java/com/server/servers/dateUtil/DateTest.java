package com.server.servers.dateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        Date currentDate = new Date();
        System.out.println("currentDate = " + currentDate.getTime());
        Date nowDate = new Date(currentDate.getTime());
        System.out.println("nowDate = " + nowDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(nowDate);
        System.out.println("str = " + str);
        Date date = simpleDateFormat.parse(str);
        System.out.println("date = " + date);
    }
}
