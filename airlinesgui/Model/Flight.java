package com.mycompany.airlinesgui.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight {
	
	private int id;
	private Airplane airplane;
	private Airport origin;
	private Airport destination;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private boolean delayed;
	private int bookedEconomy;
	private int bookedBusiness;
	private Employee[] staff;
	private Passenger[] passengers;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd::HH:mm:ss");
	
	public Flight() {
		delayed = false;
		bookedEconomy = 0;
		bookedBusiness = 0;
		staff = new Employee[10];
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public Airplane getAirplane() {
		return airplane;
	}
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
		int totalCapacity = airplane.getBusinessCapacity()+airplane.getEconomyCapacity();
		passengers = new Passenger[totalCapacity];
	}
	public Airport getOriginAirport() {
		return origin;
	}
	public void setOriginAirport(Airport origin) {
		this.origin = origin;
	}
	public Airport getDestinationAirport() {
		return destination;
	}
	public void setDestinationAirport(Airport destination) {
		this.destination = destination;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public String getDepartureTimeToString() {
		return formatter.format(departureTime);
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public String getArrivalTimeToString() {
		return formatter.format(arrivalTime);
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public boolean isDelayed() {
		return delayed;
	}
	public void delay() {
		delayed = true;
	}
	public int getBookedEconomy() {
		return bookedEconomy;
	}
	public void setBookedEconomy(int bookedEconomy) {
		this.bookedEconomy = bookedEconomy;
	}
	public int getBookedBusiness() {
		return bookedBusiness;
	}
	public void setBookedBusiness(int bookedBusiness) {
		this.bookedBusiness = bookedBusiness;
	}
	public Employee[] getStaff() {
		return staff;
	}
	public void setStaff(Employee[] staff) {
		this.staff = staff;
	}
	public Passenger[] getPassengers() {
		return passengers;
	}
	public void setPassengers(Passenger[] passengers) {
		this.passengers = passengers;
	}
	
	public String[] getData() {
		String status;
		if (delayed) {
			status = "delayed";
		} else {
			status = "estimated";
		}
		return new String[] {
				String.valueOf(id),
				airplane.getModel(),
				origin.getCity(),
				destination.getCity(),
				formatter.format(departureTime),
				formatter.format(arrivalTime),
				status,
				String.valueOf(airplane.getEconomyCapacity()-bookedEconomy),
				String.valueOf(airplane.getBusinessCapacity()-bookedBusiness)
				};
	}

}
