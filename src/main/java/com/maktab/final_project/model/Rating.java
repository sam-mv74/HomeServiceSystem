package com.maktab.final_project.model;


import com.maktab.final_project.base.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating extends BaseEntity<Long> {
    private String comment;
    private Integer score;

    @OneToOne(cascade = CascadeType.ALL)
    private Offer offer;

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + getId() +
                ", comment='" + comment + '\'' +
                ", score=" + score +
                '}';
    }
}
