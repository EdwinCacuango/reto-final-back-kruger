package com.krugerstar.patients.repositories;

import com.krugerstar.patients.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepositorie extends JpaRepository<Patient, Long> {
}
