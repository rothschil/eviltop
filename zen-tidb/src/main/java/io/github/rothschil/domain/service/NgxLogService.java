package io.github.rothschil.domain.service;


import io.github.rothschil.base.persistence.mybatis.service.BaseService;
import io.github.rothschil.domain.entity.NgxLog;
import io.github.rothschil.domain.mapper.NgxLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 * @author WCNGS@QQ.COM
 * @date 2020/9/9 16:11
 * @since 1.0.0
 */
@Slf4j
@Service(value = "ngxLogService")
@Transactional(rollbackFor = Exception.class)
public class NgxLogService extends BaseService<NgxLogMapper,NgxLog, Long> {


    public void insertBatchByOn(List<NgxLog> locations){
//        //2.获取事务定义
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        //3.设置事务隔离级别，开启新事务
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
//        //4.获得事务状态，相当于开启事物
//        TransactionStatus transactionStatus = transactionManager.getTransaction(def);
        long startTime = System.currentTimeMillis();
//        try {
//            baseMpper.insertBatchByOn(locations);
//            transactionManager.commit(transactionStatus);
//        } catch (TransactionException e) {
//            e.printStackTrace();
//        }
        long endTime = System.currentTimeMillis();

        baseMpper.insertBatchByOn(locations);
        log.warn(" 耗时 {} ms",(endTime - startTime));
    }

    public SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public DataSourceTransactionManager transactionManager;

    @Autowired
    public void setTransactionManager(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
