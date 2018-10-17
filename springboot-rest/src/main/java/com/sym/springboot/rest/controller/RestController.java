package com.sym.springboot.rest.controller;

import com.alibaba.fastjson.JSON;
import com.sym.springboot.domain.entity.Order;
import com.sym.springboot.rest.config.RestClientFactory;
import com.sym.springboot.service.OrderService;
import com.sym.springboot.utils.RedisUtil;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/11
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("test")
public class RestController {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Resource(name = "renrenJdbcTemp")
    private JdbcTemplate renrenjdbc;

    @GetMapping("/a")
    public Object a() {
        String sql = "SELECT mobile FROM `order` WHERE id = 1";
        String sql1 = " SELECT NAME FROM sys_menu WHERE  menu_id = 1 ";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        Map<String, Object> map1 = renrenjdbc.queryForMap(sql1);
        Order order = orderService.get();

        /*return map.get("mobile").toString()+map1.get("name").toString();*/
        return JSON.toJSON(order);
    }


    @GetMapping("/all")
    public Object findAll() {
        List<Order> all = orderService.findAll();
        return all;
    }

    @GetMapping("/findOrderById")
    public Object findOrderById() {

        Order order = orderService.findOrderById();
        return order;
    }

    @GetMapping("redis")
    public Object redis() {
        RedisUtil.set("a", 4);
        return RedisUtil.get("a");
    }

    @GetMapping("es")
    public Object es() throws IOException {
        /*IndexRequest request = new IndexRequest("wr_product_index", "wr_product_type", "11854");*/
        IndexRequest request = new IndexRequest("wr_product_index","wr_product_type");
        // 将保存数据以JSON格式关联到请求
        request.source(XContentType.JSON);
        // Java客户端发起保存数据请求
        IndexResponse response = restHighLevelClient.index(request);
        // 等待结果
        System.out.println(response);

        return response;
    }
    @GetMapping("es1")
    public Object es1() throws IOException {
        SearchResponse response = null;
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        /*sourceBuilder.from(0);
        sourceBuilder.size(10);*/
        sourceBuilder.fetchSource(new String[]{"title"}, new String[]{});
        sourceBuilder.fetchSource(new String[]{"name_id"}, new String[]{});
        /*MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "大手提袋");*/
        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("title", "石花菜");
       /* RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("publishTime");
        rangeQueryBuilder.gte("2018-01-26T08:00:00Z");
        rangeQueryBuilder.lte("2018-01-26T20:00:00Z");*/
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        /*boolBuilder.must(matchQueryBuilder);*/
        boolBuilder.must(wildcardQueryBuilder);

        /*boolBuilder.must(rangeQueryBuilder);*/
        sourceBuilder.query(boolBuilder);
        SearchRequest searchRequest = new SearchRequest("product_spec_price_integrate");
        searchRequest.types("product_spec_price_integrate_mp");
        searchRequest.source(sourceBuilder);
        try {
            response = restHighLevelClient.search(searchRequest);
            System.out.println(response);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }

}
