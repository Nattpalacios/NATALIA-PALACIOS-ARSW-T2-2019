package edu.eci.arsw.Airports.services;

import edu.eci.arsw.Airports.model.Airport;
import edu.eci.arsw.Airports.persistence.impl.AirportPersistenceImpl;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AirportServices {

    @Autowired
    AirportPersistenceImpl ap;

    public ArrayList<Airport> getAirportByName(String name) throws IOException {
        return ap.getAirportByName(name);
    }

}