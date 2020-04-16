package com.springcloud.demo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @Description:
 * @Author：xiaojiaxin
 * @Date：2020-04-16 9:16
 */
@EnableWebFluxSecurity
@Slf4j
public class SecurityConfig {
    //security的鉴权排除的url列表
    private static final String[] excludedAuthPages = {
            "/auth/login",
            "/auth/logout",
            "/health",
            "/api/socket/**",
            "/dept/list"
    };

    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        log.info("WebFlux Security Begin");
        http
            .authorizeExchange()
            .pathMatchers(excludedAuthPages).permitAll()  //无需进行权限过滤的请求路径
            .pathMatchers(HttpMethod.OPTIONS).permitAll() //option 请求默认放行
            .anyExchange().authenticated()
            .and()
            .formLogin()
            .loginPage("/auth/require")
            .and().csrf().disable()//必须支持跨域
            .logout().disable();

        return http.build();


    }



}
