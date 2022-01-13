package io.github.rothschil.domain.web;

import io.github.rothschil.base.response.enums.Status;
import io.github.rothschil.common.exception.DrunkardException;
import io.github.rothschil.domain.entity.Order;
import io.github.rothschil.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 通用请求处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/tidb")
public class ShardingController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/addOrder")
    @ResponseBody
    public int addOrder(@Valid Order order, @NotNull BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new DrunkardException(Status.PARAMS_IS_INVALID);
        }
        int i = orderService.insertOrder(order);
        if (i != 0) {
            throw new DrunkardException(Status.FAILURE);
        }
        return i;
    }

    @GetMapping(path = "/getOrder")
    @ResponseBody
    public List<Order> getOrder(@NotNull @RequestBody List<Integer> orderIds) {
        if (orderIds.isEmpty()) {
            throw new DrunkardException(Status.PARAMS_NOT_COMPLETE);
        }
        List<Order> orderList = orderService.getOrderByIds(orderIds);
        if (orderList.isEmpty()) {
            throw new DrunkardException(Status.TARGET_IS_EMPTY);
        }
        return orderList;
    }

}

