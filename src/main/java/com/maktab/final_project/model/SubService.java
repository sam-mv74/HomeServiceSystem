package com.maktab.final_project.model;


import com.maktab.final_project.base.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SubService extends BaseEntity<Long> {
    private String title;
    private Double basePrice;
    private String description;
    @ManyToMany(mappedBy = "selectedSubServiceList")
    private List<Technician> selectedTechnicianList;
    @ManyToMany(mappedBy = "approvedSubServiceList")
    private List<Technician> approvedTechnicianList;
    @OneToMany(mappedBy = "subService")
    private List<Order> orderList;
    @ManyToOne(cascade = CascadeType.ALL)
    private Service service;

    public SubService(String title, Double basePrice, String description, Service service) {
        this.title = title;
        this.basePrice = basePrice;
        this.description = description;
        this.service = service;
        orderList = new ArrayList<>();
        selectedTechnicianList = new ArrayList<>();
    }
    public void addTechnician(Technician technician){
        approvedTechnicianList.add(technician);
        technician.getApprovedSubServiceList().add(this);
    }
    public void removeTechnician(Technician technician){
        approvedTechnicianList.remove(technician);
        technician.getApprovedSubServiceList().remove(this);
    }

    @Override
    public String toString() {
        return "SubService{" +
                "id=" + getId() +
                ", subServiceName='" + title + '\'' +
                ", basePrice=" + basePrice +
                ", description='" + description + '\'' +
                ", service=" + service +
                '}';
    }
}
