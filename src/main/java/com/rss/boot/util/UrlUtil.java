package com.rss.boot.util;

import java.io.UnsupportedEncodingException;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/16 下午12:10
 * @Modified By:
 */
public class UrlUtil {

    /**
     * URL编码
     *
     * @param str
     * @return
     */
    public static String URLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * URL解码
     *
     * @param str
     * @return
     */
    public static String URLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


}
