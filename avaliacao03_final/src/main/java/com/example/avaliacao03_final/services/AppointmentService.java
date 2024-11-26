package com.example.avaliacao03_final.services;

import com.example.avaliacao03_final.dtos.AppointmentRequestDto;
import com.example.avaliacao03_final.dtos.AppointmentResponseDto;
import com.example.avaliacao03_final.mappers.AppointmentMapper;
import com.example.avaliacao03_final.models.AppointmentModel;
import com.example.avaliacao03_final.models.DoctorModel;
import com.example.avaliacao03_final.models.PatientModel;
import com.example.avaliacao03_final.repositories.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository repository;
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;
    @Autowired
    AppointmentMapper mapper;
    public AppointmentResponseDto save(AppointmentRequestDto request){
        DoctorModel doctor = doctorService.verifyById(request.doctor_id());
        PatientModel patient = patientService.verifyById(request.patient_id());
        AppointmentModel appointment = new AppointmentModel(request.date(), doctor, patient);
        repository.save(appointment);
        return mapper.toDto(appointment);
    }

    public List<AppointmentResponseDto> findAll(){
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public AppointmentResponseDto findById(UUID id){
        AppointmentModel appointment = verifyId(id);
        return mapper.toDto(appointment);
    }

    public AppointmentResponseDto deleteById(UUID id){
        AppointmentModel appointment = verifyId(id);
        repository.delete(appointment);
        return mapper.toDto(appointment);
    }

    public AppointmentResponseDto patch(UUID id, AppointmentRequestDto request){
        AppointmentModel appointment = verifyId(id);
        //add verification if trying altering Patient or Doctor
        if(request.doctor_id() != null){ throw new RuntimeException("Cannot change Doctor relationship with Appointment"); }
        if(request.patient_id() != null){ throw new RuntimeException("Cannot change Patient relationship with Appointment"); }
        appointment.setDate(request.date());
        repository.save(appointment);
        return mapper.toDto(appointment);
    }

    private AppointmentModel verifyId(UUID id){
        return repository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("Appointment with ID " + id + " not found"));
    }

}
