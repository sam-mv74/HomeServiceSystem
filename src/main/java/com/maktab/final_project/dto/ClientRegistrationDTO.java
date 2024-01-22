package com.maktab.final_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRegistrationDTO {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
}
