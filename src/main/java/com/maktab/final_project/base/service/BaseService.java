package com.maktab.final_project.base.service;


import com.maktab.final_project.base.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {
    void saveOrUpdate(E e);
    void delete(E e);

    E findById(ID id);

    List<E> findAll();

    boolean existById(ID id);

}