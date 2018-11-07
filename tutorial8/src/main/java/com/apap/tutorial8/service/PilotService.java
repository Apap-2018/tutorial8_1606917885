package com.apap.tutorial8.service;

import com.apap.tutorial8.model.PilotModel;

/**
 * PilotService
 */
public interface PilotService {
    PilotModel getPilotDetailByLicenseNumber(String licenseNumber);

    PilotModel addPilot(PilotModel pilot);

    void deletePilotByLicenseNumber(String licenseNumber);

    PilotModel getPilotDetailById(long id);
}