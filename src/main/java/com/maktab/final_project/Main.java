package com.maktab.final_project;


public class Main {
    public static void main(String[] args) {

//        //technician jobs
//
//        //--------technician registration
//        //show all services for technician to choose
//        List<Service> services = ApplicationContext.getServiceService().findAll();
//        System.out.println(services);
//        //show all sub services for selected service
//        Service service = ApplicationContext.getServiceService().findById(666L);
//        List<SubService> subServices = service.getSubServiceList();
//        System.out.println(subServices);
//        List<SubService> chosenSubServices = new ArrayList<>();
//        chosenSubServices.add(subServices.get(0));
////        chosenSubServices.add(subServices.get(2));
////        //register technician
//        TechnicianRegistrationDTO technicianRegistrationDTO = new TechnicianRegistrationDTO("sherlock", "holmes", "sherlock", "sherlock1234", "sherlock@gmail.com", "F:\\Maktab\\FinalProject\\sherlockImage.jpg", chosenSubServices);
//        ApplicationContext.getTechnicianService().registerTechnician(technicianRegistrationDTO);

//        //--------downloadImage
//        ApplicationContext.getTechnicianService().downloadImage(670L);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        //admin jobs
//
//        //--------register new service and sub service
//        ApplicationContext.getAdminService().addService("Repairment");
//        ApplicationContext.getAdminService().addSubService("Painting", 1000.0, "House Repairment", "Repairment");
//
        //show new technicians
//        List<Technician> technicians = ApplicationContext.getAdminService().showNewTechnicians();
//        System.out.println(technicians);
//
//        //--------approve technician
//        ApplicationContext.getAdminService().approveTechnician(670L);
//
        //--------add technician to sub service
        //show technicians selected sub services
//        List<SubService>subServices= ApplicationContext.getAdminService().showTechniciansSelectedSubServices(1L);
//        System.out.println(subServices);
//
//        ApplicationContext.getAdminService().addTechnicianToSubServices(1L, 2L);
//
//        //--------remove technician from sub service
//        ApplicationContext.getAdminService().removeTechnicianFromSubServices(1L, "Painting");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //client jobs

//        //--------client registration
//        ClientRegistrationDTO clientRegistrationDTO = new ClientRegistrationDTO("sara", "ahmadi", "sara", "1234", "sara@gmail.com");
//        ApplicationContext.getClientService().registerClient(clientRegistrationDTO);

        //--------change password
//        ApplicationContext.getClientService().changePassword("sara", "new", "new2");
//
        //--------register order
        //show services to client
//        List<Service> serviceList = ApplicationContext.getClientService().showServices();
//        System.out.println(serviceList);
//        //show sub services to client
//        List<SubService> subServiceList = ApplicationContext.getClientService().showSubServices(666L);
//        System.out.println(subServiceList);
//        //register order
//        Client currentClient = ApplicationContext.getClientService().findById(665L);
//        SecurityContext.fillUserContext(currentClient);
//        ApplicationContext.getClientService().addOrder(
//                new Order(1500.0, "painting my room's wall",
//                        LocalDateTime.of(2024, 4, 14, 10, 0, 0),
//                        "tehran-narmak", ApplicationContext.getSubServiceService().findByTitle("Painting")));

    }
}