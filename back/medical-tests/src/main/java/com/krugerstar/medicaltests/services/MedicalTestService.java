package com.krugerstar.medicaltests.services;

import com.krugerstar.medicaltests.entities.MedicalTest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MedicalTestService {
    List<MedicalTest> findAll();

    Optional<MedicalTest> findById(Long id);

    MedicalTest save(MedicalTest test);

    void  deleteById(Long id);

    List<MedicalTest> findByIdPatient(Long idPatient);
}
