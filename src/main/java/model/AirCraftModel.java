package model;

import java.util.ArrayList;

import dataAccessObject.AircraftDAO;
import dataAccessObject.EmployeeDAO;
import entities.Aircraft;

public class AirCraftModel implements ModelInterface<Aircraft>{
	
private ArrayList<Aircraft> aircrafts;
	
	public AirCraftModel() {
		this.aircrafts = new ArrayList<Aircraft>();
		this.aircrafts = AircraftDAO.getInstance().selectAll();
	}
	
	public AirCraftModel(ArrayList<Aircraft> listAirCraft) {
		super();
		this.aircrafts = listAirCraft;
	}
	
	public ArrayList<Aircraft> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(ArrayList<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}

	@Override
	public void insert(Aircraft t) {
		this.aircrafts.add(t);
	}

	@Override
	public void remove(Aircraft t) {
		this.aircrafts.remove(t);
	}

	@Override
	public void update(Aircraft t) {
	}

	@Override
	public boolean checkExists(Aircraft t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Aircraft search(String id) {
		for(Aircraft a: aircrafts) {
			if(a.getAircraftId().equals(id))
				return a;
		}
		return null;
	}

}
