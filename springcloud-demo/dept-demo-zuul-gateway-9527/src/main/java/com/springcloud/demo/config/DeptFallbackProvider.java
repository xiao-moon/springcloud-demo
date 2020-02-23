package com.springcloud.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @program: springcloud-demo
 * @description:
 * @author: 小月
 * @create: 2019-12-14 16:15
 **/
@Component
public class DeptFallbackProvider implements FallbackProvider {
    private Logger logger = LoggerFactory.getLogger("DeptFallbackProvider");

    /**
    *@Description: getRoute方法的返回值就是要监听的挂掉的微服务名字*,
     * api服务id，如果需要所有调用都支持回退，则return "*"或return null
    *@Author: 小月
    *@date:
    */
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        logger.info("--> route:{}进行熔断降级", route);
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("dept-demo-provider服务不可用".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", StandardCharsets.UTF_8);
                headers.setContentType(mt);
                return headers;
            }
        };

    }
}
