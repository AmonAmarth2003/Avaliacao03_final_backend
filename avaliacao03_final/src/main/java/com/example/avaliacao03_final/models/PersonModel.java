package com.example.avaliacao03_final.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="person")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String contact;
    private String gender;

    //Apperently hibernate requires a default no args constructor to be able to handle the repositories methods.
    public PersonModel() {}
    public PersonModel(String name, String contact, String gender){
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public String getContact(){
        return this.contact;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return this.gender;
    }

    public UUID getId(){
        return this.id;
    }
}
