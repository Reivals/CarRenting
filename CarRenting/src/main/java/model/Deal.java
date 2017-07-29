package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Deal implements Observable {
	
	private Customer customer;
	private Car car;
	private String date;
	private ObservableList<Deal> observableList = FXCollections.observableArrayList();
	
	
	public ObservableList<Deal> getObservableList() {
		return observableList;
	}

	public Deal(Customer customer, Car car) {
		this.customer = customer;
		this.car = car;
		this.date = ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
		System.out.println("Obiekt utowrzono " + date);
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
		return  customer.getName() + "    " + customer.getSurname() + "    "+ car.getBrand() + "     ," + "    CREATED AT: " + date ;
		
	}
	public static void getCurrentDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal)); //2016/11/16 12:08:43
	}

	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
