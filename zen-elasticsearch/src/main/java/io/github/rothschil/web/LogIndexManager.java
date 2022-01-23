package io.github.rothschil.web;

import io.github.rothschil.base.elastic.service.ElasticIndexManger;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author <a href="https://github.com/rothschil">Sam</a>
 * @date 2021/12/27 - 15:39
 * @since 1.0.0
 */
@Component
public class LogIndexManager{

    private ElasticIndexManger elasticIndexManger;

    @Autowired
    public void setElasticIndexManger(ElasticIndexManger elasticIndexManger) {
        this.elasticIndexManger = elasticIndexManger;
    }

    public List<AccLog> query(){
        QueryBuilder queryBuilder = new TermQueryBuilder("sysCode","crm");
        SearchSourceBuilder sb = new SearchSourceBuilder();
        sb.query(queryBuilder);
        return elasticIndexManger.search("hnqymh_hpg*",sb,AccLog.class);
    }
}
