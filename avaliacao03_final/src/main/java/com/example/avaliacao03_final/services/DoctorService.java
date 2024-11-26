package com.example.avaliacao03_final.services;

import com.example.avaliacao03_final.dtos.DoctorRequestDto;
import com.example.avaliacao03_final.dtos.DoctorResponseDto;
import com.example.avaliacao03_final.mappers.DoctorMapper;
import com.example.avaliacao03_final.models.DoctorModel;
import com.example.avaliacao03_final.models.PersonModel;
import com.example.avaliacao03_final.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PersonService personService;
    @Autowired
    DoctorMapper doctorMapper;

    public DoctorResponseDto save(DoctorRequestDto doctorRequestDto){
        PersonModel person = personService.verifyById(doctorRequestDto.id());
        DoctorModel doctor = new DoctorModel(doctorRequestDto.specialization(), person);
        doctorRepository.save(doctor);
        return doctorMapper.toDto(doctor);
    }

    public List<DoctorResponseDto> findAll(){
        return doctorRepository.findAll().stream().map(doctorMapper::toDto).toList();
    }

    public DoctorResponseDto findById(UUID id){
        DoctorModel doctor = verifyById(id);
        return doctorMapper.toDto(doctor);
    }

    public DoctorResponseDto deleteById(UUID id){
        DoctorModel doctor = verifyById(id);
        return doctorMapper.toDto(doctor);
    }

    public DoctorResponseDto patch(UUID id, DoctorRequestDto doctorRequestDto){
        if(doctorRequestDto.id() != null) { throw new RuntimeException("Cannot change relationship between Doctor and Person"); }
        DoctorModel doctor = verifyById(id);
        if(doctorRequestDto.specialization() != null) { doctor.setSpecialization(doctorRequestDto.specialization()); };
        return doctorMapper.toDto(doctor);
    }

    protected DoctorModel verifyById(UUID id){
        return doctorRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("Person with ID " + id + " not found"));
    }

}
