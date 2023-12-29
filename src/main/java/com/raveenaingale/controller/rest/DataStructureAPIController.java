package com.raveenaingale.controller.rest;

import com.raveenaingale.dao.DataStructuresDAO;
import com.raveenaingale.dao.ProblemsDAO;
import com.raveenaingale.models.DataStructure;
import com.raveenaingale.models.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    @PatchMapping("/{id}")
    @ResponseBody
    public DataStructure updateDS(@PathVariable int id, @RequestBody DataStructure updatedStructure) {
        try {
            DataStructure existingStructure = dataStructuresDAO.get(id);

            // Check if the structure with the given ID exists
            if (existingStructure == null) {
                // Handle the case where the structure with the given ID is not found
                // You can throw an exception or return an appropriate response
                // For simplicity, let's throw an exception here
                throw new RuntimeException("DataStructure not found with ID: " + id);
            }

            // Update the fields of the existing structure with the new values
            existingStructure.setNotes(updatedStructure.getNotes());

            // Save the updated structure
            return dataStructuresDAO.update(existingStructure);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteDS(@PathVariable int id) {
        try {
            DataStructure existingStructure = dataStructuresDAO.get(id);

            // Check if the structure with the given ID exists
            if (existingStructure == null) {
                // Handle the case where the structure with the given ID is not found
                throw new RuntimeException("DataStructure not found with ID: " + id);
            }

            // Delete the structure
            dataStructuresDAO.delete(existingStructure);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
