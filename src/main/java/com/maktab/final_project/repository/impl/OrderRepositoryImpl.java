package com.maktab.final_project.repository.impl;

import com.maktab.final_project.base.repository.impl.BaseRepositoryImpl;
import com.maktab.final_project.model.Order;
import com.maktab.final_project.repository.OrderRepository;

import javax.persistence.EntityManager;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order, Long> implements OrderRepository {
    public OrderRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }
}
