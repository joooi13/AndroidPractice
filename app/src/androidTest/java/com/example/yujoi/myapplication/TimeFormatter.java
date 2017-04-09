package com.example.yujoi.myapplication;

/**
 * Created by yujoi on 2017/03/14.
 */

public class TimeFormatter {

    /*
    seconds が0以下のときは "" を返す
seconds が1分未満のときは、"秒前" を返す
seconds が1分以上1時間未満のときは、"分前" を返す
seconds が1時間以上1日未満のときは "時間前" を返す
seconds が1日以上のときは "日前" を返す
     */
    public static String format(int seconds){

        if(seconds < 0){
            return "";
        }
        if(seconds < 60){
            return  seconds + "秒前";
        }
        if (seconds < 3600) {
            return (seconds / 60) + "分前";
        }
        if (seconds < 86400) {
            return (seconds / 3600) + "時間前";
        }
        return (seconds / 86400) + "日前";
    }
}
