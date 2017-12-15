package com.gaohanna.oasis.testES;

import com.gaohanna.oasis.manager.ElasticSearchClientManager;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * something
 *
 * @author keben
 * @date 2017/12/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OasisApplicationTests {
    @Autowired
    private ElasticSearchClientManager elasticSearchClientManager;

    @Test
    public void testTransportClient() throws IOException {
        RestHighLevelClient client = elasticSearchClientManager.getClient();
        GetRequest request = new GetRequest("logstash-2017.12.06", "doc", "2_MEK2ABgvSr85tgkhIQ");
        GetResponse response = client.get(request);
        String sourceString = response.getSourceAsString();
        System.out.println(sourceString);
    }
}
