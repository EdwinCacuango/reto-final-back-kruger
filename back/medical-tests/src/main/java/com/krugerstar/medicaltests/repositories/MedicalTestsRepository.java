package com.krugerstar.medicaltests.repositories;

import com.krugerstar.medicaltests.entities.MedicalTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MedicalTestsRepository extends JpaRepository<MedicalTest, Long> {
    List<MedicalTest> findByIdPatient(Long idPatient);
}
