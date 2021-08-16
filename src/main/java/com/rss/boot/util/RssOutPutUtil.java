package com.rss.boot.util;

import com.rometools.rome.feed.rss.*;
import com.rss.boot.bean.rss.RssChannel;
import com.rss.boot.bean.rss.RssItem;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author:
 * @Description: RSS输出格式
 * @Date: 2021/8/16 下午4:19
 * @Modified By:
 */
@Slf4j
public class RssOutPutUtil {

    /**
     * Rss输出格式化
     *
     * @param rssChannel
     * @return
     */
    public static Channel rssOutPut(RssChannel rssChannel) {
        Channel channel = new Channel();
        channel.setFeedType("rss_2.0");
        channel.setTitle(rssChannel.getTitle());
        channel.setDescription(rssChannel.getDescription());
        channel.setLink(rssChannel.getLink());
        channel.setUri(rssChannel.getUri());
        channel.setGenerator("RssClub");

        Image image = new Image();
        image.setUrl(rssChannel.getImage().getUrl());
        image.setTitle(rssChannel.getImage().getTitle());
        image.setHeight(32);
        image.setWidth(32);
        channel.setImage(image);

        Date postDate = new Date();
        channel.setPubDate(postDate);

        List<Item> items = new ArrayList<>(100);
        channel.setItems(items);

        List<RssItem> rssItemList = rssChannel.getItems();

        for (RssItem rssItem : rssItemList) {
            Item item = new Item();
            item.setAuthor(rssItem.getAuthor());
            item.setLink(rssItem.getLink());
            item.setTitle(rssItem.getTitle());
            item.setUri(rssItem.getUri());
            item.setComments(rssItem.getComments());

            Category category = new Category();
            category.setValue("CORS");
            item.setCategories(Collections.singletonList(category));

            Description descr = new Description();
            descr.setValue(rssItem.getDescription());
            item.setDescription(descr);

            item.setPubDate(rssItem.getPubDate());

            items.add(item);
        }

        return channel;
    }

}
