package com.raveenaingale.controller.rest;


import com.raveenaingale.dao.ApplicationsDAO;
import com.raveenaingale.models.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("api/applications")
public class ApplicationAPIController {

    @Autowired
    private ApplicationsDAO applicationsDAO;
    @PostMapping
    @ResponseBody
    public Application createApplication(@RequestBody Application application){
        try {
            application.setCreationDate(LocalDate.now());
            return applicationsDAO.create(application);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping
    @ResponseBody
    public List<Application> getAllApplications(){
        try {
            return applicationsDAO.list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Application updateApplicationById(@PathVariable long id, @RequestBody Application updatedApplication){
        //Get existing application from DAO using id = existingApp
        try {
            Application existingApp = applicationsDAO.get(id);
            //Set the fields to existingApp
            existingApp.setCompany(updatedApplication.getCompany());
            existingApp.setTitle(updatedApplication.getTitle());
            existingApp.setStatus(updatedApplication.getStatus());
            existingApp.setLink(updatedApplication.getLink());

            return applicationsDAO.update(existingApp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
