package com.example.avaliacao03_final.mappers;

import com.example.avaliacao03_final.dtos.PersonRequestDto;
import com.example.avaliacao03_final.dtos.PersonResponseDto;
import com.example.avaliacao03_final.models.PersonModel;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public PersonResponseDto toDto(PersonModel personModel){
        return new PersonResponseDto(
                personModel.getId(),
                personModel.getName(),
                personModel.getContact(),
                personModel.getGender()
        );
    }
}
