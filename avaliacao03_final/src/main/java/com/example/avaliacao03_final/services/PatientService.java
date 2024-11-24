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

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PersonService personService;
    @Autowired
    PatientMapper patientMapper;
    public PatientResponseDto insertPatient(PatientRequestDto patientRequestDto){
        PersonModel personModel = personService.personRepository.findById(patientRequestDto.id())
                .orElseThrow(() -> new EntityNotFoundException("Person with ID " + patientRequestDto.id() + " not found!"));

        PatientModel patientModel = new PatientModel(patientRequestDto.medical_history(), personModel);
        patientRepository.save(patientModel);
        return patientMapper.toDto(patientModel);
    }

    public List<PatientResponseDto> returnPatients(){
        //return patientRepository.findAll();
        return patientRepository.findAll().stream().map(patientMapper::toDto).toList();
    }
}
