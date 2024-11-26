package com.example.avaliacao03_final.mappers;

import com.example.avaliacao03_final.dtos.DoctorResponseDto;
import com.example.avaliacao03_final.models.DoctorModel;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public DoctorResponseDto toDto(DoctorModel doctor){
        return new DoctorResponseDto(
                doctor.getId(),
                doctor.getPersonModel().getName(),
                doctor.getPersonModel().getContact(),
                doctor.getPersonModel().getGender(),
                doctor.getSpecialization(),
                doctor.getPersonModel().getId()
        );
    }
}
