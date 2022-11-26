package com.zlji.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlji.reggie.entity.Orders;
import org.springframework.core.annotation.Order;

public interface OrderService extends IService<Orders> {
    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);
}
