package edu.eci.arsw.Airports.persistence;

import java.io.IOException;
import java.util.ArrayList;

import edu.eci.arsw.Airports.model.Airport;

public interface AirportPersistence {

    public ArrayList<Airport> getAirportByName(String ciudad) throws IOException;

}
