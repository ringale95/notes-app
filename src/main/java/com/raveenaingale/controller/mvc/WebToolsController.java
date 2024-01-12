package com.raveenaingale.controller.mvc;

import com.raveenaingale.dao.DataStructuresDAO;
import com.raveenaingale.models.DataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/web-tools")
public class WebToolsController {

    private final DataStructuresDAO dataStructuresDAO;

    @Autowired
    public WebToolsController(DataStructuresDAO dataStructuresDAO) {
        this.dataStructuresDAO = dataStructuresDAO;
    }
    @GetMapping
    public ModelAndView listDataStructures(){
        Map<String, List<DataStructure>> model = new HashMap<>();

        try {
            model.put("structures", dataStructuresDAO.getWebToolsNotes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ModelAndView("data-structures", model);
    }

    @GetMapping("/{id}")
    public ModelAndView getDataStructuresById(@PathVariable int id){
        Map<String, DataStructure> model = new HashMap<>();
        try {
            model.put("structures", dataStructuresDAO.get(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ModelAndView("data-structures-notes", model);
    }

    @GetMapping("/new")
    public String createDS(){
     return "data-structure-form";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getDataStructuresByIdEdit(@PathVariable int id){
        Map<String, DataStructure> model = new HashMap<>();
        try {
            model.put("structures", dataStructuresDAO.get(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ModelAndView("data-structure-form-edit", model);
    }

}
