package com.maktab.final_project.repository;

import com.maktab.final_project.base.repository.BaseRepository;
import com.maktab.final_project.model.SubService;

public interface SubServiceRepository extends BaseRepository<SubService, Long> {
    SubService findByTitle(String title);
}
