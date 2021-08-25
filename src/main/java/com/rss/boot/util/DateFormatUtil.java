package com.rss.boot.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/16 下午4:04
 * @Modified By:
 */
@Slf4j
public class DateFormatUtil {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 秒转为毫秒
     * second---1629625979
     * millisecond---1629625979000
     *
     * @param second
     * @return
     */
    public static Date secondToMillisecond(Integer second) {
        Long millisecond = second.longValue() * 1000;
        Date date = new Date(millisecond);
        return date;
    }
}
