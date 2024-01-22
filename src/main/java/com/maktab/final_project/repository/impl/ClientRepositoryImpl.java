package com.maktab.final_project.repository.impl;

import com.maktab.final_project.model.Client;
import com.maktab.final_project.repository.ClientRepository;

import javax.persistence.EntityManager;

public class ClientRepositoryImpl extends UserRepositoryImpl<Client> implements ClientRepository {
    public ClientRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Client> getEntityClass() {
        return Client.class;
    }
}
