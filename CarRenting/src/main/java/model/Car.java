package model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Car {
	private SimpleIntegerProperty id = new SimpleIntegerProperty();
	private SimpleStringProperty brand = new SimpleStringProperty();
	private SimpleStringProperty engine = new SimpleStringProperty();
	private SimpleBooleanProperty navi = new SimpleBooleanProperty();
	private SimpleBooleanProperty available = new SimpleBooleanProperty();
	private SimpleDoubleProperty liters = new SimpleDoubleProperty();
	private SimpleIntegerProperty power = new SimpleIntegerProperty();
	
	ObservableList<Car> observableList = FXCollections.observableArrayList();
	public Car(int i, String string, String string2, String string3, String string4, double d, int j)
	{
		
	}
	public Car(int id,String brand,String engine,Boolean navi,Boolean available,double liters,int power)
	{
		this.id.set(id);
		this.brand.set(brand);
		this.engine.set(engine);
		this.navi.set(navi);
		this.available.set(available);
		this.liters.set(liters);
		this.power.set(power);
	}

	public Car() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id.getValue();
	}

	public String getBrand() {
		return brand.getValue();
	}

	public String getEngine() {
		return engine.getValue();
	}

	public String getNavi() {
		if(navi.getValue()==true)
			return "YES";
		else
			return "NO";
	}

	public String getAvailable() {
		if(available.getValue()==true)
			return "YES";
		else
			return "NO";
	}

	public double getLiters() {
		return liters.getValue();
	}

	public int getPower() {
		return power.getValue();
	}

	public ObservableList<Car> getObservableList() {
		return observableList;
	}
	

}
