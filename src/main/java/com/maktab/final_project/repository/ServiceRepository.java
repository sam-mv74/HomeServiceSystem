package com.maktab.final_project.repository;


import com.maktab.final_project.base.repository.BaseRepository;
import com.maktab.final_project.model.Service;

public interface ServiceRepository extends BaseRepository<Service, Long> {
    Service findByTitle(String title);
}
