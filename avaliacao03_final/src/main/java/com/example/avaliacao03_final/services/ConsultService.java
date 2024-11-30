package com.example.avaliacao03_final.services;

import com.example.avaliacao03_final.dtos.ConsultRequestDto;
import com.example.avaliacao03_final.dtos.ConsultResponseDto;
import com.example.avaliacao03_final.mappers.ConsultMapper;
import com.example.avaliacao03_final.models.ConsultModel;
import com.example.avaliacao03_final.models.DoctorModel;
import com.example.avaliacao03_final.models.PatientModel;
import com.example.avaliacao03_final.repositories.ConsultRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultService {
    @Autowired
    ConsultRepository repository;
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;
    @Autowired
    ConsultMapper mapper;
    public ConsultResponseDto save(ConsultRequestDto request){
        DoctorModel doctor = doctorService.verifyById(request.doctor_id());
        PatientModel patient = patientService.verifyById(request.patient_id());
        if(patient.getPersonModel().getId() == doctor.getPersonModel().getId()){ throw new RuntimeException("cannot schedule an consult with the same person"); }
        ConsultModel appointment = new ConsultModel(request.date(), doctor, patient);
        repository.save(appointment);
        return mapper.toDto(appointment);
    }

    public List<ConsultResponseDto> findAll(){
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public ConsultResponseDto findById(UUID id){
        ConsultModel appointment = verifyId(id);
        return mapper.toDto(appointment);
    }

    public ConsultResponseDto deleteById(UUID id){
        ConsultModel appointment = verifyId(id);
        repository.delete(appointment);
        return mapper.toDto(appointment);
    }

    public ConsultResponseDto patch(UUID id, ConsultRequestDto request){
        ConsultModel consult = verifyId(id);
        if(request.doctor_id() != null){
            DoctorModel doctor = doctorService.verifyById(request.doctor_id());
            // code if doctor ID is the same as before (not really a bug, that's why it is commented)
            // if(consult.getDoctor().getId() == doctor.getId()){ throw new RuntimeException("same doctor"); }
            consult.setDoctor(doctor);
        }
        if(request.patient_id() != null){ throw new RuntimeException("Cannot change patient in a consult"); }
        consult.setDate(request.date());
        repository.save(consult);
        return mapper.toDto(consult);
    }

    private ConsultModel verifyId(UUID id){
        return repository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("Consult with ID " + id + " not found"));
    }

}
