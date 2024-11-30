package com.example.avaliacao03_final.services;

import com.example.avaliacao03_final.dtos.PersonRequestDto;
import com.example.avaliacao03_final.dtos.PersonResponseDto;
import com.example.avaliacao03_final.mappers.PersonMapper;
import com.example.avaliacao03_final.models.PersonModel;
import com.example.avaliacao03_final.repositories.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;

    public PersonResponseDto save(PersonRequestDto personRequestDto){
        PersonModel personModel = new PersonModel(
                personRequestDto.name(),
                personRequestDto.contact(),
                personRequestDto.gender()
        );
        personRepository.save(personModel);
        return personMapper.toDto(personModel);
    }

    public List<PersonResponseDto> findAll(){
        return personRepository.findAll().stream().map(personMapper::toDto).toList();
    }

    public PersonResponseDto findById(UUID id){
        PersonModel personModel = verifyById(id);
        return personMapper.toDto(personModel);
    }

    //throw new IllegalStateException("Cannot delete person with ID " + id + " because it is referenced in other tables.");
    public PersonResponseDto deleteById(UUID id){
        PersonModel person = verifyById(id);
        try{ personRepository.delete(person); }
            catch(DataIntegrityViolationException ex){ throw new IllegalStateException("Cannot delete person"); }
        return personMapper.toDto(person);
    }

    public PersonResponseDto patch(UUID id, PersonRequestDto personRequestDto){
        PersonModel personModel = verifyById(id);
        if(personRequestDto.name() != null){ personModel.setName(personRequestDto.name());}
        if(personRequestDto.contact() != null){ personModel.setContact(personRequestDto.contact());}
        if(personRequestDto.gender() != null){ personModel.setGender(personRequestDto.gender());}
        personRepository.save(personModel);
        return personMapper.toDto(personModel);
    }

    protected PersonModel verifyById(UUID id){
        return personRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Person with ID " + id + " not found")
        );
    }
}
