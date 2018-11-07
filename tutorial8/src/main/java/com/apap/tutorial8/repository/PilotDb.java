package com.apap.tutorial8.repository;

import com.apap.tutorial8.model.PilotModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PilotDb
 */
@Repository
public interface PilotDb extends JpaRepository<PilotModel, Long> {
    PilotModel findByLicenseNumber(String licenseNumber);
    
    PilotModel findById(long id);

    void deleteByLicenseNumber(String licenseNumber);
}