package com.maktab.final_project.repository.impl;

import com.maktab.final_project.base.repository.impl.BaseRepositoryImpl;
import com.maktab.final_project.exception.EntityNotFoundException;
import com.maktab.final_project.model.SubService;
import com.maktab.final_project.repository.SubServiceRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<SubService, Long> implements SubServiceRepository {
    public SubServiceRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<SubService> getEntityClass() {
        return SubService.class;
    }

    @Override
    public SubService findByTitle(String title) {
        try {
            TypedQuery<SubService> query = entityManager.createQuery(
                    "SELECT s FROM SubService s WHERE s.title = :name", getEntityClass());
            query.setParameter("name", title);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new EntityNotFoundException("SubService Not Found With This Title", e);
        }
    }
}
