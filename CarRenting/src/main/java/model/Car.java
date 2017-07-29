package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
	
	ObservableList<Car> observableList = FXCollections.observableArrayList(  e -> new Observable[] {e.getAvailableProperty()});
	public Car(int id, String brand, String engine, String navi, String available, double liters, int power)
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
	
	public SimpleBooleanProperty getAvailableProperty()
	{
		return available;
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
	public void setAvailable(Boolean available) {
		this.available.setValue(available);
	}
	public void setAvailable(SimpleBooleanProperty available) {
		this.available = available;
	}



}
