package model;

import java.util.ArrayList;

import dataAccessObject.FlightDAO;
import entities.Flight;
import net.bytebuddy.asm.Advice.This;

public class FlightModel {
private ArrayList<Flight> flights;
	
	public FlightModel() {
		this.flights = new ArrayList<Flight>();
	}
	
	public FlightModel(ArrayList<Flight> listFlight) {
		super();
		this.flights = listFlight;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<Flight> listFlight) {
		this.flights = listFlight;
	}
	
	public void insert(Flight flg) {
		this.flights.add(flg);
	}
	
	public void remove(Flight flg) {
		flights.remove(flg);
	}
	
	public void update(Flight f) {
		for(int i=0;i<flights.size();i++) {
			if(f.getFlightId().equals(flights.get(i).getFlightId())) {
				this.flights.set(i, f);
				break;
			}
		}
	}

	public boolean kiemTraStudentTonTai(Flight f) {
		for(Flight flight: this.flights) {
			if(flight.getFlightId() == f.getFlightId())
				return true;
		}
		return false;
	}
	
	public Flight searchById(String id) {
		for(Flight f: flights) {
			if(f.getFlightId().equals(id))
				return f;
		}
		return null;
	}
	
	public void clearList() {
		this.flights.clear();
	}
}
