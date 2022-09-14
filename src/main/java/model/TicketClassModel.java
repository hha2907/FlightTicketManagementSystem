package model;

import java.util.ArrayList;

import dataAccessObject.TicketClassDAO;
import entities.Ticketclass;

public class TicketClassModel implements ModelInterface<Ticketclass> {

	private ArrayList<Ticketclass> ticketclasses;
	
	public TicketClassModel() {
		ticketclasses = new ArrayList<Ticketclass>();
		ticketclasses = TicketClassDAO.getInstance().selectAll();
	}
	
	@Override
	public void insert(Ticketclass t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Ticketclass t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Ticketclass t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkExists(Ticketclass t) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Ticketclass> getTicketclasses() {
		return ticketclasses;
	}

	public void setTicketclasses(ArrayList<Ticketclass> ticketclasses) {
		this.ticketclasses = ticketclasses;
	}
	
	public Ticketclass searchByName(String name) {
		for(Ticketclass t: ticketclasses) {
			if(t.getTicketClassType().equals(name))
				return t;
		}
		return null;
	}
}
