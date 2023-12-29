package com.raveenaingale.controller.rest;

import com.raveenaingale.dao.ProblemsDAO;
import com.raveenaingale.models.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/problems")
public class ProblemsAPIController {

    private final ProblemsDAO problemsDAO;

    @Autowired
    public ProblemsAPIController(ProblemsDAO problemsDAO) {
        this.problemsDAO = problemsDAO;
    }

    @PostMapping
    @ResponseBody //To tell springboot and to ensure this is rest controller and result is returned here itself dont go to any jsp
    public Problem createProblem(@RequestBody Problem problem){
        try {
            return problemsDAO.create(problem);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
