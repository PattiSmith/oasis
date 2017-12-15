package com.gaohanna.oasis.controller;

import com.gaohanna.oasis.ao.IElasticSearchAO;
import com.gaohanna.oasis.entity.BizResult;
import com.gaohanna.oasis.entity.PageResult;
import com.gaohanna.oasis.form.QueryPageForm;
import com.gaohanna.oasis.manager.ElasticSearchClientManager;
import com.gaohanna.oasis.vo.TmsWorkbenchVO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * something
 *
 * @author keben
 * @date 2017/12/12
 */
@Controller
public class TestController {

    @Autowired
    private ElasticSearchClientManager elasticSearchClientManager;
    @Autowired
    private IElasticSearchAO elasticSearchAO;

    @RequestMapping("/")
    @ResponseBody
    public List<String> test() throws IOException {
        RestHighLevelClient client = elasticSearchClientManager.getClient();
        SearchRequest searchRequest = new SearchRequest("db_b2b");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(20);
        MatchQueryBuilder queryBuilder = new MatchQueryBuilder("content", "保请车");
        searchSourceBuilder.query(queryBuilder);
        searchRequest.source(searchSourceBuilder);
        searchRequest.types("tms_workbench");
        SearchResponse searchResponse = client.search(searchRequest);
        //GetRequest request = new GetRequest("logstash-2017.12.06");
        //GetResponse response = client.get(request);
        SearchHit[] hits = searchResponse.getHits().getHits();
        List<String> resultList = new ArrayList<>();
        for (SearchHit entity : hits){
            resultList.add(entity.getSourceAsString());
        }
        return resultList;
    }

    @RequestMapping("/queryList.json")
    @ResponseBody
    public BizResult<PageResult<TmsWorkbenchVO>> queryList(){
        QueryPageForm form = new QueryPageForm();
        form.setPageNo(1);
        form.setPageSize(20);
        form.setIndexName("db_b2b");
        form.setDocType("tms_workbench");
        form.setTagType(2);
        return elasticSearchAO.queryList(form);
    }
}
