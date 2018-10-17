package com.sym.springboot.rest.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiefg
 * @create 2018-01-05 14:10
 * @desc
 **/
@Configuration
public class RestClientFactory {

    @Value("${elasticsearch.host}")
    private  String host ;
    
    @Value("${elasticsearch.port}")
    private  int port;

    @Value("${elasticsearch.schema}")
    private  String schema ;

    @Value("${elasticsearch.connect_time_out}")
    private  int connect_time_out ;

    @Value("${elasticsearch.socket_time_out}")
    private  int socket_time_out ;

    @Value("${elasticsearch.connection_request_time_out}")
    private  int connection_request_time_out ;
    @Value("${elasticsearch.max_connect_num}")
    private  int max_connect_num ;

    @Value("${elasticsearch.max_connect_per_route}")
    private  int max_connect_per_route ;

    private  HttpHost http_host =null;

    @Value("${elasticsearch.uniqueConnectTimeConfig}")
    private  boolean uniqueConnectTimeConfig;
    @Value("${elasticsearch.uniqueConnectNumConfig}")
    private  boolean uniqueConnectNumConfig ;


    private  RestClientBuilder builder;
    private  RestClient restClient;
    private  RestHighLevelClient restHighLevelClient;

    public  void init() {

        if (http_host == null) {
            http_host = new HttpHost(host, port, schema);
        }
        builder = RestClient.builder(http_host);
        if (uniqueConnectTimeConfig) {
            setConnectTimeOutConfig();
        }
        if (uniqueConnectNumConfig) {
            setMutiConnectConfig();
        }
        restClient = builder.build();
        restHighLevelClient = new RestHighLevelClient(builder);
    }

    /**
     * 主要关于异步httpclient的连接延时配置
     */

    public  void setConnectTimeOutConfig() {
        builder.setRequestConfigCallback(requestConfigBuilder -> {
            requestConfigBuilder.setConnectTimeout(connect_time_out);
            requestConfigBuilder.setSocketTimeout(socket_time_out);
            requestConfigBuilder.setConnectionRequestTimeout(connection_request_time_out);
            return requestConfigBuilder;
        });
    }

    /**
     * 主要关于异步httpclient的连接数配置
     */
    public  void setMutiConnectConfig() {
        builder.setHttpClientConfigCallback(httpClientBuilder -> {
            httpClientBuilder.setMaxConnTotal(max_connect_num);
            httpClientBuilder.setMaxConnPerRoute(max_connect_per_route);
            return httpClientBuilder;
        });
    }

    public  RestClient getClient() {
        return restClient;
    }

    @Bean
    public  RestHighLevelClient getHighLevelClient() {
        if (restHighLevelClient == null) {
            init();
        }
        return restHighLevelClient;
    }

    public  void close() {
        if (restHighLevelClient != null) {
            try {
                restHighLevelClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
