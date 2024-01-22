package com.maktab.final_project.service;


import com.maktab.final_project.base.service.BaseService;
import com.maktab.final_project.model.Service;

public interface ServiceService extends BaseService<Service, Long> {
    Service findByTitle(String serviceTitle);
}
