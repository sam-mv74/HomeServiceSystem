package com.maktab.final_project.model;


import com.maktab.final_project.base.model.BaseEntity;
import com.maktab.final_project.model.enumeration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_table")
public class Order extends BaseEntity<Long> {
    private Double suggestedPrice;
    private String description;
    private LocalDateTime doingDate;
    private String address;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "order")
    private List<Offer> offerList;
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    private SubService subService;

    public Order(Double orderPrice, String description, LocalDateTime doingDate, String address,SubService subService) {
        this.suggestedPrice = orderPrice;
        this.description = description;
        this.doingDate = doingDate;
        this.address = address;
        this.subService = subService;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", orderPrice=" + suggestedPrice +
                ", orderDescription='" + description + '\'' +
                ", workTime=" + doingDate +
                ", orderAddress='" + address + '\'' +
                ", orderStatus=" + orderStatus +
                ", client=" + client +
                ", subService=" + subService +
                '}';
    }
}
