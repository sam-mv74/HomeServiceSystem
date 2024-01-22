package com.maktab.final_project.dto;

import com.maktab.final_project.model.SubService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class TechnicianRegistrationDTO extends ClientRegistrationDTO {
    List<SubService>subServices;
    String photoFilePath;

    String photoFileName;

    public TechnicianRegistrationDTO(String firstname, String lastname, String username, String password, String email, String photoFilePath, List<SubService> subServices) {
        super(firstname, lastname, username, password, email);
        this.photoFilePath = photoFilePath;
        this.subServices = subServices;
    }
}
