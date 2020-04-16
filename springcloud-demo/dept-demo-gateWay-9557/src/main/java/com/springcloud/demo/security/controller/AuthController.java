package com.springcloud.demo.security.controller;

import com.springcloud.demo.security.supports.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * @Description:表单提交处理
 * @Author：xiaojiaxin
 * @Date：2020-04-16 15:13
 */
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    @RequestMapping("/login")
    public Mono<LoginResponse> requireAuthentication(ServerRequest request, ServerResponse response){

        ServerWebExchange exchange = request.exchange();
        if (exchange != null) {
            ServerHttpRequest request1 = exchange.getRequest();
            InetSocketAddress remoteAddress = request1.getRemoteAddress();
        }

        return Mono.just(new LoginResponse(0,"跳转登录","请登录"));
    }



}
