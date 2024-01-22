package com.maktab.final_project.model;


import com.maktab.final_project.base.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offer extends BaseEntity<Long> {
    private LocalDateTime registerDate;
    private LocalDateTime suggestedStartDate;
    private Double suggestedPrice;
    private Integer durationHours;
    @ManyToOne(cascade = CascadeType.ALL)
    private Technician technician;
    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;


    @Override
    public String toString() {
        return "Offer{" +
                "id=" + getId() +
                ", timeOfferُSent=" + registerDate +
                ", timeForStartWorking=" + suggestedStartDate +
                ", suggestionPrice=" + suggestedPrice +
                ", WorkDuration='" + durationHours + '\'' +
                ", technician=" + technician +
                ", order=" + order +
                ", workDuration='" + getDurationHours() + '\'' +
                '}';
    }
}
