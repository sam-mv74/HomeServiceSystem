package com.maktab.final_project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
@Getter
@Setter
@Entity
public class Client extends User{
    private Double credit;

    @OneToMany(mappedBy = "client")
    private List<Order> orderList;
    public Client() {
        super();
        credit= 0.0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + getId() +
                ", credit=" + credit +
                ", signUpDate=" + getRegistrationDate() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", userName='" + getUserName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }

    public Client(String firstName, String lastName, String userName, String password, String email) {
        super(firstName, lastName, userName, password, email);
        credit= 0.0;
    }
}
