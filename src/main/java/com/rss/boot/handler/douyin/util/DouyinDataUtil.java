package com.rss.boot.handler.douyin.util;

import com.rss.boot.util.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/16 下午4:57
 * @Modified By:
 */
@Slf4j
public class DouyinDataUtil {

    /**
     * 从JS中获取Json数据
     *
     * @param document
     * @return
     */
    public static String getAwemeJson(Document document) {
        Elements e = document.getElementsByTag("script").eq(0);
        String renderdata = e.html();
        if (StringUtils.isBlank(renderdata) || !renderdata.startsWith("type=")) {
            for (int i = 1; i < 20; i++) {
                e = document.getElementsByTag("script").eq(i);
                renderdata = e.html();
                if (StringUtils.isNotBlank(renderdata)) {
                    break;
                }
            }
        }

        //编码转换
        String json1 = UrlUtil.URLDecoderString(renderdata);

        return json1;
    }
}
