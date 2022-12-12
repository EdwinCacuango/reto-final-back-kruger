package com.krugerstar.patients.services;

import com.krugerstar.patients.entities.Patient;
import com.krugerstar.patients.repositories.PatientsRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatientsServiceImpl implements PatientsService{
    @Autowired
    private PatientsRepositorie repository;

    @Override
    @Transactional(readOnly = true)
    public List<Patient> findAll() {
        return (List<Patient>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Patient> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
