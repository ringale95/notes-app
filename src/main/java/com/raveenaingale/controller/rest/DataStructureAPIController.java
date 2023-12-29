package com.raveenaingale.controller.rest;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.raveenaingale.dao.DataStructuresDAO;
import com.raveenaingale.dao.ProblemsDAO;
import com.raveenaingale.models.DataStructure;
import com.raveenaingale.models.Problem;

import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

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
    
    @GetMapping("/{id}/export")
    @ResponseBody
    public void export(@PathVariable int id, HttpServletResponse response) throws Exception {
    	try {
            DataStructure existingStructure = dataStructuresDAO.get(id);

            // Check if the structure with the given ID exists
            if (existingStructure == null) {
                // Handle the case where the structure with the given ID is not found
                throw new RuntimeException("DataStructure not found with ID: " + id);
            }

            // Export logic - Convert existingStructure into a CSV and send it in the response
            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=data_structure_export.csv");

            // You need to implement a CSV conversion logic here based on your DataStructure model
            String csvData = existingStructure.getId() + ";" +
                             existingStructure.getName() + ";" +
                             StringEscapeUtils.escapeCsv(existingStructure.getNotes());

            response.getWriter().write(csvData);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/import")
    @ResponseBody
    public void importData(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws Exception {
    	 try (Reader reader = new InputStreamReader(file.getInputStream())) {
             CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
             CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(csvParser).build();

             List<String[]> records = csvReader.readAll();

             for (String[] record : records) {
                 // Assuming CSV columns are in the order: id, name, notes
                 DataStructure dataStructure = new DataStructure();
                 dataStructure.setName(record[1].trim());
                 dataStructure.setNotes(StringEscapeUtils.unescapeHtml4(record[2].trim()));

                 // Save the DataStructure to the database using your DAO
                 dataStructuresDAO.create(dataStructure);
             }

         } catch (IOException e) {
             throw new RuntimeException("Error importing data from file", e);
         }
    }
}
