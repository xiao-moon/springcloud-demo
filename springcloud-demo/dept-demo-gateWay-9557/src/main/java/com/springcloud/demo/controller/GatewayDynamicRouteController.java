package com.springcloud.demo.controller;

import com.springcloud.demo.dynamic_route.GatewayDynamicRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @Description:
 * @Author：xiaojiaxin
 * @Date：2020-04-22 18:24
 */
@RestController
@RequestMapping("/gateway")
@Slf4j
public class GatewayDynamicRouteController {

    @Resource
    private GatewayDynamicRouteService gatewayDynamicRouteService;

    @GetMapping("/type")
    public Object requestBodyType() throws URISyntaxException {
        RouteDefinition routeDefinition = new RouteDefinition();

        //predicates
        List<PredicateDefinition> predicates = new ArrayList();
        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicateDefinition.setName("Path");
        HashMap<String, String> map = new HashMap<>();
        map.put("pattern","/soa-security-service/test.do");
        predicateDefinition.setArgs(map);
        predicates.add(predicateDefinition);
        routeDefinition.setPredicates(predicates);

        //filters
        List<FilterDefinition> filterDefinitions = new ArrayList();
        FilterDefinition filterDefinition = new FilterDefinition();
        filterDefinition.setName("RequestRateLimiter");
        filterDefinition.addArg("key-resolver","#{@hostAddrKeyResolver}");
        filterDefinition.addArg("redis-rate-limiter.replenishRate","1");
        filterDefinition.addArg("redis-rate-limiter.burstCapacity","3");
        filterDefinitions.add(filterDefinition);
        routeDefinition.setFilters(filterDefinitions);

        //metadata
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("test","test_result");
        routeDefinition.setMetadata(metadata);

        URI uri = new URI("lb://soa-security-service/**");
        routeDefinition.setUri(uri);

        routeDefinition.setOrder(1);
        return  routeDefinition;
    }


    @GetMapping("/get")
    public Object get() {
        return  gatewayDynamicRouteService.get();
    }


    @PostMapping("/add")
    public String create(@RequestBody RouteDefinition entity) {
        int result = gatewayDynamicRouteService.add(entity);
        return String.valueOf(result);
    }

    @PostMapping("/update")
    public String update(@RequestBody RouteDefinition entity) {
        int result = gatewayDynamicRouteService.update(entity);
        return String.valueOf(result);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Object>> delete(@PathVariable String id) {
        return gatewayDynamicRouteService.delete(id);
    }

}

