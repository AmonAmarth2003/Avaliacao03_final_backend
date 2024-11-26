package com.example.avaliacao03_final.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="doctor")
public class DoctorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String specialization;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private PersonModel personModel;

    public DoctorModel(){}
    public DoctorModel(String specialization, PersonModel personModel){
        this.specialization = specialization;
        this.personModel = personModel;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public UUID getId() {
        return id;
    }

    public PersonModel getPersonModel() {
        return personModel;
    }
}