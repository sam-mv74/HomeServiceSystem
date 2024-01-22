package com.maktab.final_project.repository.impl;

import com.maktab.final_project.base.repository.impl.BaseRepositoryImpl;
import com.maktab.final_project.model.Offer;
import com.maktab.final_project.repository.OfferRepository;

import javax.persistence.EntityManager;

public class OfferRepositoryImpl extends BaseRepositoryImpl<Offer, Long> implements OfferRepository {
    public OfferRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Offer> getEntityClass() {
        return Offer.class;
    }
}
