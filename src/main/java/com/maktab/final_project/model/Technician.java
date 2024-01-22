package com.maktab.final_project.model;

import com.maktab.final_project.model.enumeration.TechnicianStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Technician extends User {
    @Enumerated(EnumType.STRING)
    private TechnicianStatus technicianStatus;
    private byte[] personalPhoto;
    private Double credit;
    private Integer score;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<SubService> approvedSubServiceList;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<SubService> selectedSubServiceList;
    @OneToMany(mappedBy = "technician")
    private List<Offer> offerList;

    public Technician() {
        super();
        technicianStatus = TechnicianStatus.NEW;
        approvedSubServiceList = new ArrayList<>();
        offerList = new ArrayList<>();
        credit = 0.0;
        score = 0;
    }

    public Technician(String firstName, String lastName, String userName, String password, String email, byte[] personalPhoto, List<SubService> selectedSubServiceList) {
        super(firstName, lastName, userName, password, email);
        this.personalPhoto = personalPhoto;
        this.selectedSubServiceList = selectedSubServiceList;
        technicianStatus = TechnicianStatus.NEW;
        approvedSubServiceList = new ArrayList<>();
        offerList = new ArrayList<>();
        credit = 0.0;
        score = 0;
    }

    @Override
    public String toString() {
        return "Technician{" +
                "id=" + getId() +
                ", technicianStatus=" + technicianStatus +
                ", credit=" + credit +
                ", signUpDate=" + getRegistrationDate() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", userName='" + getUserName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
