package io.github.rothschil.domain.mapper;


import io.github.rothschil.base.persistence.mybatis.mapper.BaseMapper;
import io.github.rothschil.domain.entity.Order;

import java.util.List;

/**
 * @author WCNGS@QQ.COM
 * @date 2020/9/9 15:12
 * @since 1.0.0
 */
public interface OrderMapper extends BaseMapper<Order, Integer> {

    int insertOrder(Order order);

    List<Order> findOrderByIds(List<Integer> orderIds);

}