package com.krugerstar.patients.services;

import com.krugerstar.patients.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientsService {
    //Get all
    List<Patient> findAll();

    //Get by id
    Optional<Patient> findById(Long id);

    //Save one
    Patient save(Patient patient);

    //Delete one
    void delete(Long id);
}
