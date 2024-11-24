package com.example.avaliacao03_final.controllers;

import com.example.avaliacao03_final.dtos.PersonRequestDto;
import com.example.avaliacao03_final.dtos.PersonResponseDto;
import com.example.avaliacao03_final.models.PersonModel;
import com.example.avaliacao03_final.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @PostMapping
    @ResponseBody
    public PersonResponseDto insertPerson(@RequestBody PersonRequestDto personRequestDto){
        return personService.insertPerson(personRequestDto);
    }
    @GetMapping
    @ResponseBody
    public List<PersonResponseDto> returnPeople(){
        return personService.returnPeople();
    }

    @GetMapping("/{id}")
    public PersonResponseDto returnPersonById(@PathVariable("id") String id) {
        return personService.returnPersonById(UUID.fromString(id));
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable("id") String id) {
        //personService.deletePersonById(UUID.fromString(id));
    }

}
