package com.example.avaliacao03_final.services;

import com.example.avaliacao03_final.dtos.PatientRequestDto;
import com.example.avaliacao03_final.dtos.PatientResponseDto;
import com.example.avaliacao03_final.mappers.PatientMapper;
import com.example.avaliacao03_final.models.PatientModel;
import com.example.avaliacao03_final.models.PersonModel;
import com.example.avaliacao03_final.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PersonService personService;
    @Autowired
    PatientMapper patientMapper;
    public PatientResponseDto save(PatientRequestDto patientRequestDto){
        PersonModel person = personService.verifyById(patientRequestDto.id());
        PatientModel patient = new PatientModel(patientRequestDto.medical_history(), person);
        patientRepository.save(patient);
        return patientMapper.toDto(patient);
    }

    public List<PatientResponseDto> findAll(){
        return patientRepository.findAll().stream().map(patientMapper::toDto).toList();
    }

    public PatientResponseDto findById(UUID id){
        PatientModel patient = verifyById(id);
        patientRepository.deleteById(id);
        return patientMapper.toDto(patient);
    }

    public PatientResponseDto deleteById(UUID id){
        PatientModel patient = verifyById(id);
        patientRepository.deleteById(id);
        return patientMapper.toDto(patient);
    }

    public PatientResponseDto patch(UUID id, PatientRequestDto patientRequestDto){
        //maybe change throw message for something more concise
        if(patientRequestDto.id() != null){ throw new RuntimeException("Cannot change User relationship with Patient"); }
        PatientModel patient = verifyById(id);
        patient.setMedical_history(patientRequestDto.medical_history());
        patientRepository.save(patient);
        return patientMapper.toDto(patient);
    }

    protected PatientModel verifyById(UUID id){
        return patientRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("Patient with ID " + id + " not found"));
    }
}
