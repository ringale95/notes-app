package com.raveenaingale.controller.rest;

import com.raveenaingale.dao.DataStructuresDAO;
import com.raveenaingale.dao.ProblemsDAO;
import com.raveenaingale.models.DataStructure;
import com.raveenaingale.models.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;

@Controller
@RequestMapping("api/data-structures")
public class DataStructureAPIController {

    private final DataStructuresDAO dataStructuresDAO;

    @Autowired
    public DataStructureAPIController(DataStructuresDAO dataStructuresDAO) {
        this.dataStructuresDAO = dataStructuresDAO;
    }

    @PostMapping
    @ResponseBody //To tell springboot and to ensure this is rest controller and result is returned here itself dont go to any jsp
    public DataStructure createDS(@RequestBody DataStructure structure){
        try {
            return dataStructuresDAO.create(structure);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
