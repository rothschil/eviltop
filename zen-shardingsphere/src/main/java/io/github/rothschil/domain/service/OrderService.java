package io.github.rothschil.domain.service;


import io.github.rothschil.base.persistence.mybatis.service.BaseService;
import io.github.rothschil.domain.entity.Order;
import io.github.rothschil.domain.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WCNGS@QQ.COM
 * @date 2020/9/9 16:11
 * @since 1.0.0
 */
@Slf4j
@Service(value = "orderService")
public class OrderService extends BaseService<OrderMapper, Order, Integer> {

    public int insertOrder(Order order) {
        return baseMpper.insertOrder(order);
    }

    public List<Order> getOrderByIds(List<Integer> orderIds) {
        return baseMpper.findOrderByIds(orderIds);
    }

}
