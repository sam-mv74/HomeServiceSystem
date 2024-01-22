package com.maktab.final_project.base.repository;

import com.maktab.final_project.base.model.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> {
    void saveOrUpdate(E e);
    void delete(E e);
    E findById(ID id);

    List<E> findAll();

    boolean existById(ID id);

    EntityManager getEntityManager();

    void beginTransaction();

    void commitTransaction();

    void rollBack();
}
