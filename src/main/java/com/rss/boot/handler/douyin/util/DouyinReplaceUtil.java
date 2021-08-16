package com.rss.boot.handler.douyin.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/16 下午12:11
 * @Modified By:
 */
@Slf4j
public class DouyinReplaceUtil {

    /**
     * 替换Json中的字段名
     * 抖音Json字符串-首字符大写
     *
     * @param json
     * @return
     */
    public static String replaceClassName(String json) {
        String result = json.replaceAll("_location", "location");
        result = result.replaceAll("C_0", "c0");
        result = result.replaceAll("C_10", "c10");
        result = result.replaceAll("C_12", "c12");

        return result;
    }
}
