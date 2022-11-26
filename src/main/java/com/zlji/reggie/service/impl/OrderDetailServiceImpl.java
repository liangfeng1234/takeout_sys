package com.zlji.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlji.reggie.entity.OrderDetail;
import com.zlji.reggie.mapper.OrderDetailMapper;
import com.zlji.reggie.service.OrderDetailService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
