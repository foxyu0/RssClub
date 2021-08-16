package com.rss.boot.bean.rss;

import lombok.Data;

import java.util.Date;

/**
 * @Author:
 * @Description: RSS Item实体类
 * @Date: 2021/8/16 下午2:27
 * @Modified By:
 */
@Data
public class RssItem {
    public String title;
    public String author;
    public String link;
    public String uri;
    public String comments;
    public String description;
    public Date pubDate;
}
