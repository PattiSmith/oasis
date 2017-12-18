package com.gaohanna.oasis.core.ao.impl;

import com.gaohanna.oasis.common.entity.BizResult;
import com.gaohanna.oasis.common.entity.PageResult;
import com.gaohanna.oasis.common.form.QueryPageForm;
import com.gaohanna.oasis.common.vo.TmsWorkbenchVO;
import com.gaohanna.oasis.core.ao.IElasticSearchAO;
import com.gaohanna.oasis.core.manager.ElasticSearchClientManager;
import com.google.gson.Gson;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * something
 *
 * @author keben
 * @date 2017/12/15
 */
@Component
public class ElasticSearchAOImpl implements IElasticSearchAO {
    @Autowired
    private ElasticSearchClientManager elasticSearchClientManager;

    @Override
    public BizResult<PageResult<TmsWorkbenchVO>> queryList(QueryPageForm form) {
        PageResult<TmsWorkbenchVO> pageResult = new PageResult<TmsWorkbenchVO>(form.getPageNo(), form.getPageSize(), 0);
        RestHighLevelClient client = elasticSearchClientManager.getClient();
        SearchRequest searchRequest = new SearchRequest(form.getIndexName());
        searchRequest.types(form.getDocType());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from((form.getPageNo() - 1) * form.getPageSize());
        searchSourceBuilder.size(form.getPageSize());
        MatchQueryBuilder queryBuilder = new MatchQueryBuilder("tag_type", form.getTagType());
        //queryBuilder.fuzziness(Fuzziness.AUTO);
        QueryBuilder filter = QueryBuilders.termQuery("status", "1");
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.postFilter(filter);
        searchRequest.source(searchSourceBuilder);
        try {
            SearchResponse searchResponse = client.search(searchRequest);
            SearchHits searchHits = searchResponse.getHits();
            SearchHit[] hits = searchHits.getHits();
            List<TmsWorkbenchVO> resultList = new ArrayList<>();
            for (SearchHit entity : hits){
                TmsWorkbenchVO vo = new Gson().fromJson(entity.getSourceAsString(), TmsWorkbenchVO.class);
                resultList.add(vo);
            }
            pageResult.setTotalCount((int)searchHits.getTotalHits());
            pageResult.setResult(resultList);
            return BizResult.create(pageResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BizResult.create(pageResult);
    }
}
