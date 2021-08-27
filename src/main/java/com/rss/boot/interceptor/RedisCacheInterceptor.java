package com.rss.boot.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author:
 * @Description:
 * @Date: 2021/8/25 下午4:43
 * @Modified By:
 */

@Slf4j
@Component
public class RedisCacheInterceptor implements HandlerInterceptor {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (StringUtils.equalsIgnoreCase(request.getMethod(), "OPTIONS")) {
            return true;
        }

        // 判断请求方式，get还是post还是其他。。。
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), "GET") && !StringUtils.equalsIgnoreCase(request.getMethod(), "POST")) {
            // 非get请求，如果不是graphql请求，放行
            if (!StringUtils.equalsIgnoreCase(request.getRequestURI(), "/graphql")) {
                return true;
            }
        }

        // 通过缓存做命中，查询redis，redisKey ?  组成：md5（请求的url + 请求参数）
        String redisKey = createRedisKey(request);
        String data = this.redisTemplate.opsForValue().get(redisKey);
        if (StringUtils.isEmpty(data)) {
            // 缓存未命中
            return true;
        }

        log.info("Redis存在RSS数据，key=" + request.getRequestURI());

        // 将data数据进行响应
        response.setCharacterEncoding("UTF-8");
        //response.setContentType("application/json; charset=utf-8");
        response.setContentType("application/rss+xml; charset=utf-8");
        //response.setContentType("application/xml; charset=utf-8");
        //response.setContentType("text/plain; charset=utf-8");
        //response.setContentType("text/xml; charset=utf-8");

        // 支持跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Token");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        //response.getWriter().write(data);
        response.getWriter().print(data);


        return false;
    }

    /**
     * @param request
     * @return
     * @throws Exception
     */
    public static String createRedisKey(HttpServletRequest request) throws Exception {
        String paramStr = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.isEmpty()) {
            paramStr += IOUtils.toString(request.getInputStream(), "UTF-8");
        } else {
            paramStr += MAPPER.writeValueAsString(request.getParameterMap());
        }

        String redisKey = "RSS_DATA_" + paramStr + "_" + DigestUtils.md5Hex(paramStr);
        return redisKey;
    }
}
