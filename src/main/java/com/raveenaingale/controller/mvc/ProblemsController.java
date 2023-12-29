package com.raveenaingale.controller.mvc;


import com.raveenaingale.dao.ProblemsDAO;
import com.raveenaingale.models.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/problems")
public class ProblemsController {
    private final ProblemsDAO problemsDAO;
    @Autowired
    public ProblemsController(ProblemsDAO problemsDAO) {
        this.problemsDAO = problemsDAO;
    }
    @GetMapping
    public ModelAndView loadProblems(){

        Map<String, List<Problem>> model = new HashMap<>();
        try {
            model.put("problems", problemsDAO.list());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ModelAndView("problems",model);
    }

    @GetMapping("/new")
    public String createProblem(){
        return "problems-form";
    }
}
