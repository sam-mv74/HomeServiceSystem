package com.maktab.final_project.service.impl;

import com.maktab.final_project.base.service.impl.BaseServiceImpl;
import com.maktab.final_project.model.Offer;
import com.maktab.final_project.repository.OfferRepository;
import com.maktab.final_project.service.OfferService;

public class OfferServiceImpl extends BaseServiceImpl<Offer, Long, OfferRepository> implements OfferService {

    public OfferServiceImpl(OfferRepository repository) {
        super(repository);
    }
}
