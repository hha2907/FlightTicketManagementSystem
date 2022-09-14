package model;

import java.util.ArrayList;

import entities.Customer;

public class CustomerModel implements ModelInterface<Customer>{
	private ArrayList<Customer> customers;

	public CustomerModel() {
		this.customers = new ArrayList<Customer>();
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public void insert(Customer t) {
		this.customers.add(t);
	}

	@Override
	public void remove(Customer t) {
		this.customers.remove(t);
	}

	@Override
	public void update(Customer t) {
		
	}

	@Override
	public boolean checkExists(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void clearList() {
		this.customers.clear();
	}
}
