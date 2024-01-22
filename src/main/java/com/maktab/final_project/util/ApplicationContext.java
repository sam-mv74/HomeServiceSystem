package com.maktab.final_project.util;


import com.maktab.final_project.repository.*;
import com.maktab.final_project.repository.impl.*;
import com.maktab.final_project.service.*;
import com.maktab.final_project.service.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationContext {

    private static final EntityManager entityManager =
            Persistence.createEntityManagerFactory(
                    "default"
            ).createEntityManager();

    private static AdminRepository adminRepository;
    private static ClientRepository clientRepository;
    private static OfferRepository offerRepository;
    private static OrderRepository orderRepository;
    private static RatingRepository ratingRepository;
    private static ServiceRepository serviceRepository;
    private static SubServiceRepository subServiceRepository;
    private static TechnicianRepository technicianRepository;
    //
    private static AdminService adminService;
    private static ClientService clientService;
    private static OfferService offerService;
    private static OrderService orderService;
    private static RatingService ratingService;
    private static ServiceService serviceService;
    private static SubServiceService subServiceService;
    private static TechnicianService technicianService;

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static ClientRepository getClientRepository() {
        if (clientRepository == null) {
            clientRepository = new ClientRepositoryImpl(entityManager);
        }
        return clientRepository;
    }

    public static OfferRepository getOfferRepository() {
        if (offerRepository == null) {
            offerRepository = new OfferRepositoryImpl(entityManager);
        }
        return offerRepository;
    }

    public static AdminRepository getAdminRepository() {
        if (adminRepository == null) {
            adminRepository = new AdminRepositoryImpl(entityManager);
        }
        return adminRepository;
    }

    public static OrderRepository getOrderRepository() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl(entityManager);
        }
        return orderRepository;
    }

    public static RatingRepository getRatingRepository() {
        if (ratingRepository == null) {
            ratingRepository = new RatingRepositoryImpl(entityManager);
        }
        return ratingRepository;
    }

    public static ServiceRepository getServiceRepository() {
        if (serviceRepository == null) {
            serviceRepository = new ServiceRepositoryImpl(entityManager);
        }
        return serviceRepository;
    }

    public static SubServiceRepository getSubServiceRepository() {
        if (subServiceRepository == null) {
            subServiceRepository = new SubServiceRepositoryImpl(entityManager);
        }
        return subServiceRepository;
    }

    public static TechnicianRepository getTechnicianRepository() {
        if (technicianRepository == null) {
            technicianRepository = new TechnicianRepositoryImpl(entityManager);
        }
        return technicianRepository;
    }

    public static ClientService getClientService() {
        if (clientService == null) {
            clientService = new ClientServiceImpl(
                    getClientRepository()
            );
        }
        return clientService;
    }

    public static OfferService getOfferService() {
        if (offerService == null) {
            offerService = new OfferServiceImpl(
                    getOfferRepository()
            );
        }
        return offerService;
    }


    public static RatingService getRatingService() {
        if (ratingService == null) {
            ratingService = new RatingServiceImpl(
                    getRatingRepository()
            );
        }
        return ratingService;
    }

    public static ServiceService getServiceService() {
        if (serviceService == null) {
            serviceService = new ServiceServiceImpl(
                    getServiceRepository()
            );
        }
        return serviceService;
    }


    public static SubServiceService getSubServiceService() {
        if (subServiceService == null) {
            subServiceService = new SubServiceServiceImpl(
                    getSubServiceRepository()
            );
        }
        return subServiceService;
    }

    public static TechnicianService getTechnicianService() {
        if (technicianService == null) {
            technicianService = new TechnicianServiceImpl(
                    getTechnicianRepository()
            );
        }
        return technicianService;
    }

    public static AdminService getAdminService() {
        if (adminService == null) {
            adminService = new AdminServiceImpl(
                    getAdminRepository()
            );
        }
        return adminService;
    }

    public static OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl(
                    getOrderRepository()
            );
        }
        return orderService;
    }
}
