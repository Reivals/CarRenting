package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Deal {
	
	private Customer customer;
	private Car car;
	private ObservableList<Deal> observableList = FXCollections.observableArrayList();
	
	
	public ObservableList<Deal> getObservableList() {
		return observableList;
	}

	public Deal(Customer customer, Car car) {
		this.customer = customer;
		this.car = car;
	}
	
	public Deal() {}

	public Customer getCustomer()
	{
		return customer;
	}
	public Car getCar()
	{
		return car;
	}
	
	@Override
	public String toString()
	{
		return "Imie: " + customer.getName() + "; Nazwisko: " + customer.getSurname() + "; Marka: "+ car.getBrand();
		
	}
	
	
	
	

}
