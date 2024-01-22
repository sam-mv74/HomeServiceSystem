package com.maktab.final_project.service;


import com.maktab.final_project.dto.ClientRegistrationDTO;
import com.maktab.final_project.model.Client;
import com.maktab.final_project.model.Order;
import com.maktab.final_project.model.Service;
import com.maktab.final_project.model.SubService;

import java.util.List;

public interface ClientService extends UserService<Client> {
    void registerClient(ClientRegistrationDTO clientRegistrationDTO);

    void addOrder(Order order);

    List<Service> showServices();

    List<SubService> showSubServices(Long ServiceId);
}
