package com.maktab.final_project.repository.impl;

import com.maktab.final_project.base.repository.impl.BaseRepositoryImpl;
import com.maktab.final_project.exception.EntityNotFoundException;
import com.maktab.final_project.model.Service;
import com.maktab.final_project.repository.ServiceRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class ServiceRepositoryImpl extends BaseRepositoryImpl<Service, Long> implements ServiceRepository {
    public ServiceRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Service> getEntityClass() {
        return Service.class;
    }
    @Override
    public Service findByTitle(String title) {
        try {
            TypedQuery<Service> query = entityManager.createQuery(
                    "SELECT s FROM Service s WHERE s.title = :title", getEntityClass());
            query.setParameter("title", title);
            return query.getSingleResult();
        }catch (Exception e){
            throw new EntityNotFoundException("Service Not Found With This Title",e);
        }
    }
}
