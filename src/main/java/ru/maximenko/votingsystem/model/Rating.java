package ru.maximenko.votingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "rating", uniqueConstraints = @UniqueConstraint(columnNames = {"id_user", "assessment", "date_create"},
        name = "rating_unique_users_assessment_on_date_idx"))
public class Rating extends AbstractBaseEntity {

    @Column(name = "id_restaurant", nullable = false)
    @NotNull
    private int idRestaurant;

    @Column(name = "assessment", nullable = false)
    @NotNull
    private Integer assessment;

    @Column(name = "date_create", nullable = false)
    @NotNull
    private LocalDate dateCreate;

    public Rating() {}

    public Integer getAssessment() {
        return assessment;
    }

    public void setAssessment(Integer assessment) {
        this.assessment = assessment;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }
}
