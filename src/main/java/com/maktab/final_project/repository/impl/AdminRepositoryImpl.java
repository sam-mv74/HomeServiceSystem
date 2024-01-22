package com.maktab.final_project.repository.impl;

import com.maktab.final_project.model.Admin;
import com.maktab.final_project.repository.AdminRepository;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends UserRepositoryImpl<Admin> implements AdminRepository {
    public AdminRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
