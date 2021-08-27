package com.rss.boot.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rometools.rome.feed.rss.Channel;
import com.rss.boot.util.RssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.Duration;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/25 下午5:11
 * @Modified By:
 */

@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if (returnType.hasMethodAnnotation(GetMapping.class)) {
            return true;
        }

        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        try {
            String redisKey = RedisCacheInterceptor.createRedisKey(((ServletServerHttpRequest) request).getServletRequest());
            String redisValue = null;
            if (body instanceof String) {
                redisValue = (String) body;
            } else if (body instanceof Channel) {
                //RSS输出格式，转为XML，存储Redis
                System.out.println("Channel");
                Channel channel = (Channel) body;
                redisValue = RssUtil.rssChannelOutPutXml(channel);
            } else {
                redisValue = mapper.writeValueAsString(body);
            }

            //缓存1小时
            this.redisTemplate.opsForValue().set(redisKey, redisValue, Duration.ofHours(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }
}
