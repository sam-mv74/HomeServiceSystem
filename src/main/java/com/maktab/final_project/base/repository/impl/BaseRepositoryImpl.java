package com.maktab.final_project.base.repository.impl;


import com.maktab.final_project.base.model.BaseEntity;
import com.maktab.final_project.base.repository.BaseRepository;
import com.maktab.final_project.exception.EntityNotFoundException;
import com.maktab.final_project.exception.EntityOperationException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {

    protected final EntityManager entityManager;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public abstract Class<E> getEntityClass();

    @Override
    public void saveOrUpdate(E entity) {
        try {
            beginTransaction();
            saveWithoutTransaction(entity);
            commitTransaction();
            entityManager.clear();
        } catch (Exception e) {
            rollBack();
            throw new EntityOperationException("Error While Saving Entity",e);
        }
    }

    public void saveWithoutTransaction(E entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
    }

    @Override
    public void delete(E entity) {
        try {
            beginTransaction();
            E en = entityManager.find(getEntityClass(), entity);
            entityManager.remove(en);
            commitTransaction();
        } catch (Exception e) {
            rollBack();
            throw new EntityOperationException("Error While Removing Entity",e);
        }
    }

    @Override
    public E findById(ID id) {
        try {
            return entityManager.find(getEntityClass(), id);
        } catch (Exception e) {
            throw new EntityNotFoundException("Couldn't Find Entity With This Id",e);
        }
    }

    @Override
    public List<E> findAll() {
        try {
            return entityManager.createQuery(
                    "from " + getEntityClass().getSimpleName(), getEntityClass()
            ).getResultList();
        } catch (Exception e) {
            throw new EntityNotFoundException("Error While Finding Entities",e);
        }
    }

    @Override
    public boolean existById(ID id) {
        try {
            TypedQuery<Long> query = entityManager.createQuery(
                    "select count(t) from " + getEntityClass().getSimpleName() + " t where t.id = :id", Long.class
            );
            query.setParameter("id", id);
            return query.getSingleResult() > 0;
        }catch (Exception e){
            throw new EntityNotFoundException("Couldn't Find Entity With This Id",e);
        }

    }

    @Override
    public void beginTransaction() {
        if (!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().commit();
    }

    @Override
    public void rollBack() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
