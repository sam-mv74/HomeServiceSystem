package com.maktab.final_project.service.impl;

import com.maktab.final_project.base.service.impl.BaseServiceImpl;
import com.maktab.final_project.model.SubService;
import com.maktab.final_project.repository.SubServiceRepository;
import com.maktab.final_project.service.SubServiceService;

public class SubServiceServiceImpl extends BaseServiceImpl<SubService, Long, SubServiceRepository> implements SubServiceService {

    public SubServiceServiceImpl(SubServiceRepository repository) {
        super(repository);
    }
    @Override
    public SubService findByTitle(String name) {
        return repository.findByTitle(name);
    }
}
