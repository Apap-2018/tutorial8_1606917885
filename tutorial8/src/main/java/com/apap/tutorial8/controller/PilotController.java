package com.apap.tutorial8.controller;

import com.apap.tutorial8.model.PilotModel;
import com.apap.tutorial8.service.PilotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PilotController
 */
@Controller
public class PilotController {
    @Autowired
    private PilotService pilotService;

    @RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("pilot", new PilotModel());
        return "add-pilot";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
    private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
        pilotService.addPilot(pilot);
        return "add";
    }

    @RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
    private String view(@RequestParam(value = "licenseNumber") String licenseNumber, Model model) {
        PilotModel archivePilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        
        model.addAttribute("pilot", archivePilot);
        return "view-pilot";
    }

    @RequestMapping(value = "/pilot/delete", method = RequestMethod.GET)
    private String delete(@RequestParam(value = "licenseNumber") String licenseNumber, Model model) {
        pilotService.deletePilotByLicenseNumber(licenseNumber);
        return "delete";
    }

    @RequestMapping(value = "/pilot/update", method = RequestMethod.GET)
    private String update(@RequestParam(value = "licenseNumber") String licenseNumber, Model model) {
        PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        model.addAttribute("pilot", archive);
        return "update-pilot";
    }

    @RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
    private @ResponseBody PilotModel updatePilotSubmit(@ModelAttribute PilotModel pilot, Model model) {
        pilotService.addPilot(pilot);
        return pilot;
    }
}