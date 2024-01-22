package com.maktab.final_project.service.impl;


import com.maktab.final_project.dto.ClientRegistrationDTO;
import com.maktab.final_project.exception.EntityNotFoundException;
import com.maktab.final_project.exception.EntityOperationException;
import com.maktab.final_project.exception.InvalidRegistrationDetailsException;
import com.maktab.final_project.exception.ServiceException;
import com.maktab.final_project.model.Client;
import com.maktab.final_project.model.Order;
import com.maktab.final_project.model.Service;
import com.maktab.final_project.model.SubService;
import com.maktab.final_project.model.enumeration.OrderStatus;
import com.maktab.final_project.repository.ClientRepository;
import com.maktab.final_project.service.ClientService;
import com.maktab.final_project.util.ApplicationContext;
import com.maktab.final_project.util.SecurityContext;
import com.maktab.final_project.validation.ClientRegistrationDetailsValidation;

import java.time.LocalDateTime;
import java.util.List;

public class ClientServiceImpl extends UserServiceImpl<Client, ClientRepository> implements ClientService {

    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }

    @Override
    public void registerClient(ClientRegistrationDTO clientRegistrationDTO) {
        try {
            Boolean isValid = ClientRegistrationDetailsValidation.validateAllClientDetails(clientRegistrationDTO);
            if (isValid) {
                Client client = new Client();
                client.setFirstName(clientRegistrationDTO.getFirstname());
                client.setLastName(clientRegistrationDTO.getLastname());
                client.setUserName(clientRegistrationDTO.getUsername());
                client.setPassword(clientRegistrationDTO.getPassword());
                client.setEmail(clientRegistrationDTO.getEmail());
                repository.saveOrUpdate(client);
            }
        } catch (InvalidRegistrationDetailsException e) {
            throw new ServiceException("Error While Registering Client ", e);
        }
    }

    @Override
    public void addOrder(Order order) {
        try {
            if (order.getSuggestedPrice() <= order.getSubService().getBasePrice()) {
                throw new ServiceException("Suggested Price Cant Be Less Than Base Price");
            } else if (order.getDoingDate().isBefore(LocalDateTime.now())) {
                throw new ServiceException("Doing Date Cant Be Before Current Date");
            }
            order.setClient((Client) SecurityContext.getCurrentUser());
            order.setOrderStatus(OrderStatus.WAITE_FOR_OFFER);
            ApplicationContext.getOrderService().saveOrUpdate(order);
        } catch (EntityOperationException e) {
            throw new ServiceException("Error While Adding Order", e);
        }
    }

    @Override
    public List<Service> showServices() {
        try {
            return ApplicationContext.getServiceService().findAll();
        } catch (EntityNotFoundException e) {
            throw new ServiceException("Error While Retrieving Services ", e);
        }
    }

    @Override
    public List<SubService> showSubServices(Long serviceId) {
        try {
            Service service = ApplicationContext.getServiceService().findById(serviceId);
            return service.getSubServiceList();
        } catch (EntityNotFoundException e) {
            throw new ServiceException("Error While Retrieving SubServices ", e);
        }
    }
}
