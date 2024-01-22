package com.maktab.final_project.model;

import com.maktab.final_project.base.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Service extends BaseEntity<Long> {

    private String title;
    @OneToMany(mappedBy = "service")
    private List<SubService> subServiceList;

    public Service(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + getId() +
                ", serviceName='" + title + '\'' +
                '}';
    }
}
