package io.github.rothschil.domain.service;


import io.github.rothschil.base.persistence.mybatis.service.BaseService;
import io.github.rothschil.domain.entity.NgxLog;
import io.github.rothschil.domain.mapper.NgxLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author WCNGS@QQ.COM
 * @date 2020/9/9 16:11
 * @since 1.0.0
 */
@Slf4j
@Service(value = "ngxLogService")
@Transactional(readOnly = true)
public class NgxLogService extends BaseService<NgxLogMapper,NgxLog, Long> {


    @Transactional(rollbackFor = Exception.class)
    public void insertBatchByOn(List<NgxLog> locations){
        SqlSession sqlSession =sqlSessionFactory.openSession();
        long startTime = System.currentTimeMillis();
        baseMpper.insertBatchByOn(locations);
        sqlSession.commit();
        long endTime = System.currentTimeMillis();
        log.warn(" 耗时 {} ms",(endTime - startTime));
    }

    public SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
