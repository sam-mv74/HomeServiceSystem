package com.maktab.final_project.service;


import com.maktab.final_project.model.Admin;
import com.maktab.final_project.model.Service;
import com.maktab.final_project.model.SubService;
import com.maktab.final_project.model.Technician;

import java.util.List;

public interface AdminService extends UserService<Admin> {

    void addService(String serviceTitle);

    void addSubService(String subServiceTitle, Double subServiceBasePrice, String subServiceDescription, String serviceTitle);

    List<Service> showSubServiceList();

    List<Technician> showNewTechnicians();

    void approveTechnician(Long technicianId);

    void addTechnicianToSubServices(Long technicianId, Long subServiceId);

    void removeTechnicianFromSubServices(Long technicianId, Long subServiceId);

    void updateSubServiceBasePrice(Long subServiceId, Double newPrice);

    void updateSubServiceDescription(Long subServiceId, String newDescription);

    List<SubService> showTechniciansSelectedSubServices(long technicianId);
}
