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
    public PersonResponseDto save(@RequestBody PersonRequestDto personRequestDto){
        return personService.save(personRequestDto);
    }
    @GetMapping
    @ResponseBody
    public List<PersonResponseDto> findAll(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public PersonResponseDto findById(@PathVariable("id") String id) {
        return personService.findById(UUID.fromString(id));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public PersonResponseDto deleteById(@PathVariable("id") String id) {
        return personService.deleteById(UUID.fromString(id));
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public PersonResponseDto patch(@PathVariable("id") String id, @RequestBody PersonRequestDto personRequestDto){
        return personService.patch(UUID.fromString(id), personRequestDto);
    }
}
