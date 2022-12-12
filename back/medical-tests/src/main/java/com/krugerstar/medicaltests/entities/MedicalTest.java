package com.krugerstar.medicaltests.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tests")
public class MedicalTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTest;

    @Column(nullable = false)
    private Long idPatient;
    @Column(precision=5, scale=2)
    private float sugarLevel;
    @Column(precision=5, scale=2)
    private float oxygenLevel;
    @Column(precision = 5, scale = 2)
    private float fatLevel;

    @Column(nullable = false)
    private String medicalRisk;

    public String getMedicalRisk() {
        return medicalRisk;
    }

    public void setMedicalRisk(String medicalRisk) {
        this.medicalRisk = medicalRisk;
    }

    public float getFatLevel() {
        return fatLevel;
    }

    public void setFatLevel(float fatLevel) {
        this.fatLevel = fatLevel;
    }

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date  created_at;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    public Long getIdTest() {
        return idTest;
    }

    public void setIdTest(Long idTest) {
        this.idTest = idTest;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public float getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(float sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public float getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(float oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

}
