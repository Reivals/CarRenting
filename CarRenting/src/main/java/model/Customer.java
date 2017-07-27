package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer {
	
	private SimpleStringProperty name = new SimpleStringProperty();
	private SimpleStringProperty surname = new SimpleStringProperty();
	private SimpleStringProperty city = new SimpleStringProperty();
	private SimpleStringProperty street = new SimpleStringProperty();
	private SimpleStringProperty localNumber = new SimpleStringProperty();
	private SimpleStringProperty postCode = new SimpleStringProperty();
	private SimpleStringProperty id = new SimpleStringProperty();
	
	public Customer(SimpleStringProperty name, SimpleStringProperty surname, SimpleStringProperty city,
			SimpleStringProperty street, SimpleStringProperty localNumber, SimpleStringProperty postCode,
			SimpleStringProperty id) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.street = street;
		this.localNumber = localNumber;
		this.postCode = postCode;
		this.id = id;
	}
	public Customer(String name, String surname, String city, String street, String localNumber, String postCode,
			String id) {
		this.name.setValue(name);
		this.surname.setValue(surname);
		this.city.setValue(city);
		this.street.setValue(street);
		this.localNumber.setValue(localNumber);
		this.postCode.setValue(postCode);
		this.id.setValue(id);
	}
	public Customer() {}
	
	
	private ObservableList<Customer> observableList = FXCollections.observableArrayList();
	

	public ObservableList<Customer> getObservableList() {
		return observableList;
	}
	public String getName() {
		return name.getValue();
	}
	public String getSurname() {
		return surname.getValue();
	}
	public String getCity() {
		return city.getValue();
	}
	public String getStreet() {
		return street.getValue();
	}
	public String getLocalNumber() {
		return localNumber.getValue();
	}
	public String getPostCode() {
		return postCode.getValue();
	}
	public String getId() {
		return id.getValue();
	}
	public SimpleStringProperty getNameSimpleStringProp()
	{
		return name;
	}
	public SimpleStringProperty getSurnameSimpleStringProp()
	{
		return surname;
	}
	public SimpleStringProperty getCitySimpleStringProp()
	{
		return city;
	}
	public SimpleStringProperty getStreetSimpleStringProp()
	{
		return street;
	}
	public SimpleStringProperty getLocalNumberSimpleStringProp()
	{
		return localNumber;
	}
	public SimpleStringProperty getPostCodeSimpleStringProp()
	{
		return postCode;
	}
	public SimpleStringProperty getIdSimpleStringProp()
	{
		return id;
	}
	
	

}
