package com.rss.boot.handler.douyin.util;

import com.rss.boot.util.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/16 上午11:53
 * @Modified By:
 */
@Slf4j
public class DouyinGetUtil {

    /**
     * 获取最新发布
     *
     * @param url
     * @return
     */
    public static String getDouyinRecentVideo(String url) {
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36";
        Map<String, String> headersMap = new HashMap<>(10);
        headersMap.put("user-agent", userAgent);
        String resultJson = null;

        try {
            resultJson = HttpClientUtil.doGetAddHeaders(url, headersMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultJson;
    }
}
