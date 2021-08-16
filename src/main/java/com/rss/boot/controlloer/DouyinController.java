package com.rss.boot.controlloer;

import com.rometools.rome.feed.rss.Channel;
import com.rss.boot.bean.rss.RssChannel;
import com.rss.boot.handler.douyin.bean.DouyinUserAwemeV1DTO;
import com.rss.boot.handler.douyin.util.DouyinDataUtil;
import com.rss.boot.handler.douyin.util.DouyinGetUtil;
import com.rss.boot.handler.douyin.util.DouyinParseUtil;
import com.rss.boot.util.JsonUtil;
import com.rss.boot.util.RssOutPutUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/16 下午4:38
 * @Modified By:
 */
@Slf4j
@RestController
@RequestMapping("douyin")
public class DouyinController {

    /**
     * 获取最新作品
     *
     * @param id 用户ID
     * @return
     */
    @GetMapping(path = "/user/video/{id}")
    public Channel rss(@PathVariable("id") String id) {

        if (StringUtils.isBlank(id)) {
            log.error(String.format("id错误，id=%s", id));
        }
        String url = String.format("https://www.douyin.com/user/%s?previous_page=app_code_link", id);

        String resultJson = DouyinGetUtil.getDouyinRecentVideo(url);
        Document document = Jsoup.parseBodyFragment(resultJson, "utf-8");
        String title = document.title();

        String json1 = DouyinDataUtil.getAwemeJson(document);
        DouyinUserAwemeV1DTO v1DTO = JsonUtil.fromJson(json1, DouyinUserAwemeV1DTO.class);

        RssChannel rssChannel = DouyinParseUtil.douyinRecentVideo(v1DTO, title, url);

        Channel channel = RssOutPutUtil.rssOutPut(rssChannel);
        return channel;
    }
}
