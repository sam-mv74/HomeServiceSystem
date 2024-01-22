package com.maktab.final_project.service.impl;


import com.maktab.final_project.base.service.impl.BaseServiceImpl;
import com.maktab.final_project.model.Service;
import com.maktab.final_project.repository.ServiceRepository;
import com.maktab.final_project.service.ServiceService;

public class ServiceServiceImpl extends BaseServiceImpl<Service, Long, ServiceRepository> implements ServiceService {

    public ServiceServiceImpl(ServiceRepository repository) {
        super(repository);
    }

    @Override
    public Service findByTitle(String serviceTitle) {
            return repository.findByTitle(serviceTitle);
    }
}
