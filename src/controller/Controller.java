package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import application.Employee;
import application.EmployeeTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller {

	@FXML
	TableView<Employee> dgvEmployee;
	@FXML
	TableColumn<Employee, String> dgvEmployeeColName;
	@FXML
	TableColumn<Employee, Double> dgvEmployeeColRate;
	@FXML
	TableColumn<Employee, Double> dgvEmployeeColRegHours;
	@FXML
	TableColumn<Employee, Double> dgvEmployeeColOTHours;
	@FXML
	Button btnImport = new Button();
	
	public void btnImport_Clicked(ActionEvent event) {
		setValues(nonImports());
		//System.out.println("test");
	}
	
	public ObservableList<Employee> imports() {
		ObservableList<Employee> list = FXCollections.observableArrayList();
		String[] nextLine;
		try {
			CSVReader reader = new CSVReader(new FileReader("/home/rquatela/Desktop/test1.csv"));
			while((nextLine = reader.readNext()) != null) {
				list.add(new Employee(nextLine[0], Double.parseDouble(nextLine[1]), 
						Double.parseDouble(nextLine[2]), Double.parseDouble(nextLine[3])));
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ObservableList<Employee> nonImports() {
		ObservableList<Employee> list = 
				FXCollections.observableArrayList(
						new Employee("Rob Quatela", 7.25, 53, 13),
						new Employee("Sarah Quatela", 15.00, 50, 10)
						);
		return list;
	}
	
	public void setValues(ObservableList<Employee> imports) {
		dgvEmployeeColName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
		dgvEmployeeColRate.setCellValueFactory(new PropertyValueFactory<Employee, Double>("rate"));
		dgvEmployeeColRegHours.setCellValueFactory(new PropertyValueFactory<Employee, Double>("regHours"));
		dgvEmployeeColOTHours.setCellValueFactory(new PropertyValueFactory<Employee, Double>("otHours"));
		dgvEmployee.setItems(imports);
	}
	
}
