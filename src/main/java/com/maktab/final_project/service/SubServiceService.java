package com.maktab.final_project.service;


import com.maktab.final_project.base.service.BaseService;
import com.maktab.final_project.model.SubService;

public interface SubServiceService extends BaseService<SubService, Long> {
    SubService findByTitle(String name);
}
