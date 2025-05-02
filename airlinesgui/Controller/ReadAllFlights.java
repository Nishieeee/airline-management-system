package com.mycompany.airlinesgui.Controller;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.mycompany.airlinesgui.Model.Airplane;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;
import com.mycompany.airlinesgui.Model.Flight;
import com.mycompany.airlinesgui.Model.Passenger;
import com.mycompany.airlinesgui.View.Alert;

public class ReadAllFlights {
	
	private ArrayList<Flight> flights;
	private static DateTimeFormatter formatter = DateTimeFormatter.
			ofPattern("yyyy-MM-dd::HH:mm:ss");
	
	public ReadAllFlights(Database database) {
		flights = new ArrayList<>();
		String select = "SELECT * FROM `flights`;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			
			ArrayList<Integer> IDs = new ArrayList<>();
			ArrayList<Integer> planeIDs = new ArrayList<>();
			ArrayList<Integer> originIDs = new ArrayList<>();
			ArrayList<Integer> destIDs = new ArrayList<>();
			ArrayList<String> depTimes = new ArrayList<>();
			ArrayList<String> arrTimes = new ArrayList<>();
			ArrayList<String> dels = new ArrayList<>();
			ArrayList<Integer> bookedEconomySeats = new ArrayList<>();
			ArrayList<Integer> bookedBusinessSeats = new ArrayList<>();
			ArrayList<String> sts = new ArrayList<>();
			ArrayList<String> pass = new ArrayList<>();
			while (rs.next()) {
				IDs.add(rs.getInt("id"));
				planeIDs.add(rs.getInt("airplane"));
				originIDs.add(rs.getInt("origin"));
				destIDs.add(rs.getInt("destination"));
				depTimes.add(rs.getString("departureTime"));
				arrTimes.add(rs.getString("arrivalTime"));
				dels.add(rs.getString("isDelayed"));
				bookedEconomySeats.add(rs.getInt("bookedEconomy"));
				bookedBusinessSeats.add(rs.getInt("bookedBusiness"));
				sts.add(rs.getString("stuff"));
				pass.add(rs.getString("passengers"));
			}
			
			for (int i=0;i<IDs.size();i++) {
				Flight flight = new Flight();
				flight.setID(IDs.get(i));
				int planeID = planeIDs.get(i);
				int originID = originIDs.get(i);
				int destID = destIDs.get(i);
				String depTime = depTimes.get(i);
				String arrTime = arrTimes.get(i);
				String del = dels.get(i);
				boolean delayed = Boolean.parseBoolean(del);
				flight.setBookedEconomy(bookedEconomySeats.get(i));
				flight.setBookedBusiness(bookedBusinessSeats.get(i));
				String st = sts.get(i);
				String pas = pass.get(i);
				
				Airplane plane = (Airplane) new ReadPlaneByID(planeID, database).getAirplane();
				flight.setAirplane(plane);
				flight.setOriginAirport(new ReadAirportByID(originID, database).getAirport());
				flight.setDestinationAirport(new ReadAirportByID(destID, database).getAirport());
				LocalDateTime departure = LocalDateTime.parse(depTime, formatter);
				flight.setDepartureTime(departure);
				LocalDateTime arrival = LocalDateTime.parse(arrTime, formatter);
				flight.setArrivalTime(arrival);
				if (delayed) flight.delay();
				
				
				String[] stuffID = st.split("<%%/>");
				Employee[] stuff = new Employee[10];
				for (int j=0;j<stuffID.length;j++) {
					int id = Integer.parseInt(stuffID[j]);
					stuff[j] = (Employee) new ReadEmployeeByID(id, database).getEmployee();
				}
				flight.setStaff(stuff);
				
				String[] passengersID = pas.split("<%%/>");
				int totalCapacity = plane.getEconomyCapacity()+plane.getBusinessCapacity();
				Passenger[] passengers = new Passenger[totalCapacity];
				for (int j=0;j<passengersID.length;j++) {
					int id = Integer.parseInt(passengersID[j]);
					passengers[j] = (Passenger) new ReadPassengerByID(id, database).getPassenger();
				}
				flight.setPassengers(passengers);
				
				flights.add(flight);
			}
		} catch (Exception e) {
			new Alert(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<Flight> getFlights() {
		return flights;
	}

}
