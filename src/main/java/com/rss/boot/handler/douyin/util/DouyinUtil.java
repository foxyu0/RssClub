package com.rss.boot.handler.douyin.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/16 下午3:25
 * @Modified By:
 */
@Slf4j
public class DouyinUtil {

    /**
     * 校验URL是否以http开头，添加http
     *
     * @param url
     * @return
     */
    public static String checkUrlAddHttp(String url) {
        if (!url.startsWith("http")) {
            url = "http:" + url;
        }

        return url;
    }
}
