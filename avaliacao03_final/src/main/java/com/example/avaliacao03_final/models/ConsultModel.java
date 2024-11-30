package com.example.avaliacao03_final.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="consult")
public class ConsultModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    LocalDate date;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private DoctorModel doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private PatientModel patient;

    public ConsultModel(){}
    public ConsultModel(LocalDate date, DoctorModel doctor, PatientModel patient){
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public ConsultModel(LocalDate  date){ this.date = date; }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public UUID getId() {
        return id;
    }
    public DoctorModel getDoctor() { return doctor; }
    public void setDoctor(DoctorModel doctor) { this.doctor = doctor; }
    public PatientModel getPatient() { return patient; }
}
