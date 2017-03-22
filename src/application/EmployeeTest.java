package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeTest {
	private String name;
	private double rate;
	private double regHours;
	private double otHours;
	
	public EmployeeTest(String name, double rate, double regHours, double otHours) {
		setName(name);
		setRate(rate);
		setRegHours(regHours);
		setOtHours(otHours);
	}
	
	public String getName() {
		return name;
	}
	
	public double getRate() {
		return rate;
	}
	
	public double getRegHours() {
		return regHours;
	}
	
	public double getOtHours() {
		return otHours;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public void setRegHours(double regHours) {
		this.regHours = regHours;
	}
	
	public void setOtHours(double otHours) {
		this.otHours = otHours;
	}
}
