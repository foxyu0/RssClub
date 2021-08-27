package com.rss.boot.util;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.WireFeedOutput;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/25 下午9:25
 * @Modified By:
 */
@Slf4j
public class RssUtil {

    /**
     * Channel转为Xml格式
     *
     * @param channel
     * @return
     */
    public static String rssChannelOutPutXml(Channel channel) {
        WireFeedOutput out = new WireFeedOutput();
        try {
            String xml = out.outputString(channel);
            //System.out.println(xml);
            return xml;
        } catch (FeedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
