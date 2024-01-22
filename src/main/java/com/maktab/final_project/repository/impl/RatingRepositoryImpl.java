package com.maktab.final_project.repository.impl;


import com.maktab.final_project.base.repository.impl.BaseRepositoryImpl;
import com.maktab.final_project.model.Rating;
import com.maktab.final_project.repository.RatingRepository;

import javax.persistence.EntityManager;

public class RatingRepositoryImpl extends BaseRepositoryImpl<Rating, Long> implements RatingRepository {
    public RatingRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Rating> getEntityClass() {
        return Rating.class;
    }
}
