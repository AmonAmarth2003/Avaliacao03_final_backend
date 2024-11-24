package com.example.avaliacao03_final.repositories;

import com.example.avaliacao03_final.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, UUID> {}
