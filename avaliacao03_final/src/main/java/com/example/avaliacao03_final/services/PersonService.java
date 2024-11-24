package com.example.avaliacao03_final.services;

import com.example.avaliacao03_final.dtos.PersonRequestDto;
import com.example.avaliacao03_final.dtos.PersonResponseDto;
import com.example.avaliacao03_final.mappers.PersonMapper;
import com.example.avaliacao03_final.models.PersonModel;
import com.example.avaliacao03_final.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;

    public PersonResponseDto insertPerson(PersonRequestDto personRequestDto){
        PersonModel personModel = new PersonModel(
                personRequestDto.name(),
                personRequestDto.contact(),
                personRequestDto.gender()
        );
        personRepository.save(personModel);
        return personMapper.toDto(personModel);
    }

    public List<PersonResponseDto> returnPeople(){
        return personRepository.findAll().stream().map(personMapper::toDto).toList();
    }

    public PersonResponseDto returnPersonById(UUID id){
        PersonModel personModel = personRepository.findById(id).orElseThrow( () -> new RuntimeException("Person not found!"));
        return personMapper.toDto(personModel);
    }
}
