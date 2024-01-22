package com.maktab.final_project.service;


import com.maktab.final_project.dto.TechnicianRegistrationDTO;
import com.maktab.final_project.model.Technician;
import com.maktab.final_project.model.enumeration.TechnicianStatus;

import java.util.List;

public interface TechnicianService extends UserService<Technician> {
    void registerTechnician(TechnicianRegistrationDTO technicianRegistrationDTO);

    List<Technician> findByStatus(TechnicianStatus status);
    void downloadImage(Long id);
}
