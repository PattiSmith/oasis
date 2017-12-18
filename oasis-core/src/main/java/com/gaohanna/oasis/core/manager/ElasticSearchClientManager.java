package com.gaohanna.oasis.core.manager;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;

/**
 * something
 *
 * @author keben
 * @date 2017/12/12
 */
@Component
public class ElasticSearchClientManager {
    private RestHighLevelClient client;

    public RestHighLevelClient getClient(){
        if (client == null) {
            client = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost("localhost", 9200, "http"),
                            new HttpHost("localhost", 9201, "http")));
        }
        return client;
    }
}
