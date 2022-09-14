package model;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.IfFunc;

import dataAccessObject.TicketDAO;
import entities.Ticket;

public class TicketModel implements ModelInterface<Ticket>{

	private ArrayList<Ticket> tickets;
	
	public TicketModel() {
		tickets = new ArrayList<Ticket>();
	}
	
	@Override
	public void insert(Ticket t) {
		tickets.add(t);
	}

	@Override
	public void remove(Ticket t) {
		this.tickets.remove(t);
		
	}

	@Override
	public void update(Ticket t) {
		for(int i=0;i<tickets.size();i++) {
			if(t.getTicketId().equals(tickets.get(i).getTicketId())) {
				this.tickets.set(i, t);
				break;
			}
		}	
	}

	@Override
	public boolean checkExists(Ticket t) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public Ticket searchTicketById(int id) {
		for(Ticket t: tickets) {
			if(t.getTicketId()==id)
				return t;
		}
		return null;
	}
	
	public ArrayList<Ticket> searchByFlight(String id) {
		ArrayList<Ticket> result = new ArrayList<Ticket>();
		for(Ticket ticket : tickets) {
			if(ticket.getFlight().getFlightId().equals(id)) 
				result.add(ticket);
		}
		return result;
	}

	public void clearList() {
		this.tickets.clear();
	}
}
