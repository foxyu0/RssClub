package com.rss.boot.bean.rss;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author:
 * @Description: RSS Channel实体类
 * @Date: 2021/8/16 下午12:28
 * @Modified By:
 */
@Data
public class RssChannel {

    public String title;
    public String description;
    public String link;
    public String uri;
    public String generator;
    public Date pubDate;
    public List<RssItem> items;
    public RssImage image;

}
