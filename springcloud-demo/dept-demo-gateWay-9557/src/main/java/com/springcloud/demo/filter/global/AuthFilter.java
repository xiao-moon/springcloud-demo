package com.springcloud.demo.filter.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @Description:获取请求体
 * @Author：xiaojiaxin
 * @Date：2020-04-21 15:15
 */
@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("REQUEST_TIME_BEGIN", System.currentTimeMillis());
        log.info("进入AuthFilter中...准备获取请求体");
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        Flux<DataBuffer> body = serverHttpRequest.getBody();
        StringBuffer sb = new StringBuffer();

        //异步操作
        body.subscribe(buffer -> {
            sb.append("1234");
            byte[] bytes = new byte[buffer.readableByteCount()];
            buffer.read(bytes);
            DataBufferUtils.release(buffer);
            String bodyString = new String(bytes, StandardCharsets.UTF_8);
            log.info(bodyString);
            sb.append(bodyString.toString());
            sb.append("1234");
            log.info("异步的:"+sb.toString());
        });
        log.info("请求体内容;{}", sb.toString());

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute("REQUEST_TIME_BEGIN");
            if (startTime != null) {
                log.info(exchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
                log.info("getBody===" + exchange.getRequest().getBody().toString());
                log.info("getHeaders===" + exchange.getRequest().getHeaders());
            }
        }));
    }

    @Override
    public int getOrder() {
        return -999;
    }
}
