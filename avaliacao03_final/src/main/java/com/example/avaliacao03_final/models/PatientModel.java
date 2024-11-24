package com.example.avaliacao03_final.models;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name="patient")
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String medical_history;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private PersonModel personModel;

    public PatientModel(){}
    public PatientModel(String medical_history, PersonModel personModel){
        this.medical_history = medical_history;
        this.personModel = personModel;
    }

    public void setMedical_history(String medical_history){
        this.medical_history = medical_history;
    }

    public String getMedical_history(){
        return this.medical_history;
    }

    public UUID getId(){
        return this.id;
    }

    public PersonModel getPersonModel(){
        return this.personModel;
    }

}