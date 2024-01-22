package com.maktab.final_project.validation;


import com.maktab.final_project.dto.ClientRegistrationDTO;
import com.maktab.final_project.exception.InvalidRegistrationDetailsException;
import com.maktab.final_project.model.Client;
import com.maktab.final_project.util.ApplicationContext;

import java.util.List;

public class ClientRegistrationDetailsValidation extends GlobalValidation {

    public static Boolean validateAllClientDetails(ClientRegistrationDTO clientRegistrationDTO) {

        String results = stringValidation(clientRegistrationDTO.getFirstname()) + " " +
                stringValidation(clientRegistrationDTO.getLastname()) + " " +
                emailValidation(clientRegistrationDTO.getEmail()) + " " +
                passwordValidation(clientRegistrationDTO.getPassword());
        if (!results.isBlank())
            throw new InvalidRegistrationDetailsException(results);
        return true;
    }
    public static String emailValidation(String input) {
        String result = "";
        if (!input.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            result = "Invalid Email Format";
        } else {
            List<Client> users = ApplicationContext.getClientService().findAll();
            boolean existEmail = users.stream()
                    .anyMatch(user -> user.getEmail() != null && user.getEmail().equals(input));
            if(existEmail)
                result = "Client With This Email Already Exists";
        }
        return result;
    }

}
