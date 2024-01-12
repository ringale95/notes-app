package com.raveenaingale.controller.mvc;

import com.raveenaingale.dao.ApplicationsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class InternshipController {

    @Autowired // helps to inject dao
    private ApplicationsDAO applicationsDAO;
    @GetMapping("/internship")
    public ModelAndView listApplications() throws Exception {
        Map<String, Object> model = new HashMap<>();
        model.put("applications", applicationsDAO.list());
        model.put("todaysApplications", applicationsDAO.getTodaysApplicationCount());
        model.put("totalApplications", applicationsDAO.list().size());
        return new ModelAndView("application-list", model);
    }

    @GetMapping("/applications/new")
    public String addApplication(){
        return "application-form";
    }
}
