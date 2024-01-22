package com.maktab.final_project.repository;


import com.maktab.final_project.model.Technician;
import com.maktab.final_project.model.enumeration.TechnicianStatus;

import java.util.List;

public interface TechnicianRepository extends UserRepository<Technician> {
    List<Technician> findByStatus(TechnicianStatus technicianStatus);
}
