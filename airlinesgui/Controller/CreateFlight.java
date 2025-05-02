package com.mycompany.airlinesgui.Controller;

import java.util.ArrayList;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Flight;
import com.mycompany.airlinesgui.View.Alert;
import java.sql.SQLException;

public class CreateFlight {
    
    private boolean created = false;
    
    public CreateFlight(Database database, Flight flight) {
        ArrayList<Flight> flights = new ReadAllFlights(database).getFlights();
        int id = 0;
        if (!flights.isEmpty()) id = flights.size();
        
        flight.setID(id);
        
        String insert = "INSERT INTO `flights` (`id`, `airplane`, `origin`, `destination`, "
            + "`departureTime`, `arrivalTime`, `isDelayed`, `bookedEconomy`, `bookedBusiness`, "
            + "`stuff`, `passengers`) VALUES ('" + flight.getID() + "','"
            + flight.getAirplane().getId() + "','"
            + flight.getOriginAirport().getID() + "','"
            + flight.getDestinationAirport().getID() + "','"
            + flight.getDepartureTimeToString() + "','"
            + flight.getArrivalTimeToString() + "',0,0,0,"
            + "'<%%/>','<%%/>');";
        try {
            database.getStatement().execute(insert);
            created = true;
        } catch (SQLException e) {
            new Alert(e.getMessage());
            created = false;
        }
    }
    
    public boolean isCreated() {
        return created;
    }
}
