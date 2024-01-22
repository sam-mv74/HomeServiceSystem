package com.maktab.final_project.service.impl;

import com.maktab.final_project.base.service.impl.BaseServiceImpl;
import com.maktab.final_project.model.Rating;
import com.maktab.final_project.repository.RatingRepository;
import com.maktab.final_project.service.RatingService;

public class RatingServiceImpl extends BaseServiceImpl<Rating, Long, RatingRepository> implements RatingService {
    public RatingServiceImpl(RatingRepository repository) {
        super(repository);
    }
}
