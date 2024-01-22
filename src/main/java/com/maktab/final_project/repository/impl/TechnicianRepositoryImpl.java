package com.maktab.final_project.repository.impl;

import com.maktab.final_project.exception.EntityNotFoundException;
import com.maktab.final_project.model.Technician;
import com.maktab.final_project.model.enumeration.TechnicianStatus;
import com.maktab.final_project.repository.TechnicianRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TechnicianRepositoryImpl extends UserRepositoryImpl<Technician> implements TechnicianRepository {
    public TechnicianRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Technician> getEntityClass() {
        return Technician.class;
    }

    @Override
    public List<Technician> findByStatus(TechnicianStatus technicianStatus) {
        try {
            String jpql = "from Technician t where t.technicianStatus = :technicianStatus";
            TypedQuery<Technician> query = entityManager.createQuery(jpql, Technician.class);
            query.setParameter("technicianStatus", technicianStatus);
            return query.getResultList();
        } catch (Exception e) {
            throw new EntityNotFoundException("Error While Retrieving Technicians", e);
        }
    }
}
