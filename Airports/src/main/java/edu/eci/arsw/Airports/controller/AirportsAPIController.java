package edu.eci.arsw.Airports.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.Airports.services.AirportServices;


@RestController
@RequestMapping("/airports")
public class AirportsAPIController {

    @Autowired
    AirportServices as = null;

    @GetMapping("/{name}")
    public ResponseEntity<?> getAirportByName(@PathVariable ("name") String name){
        try {
            return new ResponseEntity<>(as.getAirportByName(name),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(AirportsAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}