package com.maktab.final_project.service.impl;


import com.maktab.final_project.base.service.impl.BaseServiceImpl;
import com.maktab.final_project.model.Order;
import com.maktab.final_project.repository.OrderRepository;
import com.maktab.final_project.service.OrderService;

public class OrderServiceImpl extends BaseServiceImpl<Order, Long, OrderRepository> implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
