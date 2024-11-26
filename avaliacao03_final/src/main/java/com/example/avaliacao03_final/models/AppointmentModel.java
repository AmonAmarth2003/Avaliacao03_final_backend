package com.example.avaliacao03_final.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="appointment")
public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private DoctorModel doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private PatientModel patient;

    public AppointmentModel(){}
    public AppointmentModel(LocalDate date, DoctorModel doctor, PatientModel patient){
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public AppointmentModel(LocalDate  date){ this.date = date; }
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
    public PatientModel getPatient() { return patient; }
}
