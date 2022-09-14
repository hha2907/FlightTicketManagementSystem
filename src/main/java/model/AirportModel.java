package model;

import java.util.ArrayList;

import dataAccessObject.AirportDAO;
import entities.Airport;
import net.bytebuddy.asm.Advice.This;

public class AirportModel implements ModelInterface<Airport> {
	private ArrayList<Airport> airports;
	
	public AirportModel() {
		this.airports = new ArrayList<Airport>();
		this.airports = AirportDAO.getInstance().selectAll();
	}
	
	public AirportModel(ArrayList<Airport> listAirport) {
		super();
		this.airports = listAirport;
	} 
	
	public ArrayList<Airport> getAirports() {
		return airports;
	}

	public void setAirports(ArrayList<Airport> airports) {
		this.airports = airports;
	}

	@Override
	public void insert(Airport t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Airport t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Airport t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkExists(Airport t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Airport searchByName(String name) {
		for(Airport airport: airports) {
			if(airport.getAirportName().equals(name))
				return airport;
		}
		return null;
	}
	
	public Airport searchById(String id) {
		for(Airport airport: airports) {
			if(airport.getDepartureId().equals(id)) {
				return airport;
			}
		}
		return null;
	}

}
