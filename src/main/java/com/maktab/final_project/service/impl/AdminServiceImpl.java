package com.maktab.final_project.service.impl;


import com.maktab.final_project.exception.*;
import com.maktab.final_project.model.Admin;
import com.maktab.final_project.model.Service;
import com.maktab.final_project.model.SubService;
import com.maktab.final_project.model.Technician;
import com.maktab.final_project.model.enumeration.TechnicianStatus;
import com.maktab.final_project.repository.AdminRepository;
import com.maktab.final_project.service.AdminService;
import com.maktab.final_project.util.ApplicationContext;

import java.util.List;

public class AdminServiceImpl extends UserServiceImpl<Admin, AdminRepository> implements AdminService {
    public AdminServiceImpl(AdminRepository repository) {
        super(repository);

    }

    @Override
    public void addService(String serviceTitle) {
        Service service;
        try {
            service = ApplicationContext.getServiceService().findByTitle(serviceTitle);
        } catch (EntityNotFoundException e) {
            service = null;
        }
        if (service == null) {
            service = new Service(serviceTitle);
            try {
                ApplicationContext.getServiceService().saveOrUpdate(service);
            } catch (EntityOperationException e) {
                throw new ServiceException("Error While adding Service", e);
            }
        }
    }

    @Override
    public void addSubService(String subServiceTitle, Double subServiceBasePrice, String subServiceDescription, String serviceTitle) {
        Service service;
        try {
            service = ApplicationContext.getServiceService().findByTitle(serviceTitle);
        } catch (EntityNotFoundException e) {
            service = null;
        }
        if (service != null) {
            SubService subService;
            try {
                subService = ApplicationContext.getSubServiceService().findByTitle(serviceTitle);
            } catch (EntityNotFoundException e) {
                subService = null;
            }
            if (subService != null)
                throw new ServiceException("This SubService Already Exists");
            SubService newSubService = new SubService(subServiceTitle, subServiceBasePrice, subServiceDescription, service);
            try {
                ApplicationContext.getSubServiceService().saveOrUpdate(newSubService);
            } catch (EntityOperationException e) {
                throw new ServiceException("Error While adding SubService", e);
            }
        } else {
            throw new ServiceException("This Service Doesn't Exist");
        }
    }

    @Override
    public List<Service> showSubServiceList() {
        try {
            return ApplicationContext.getServiceService().findAll();
        } catch (EntityNotFoundException e) {
            throw new ServiceException("Error While Retrieving SubServices Data ", e);
        }
    }

    @Override
    public List<Technician> showNewTechnicians() {
        try {
            return ApplicationContext.getTechnicianService().findByStatus(TechnicianStatus.NEW);
        } catch (EntityNotFoundException e) {
            throw new ServiceException("Error While Showing New Technicians");
        }
    }

    @Override
    public void approveTechnician(Long technicianId) {
        Technician technician;
        try {
            technician = ApplicationContext.getTechnicianService().findById(technicianId);
            technician.setTechnicianStatus(TechnicianStatus.APPROVED);
            ApplicationContext.getTechnicianService().saveOrUpdate(technician);
        } catch (EntityOperationException | EntityNotFoundException e) {
            throw new ServiceException("Error While Approving Technician", e);
        }
    }

    @Override
    public void addTechnicianToSubServices(Long technicianId, Long subServiceId) {
        try {
            Technician technician = ApplicationContext.getTechnicianService().findById(technicianId);
            if (technician != null) {
                if (technician.getTechnicianStatus().equals(TechnicianStatus.APPROVED)) {
                    SubService subService = ApplicationContext.getSubServiceService().findById(subServiceId);
                    if (subService != null) {
                        subService.addTechnician(technician);
                        ApplicationContext.getSubServiceService().saveOrUpdate(subService);
                    }
                } else {
                    throw new ServiceException("Technician Must Be Approved");
                }
            }
        } catch (EntityNotFoundException | EntityOperationException e) {
            throw new ServiceException("Error While Adding Technician To SubService", e);
        }
    }

    @Override
    public void removeTechnicianFromSubServices(Long technicianId, Long subServiceId) {
        try {
            Technician technician = ApplicationContext.getTechnicianService().findById(technicianId);
            if (technician != null) {
                if (technician.getTechnicianStatus().equals(TechnicianStatus.APPROVED)) {
                    SubService subService = ApplicationContext.getSubServiceService().findById(subServiceId);
                    if (subService != null) {
                        subService.removeTechnician(technician);
                        ApplicationContext.getSubServiceService().saveOrUpdate(subService);
                    }
                } else {
                    throw new ServiceException("Technician Must Be Approved");
                }
            }
        } catch (EntityNotFoundException | EntityOperationException e) {
            throw new ServiceException("Error While Removing Technician From SubService", e);
        }
    }

    @Override
    public void updateSubServiceBasePrice(Long subServiceId, Double newPrice) {
        try {
            SubService subService = ApplicationContext.getSubServiceService().findById(subServiceId);
            subService.setBasePrice(newPrice);
            ApplicationContext.getSubServiceService().saveOrUpdate(subService);
        } catch (EntityNotFoundException | EntityOperationException e) {
            throw new ServiceException("Error While Updating SubService Base Price", e);
        }
    }

    @Override
    public void updateSubServiceDescription(Long subServiceId, String newDescription) {
        try {
            SubService subService = ApplicationContext.getSubServiceService().findById(subServiceId);
            subService.setDescription(newDescription);
            ApplicationContext.getSubServiceService().saveOrUpdate(subService);
        } catch (EntityNotFoundException | EntityOperationException e) {
            throw new ServiceException("Error While Updating SubService Description", e);
        }
    }

    @Override
    public List<SubService> showTechniciansSelectedSubServices(long technicianId) {
        try {
            Technician technician = ApplicationContext.getTechnicianService().findById(technicianId);
            return technician.getApprovedSubServiceList();
        } catch (EntityNotFoundException e) {
            throw new ServiceException("Error While Showing Technicians Selected SubServices", e);
        }
    }
}
