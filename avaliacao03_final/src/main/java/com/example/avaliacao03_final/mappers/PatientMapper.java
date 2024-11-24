package com.example.avaliacao03_final.mappers;

import com.example.avaliacao03_final.dtos.PatientResponseDto;
import com.example.avaliacao03_final.models.PatientModel;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    public PatientResponseDto toDto(PatientModel patientModel){
        return new PatientResponseDto(
                patientModel.getId(),
                patientModel.getPersonModel().getName(),
                patientModel.getPersonModel().getContact(),
                patientModel.getPersonModel().getGender(),
                patientModel.getMedical_history(),
                patientModel.getPersonModel().getId()
        );
    }
}
