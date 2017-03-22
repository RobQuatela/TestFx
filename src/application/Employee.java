package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Employee {

	private SimpleStringProperty name;
	private SimpleDoubleProperty rate;
	private SimpleDoubleProperty regHours;
	private SimpleDoubleProperty otHours;
	
	public Employee(String name, double rate, double regHours, double otHours) {
		setName(name);
		setRate(rate);
		setRegHours(regHours);
		setOtHours(otHours);
	}
	
	public String getName() {
		return name.get();
	}
	
	public double getRate() {
		return rate.get();
	}
	
	public double getRegHours() {
		return regHours.get();
	}
	
	public double getOtHours() {
		return otHours.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public void setRate(double rate) {
		this.rate.set(rate);
	}
	
	public void setRegHours(double regHours) {
		this.regHours.set(regHours);
	}
	
	public void setOtHours(double otHours) {
		this.otHours.set(otHours);
	}
}
