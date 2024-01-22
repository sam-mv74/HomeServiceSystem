package com.maktab.final_project.base.service.impl;

import com.maktab.final_project.base.model.BaseEntity;
import com.maktab.final_project.base.repository.BaseRepository;
import com.maktab.final_project.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public  class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final R repository;
    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void saveOrUpdate(E e) {

        repository.saveOrUpdate(e);
    }
    @Override
    public void delete(E e) {
        repository.delete(e);
    }
    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }
    @Override
    public List<E> findAll() {
        return repository.findAll();
    }
    @Override
    public boolean existById(ID id) {
        return repository.existById(id);
    }

}

