package com.rss.boot.controlloer;

import com.rometools.rome.feed.rss.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/16 下午12:16
 * @Modified By:
 */
@Slf4j
@RestController
@RequestMapping("feed")
public class RssController {

    @GetMapping(path = "/rss1")
    public Channel rss() {
        log.info("rss1");

        Channel channel = new Channel();
        channel.setFeedType("rss_2.0");
        channel.setTitle("入门小站-rumenz.com Feed");
        channel.setDescription("Different Articles on latest technology");
        channel.setLink("https://howtodoinjava.com");
        channel.setUri("https://howtodoinjava.com");
        channel.setGenerator("In House Programming");

        Image image = new Image();
        image.setUrl("https://howtodoinjava.com/static-content/uploads/2015/05/java.png");
        image.setTitle("入门小站-rumenz.com Feed");
        image.setHeight(32);
        image.setWidth(32);
        channel.setImage(image);

        Date postDate = new Date();
        channel.setPubDate(postDate);

        Item item = new Item();
        item.setAuthor("Lokesh Gupta");
        item.setLink("https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/");
        item.setTitle("Spring CORS Configuration Examples");
        item.setUri("https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/");
        item.setComments("https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/#respond");

        Category category = new Category();
        category.setValue("CORS");
        item.setCategories(Collections.singletonList(category));

        Description descr = new Description();
        descr.setValue(
                "CORS helps in serving web content from multiple domains into browsers who usually have the same-origin security policy. In this example, we will learn to enable CORS support in Spring MVC application at method and global level."
                        + "The post <a rel=\"nofollow\" href=\"https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/\">Spring CORS Configuration Examples</a> appeared first on <a rel=\"nofollow\" href=\"https://howtodoinjava.com\">入门小站-rumenz.com</a>.");
        item.setDescription(descr);
        item.setPubDate(postDate);

        channel.setItems(Collections.singletonList(item));
        return channel;
    }

}
