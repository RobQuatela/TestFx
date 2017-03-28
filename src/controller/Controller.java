package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import application.Employee;
import application.EmployeeTest;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.*;


public class Controller {

	@FXML
	private TableView<Employee> dgvEmployee;
	@FXML
	private TableColumn<Employee, String> dgvEmployeeColName;
	@FXML
	private TableColumn<Employee, Double> dgvEmployeeColRate;
	@FXML
	private TableColumn<Employee, Double> dgvEmployeeColRegHours;
	@FXML
	private TableColumn<Employee, Double> dgvEmployeeColOThours;
	@FXML
	private Button btnImport = new Button();
    @FXML
    private TextField txtRate = new TextField();
    @FXML
    private TextField txtName = new TextField();
    @FXML
    private TextField txtOTHours = new TextField();
    @FXML
    private TextField txtRegHours = new TextField();
    
	
    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();
	
	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost:3306/dbTest?autoReconnect=true?useSSL=false";
	static final String USER = "root";
	static final String PASS = "P@ssG0!";
	public static Connection conn = null;
	
	public void btnImport_Clicked(ActionEvent event) {
		//setValues(nonImports());
		setValues(imports());
		//test(nonImports());
	}
	
	public ObservableList<Employee> imports() {
		String[] nextLine;
		try {
			CSVReader reader = new CSVReader(new FileReader("/home/rquatela/Desktop/test1.csv"));
			while((nextLine = reader.readNext()) != null) {
				employeeData.add(new Employee(nextLine[0], Double.parseDouble(nextLine[1]), 
						Double.parseDouble(nextLine[2]), Double.parseDouble(nextLine[3])));
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return employeeData;
	}
/*	
	public void test(ObservableList<EmployeeTest> emp) {
		for(EmployeeTest e : emp)
			System.out.println(e.getOtHours());
	}
	
	public ObservableList<Employee> nonImports() {
		employeeData.add(new Employee("Rob Quatela", 7.25, 40, 0));
		employeeData.add(new Employee("Sarah Quatela", 10, 50, 10));
		return employeeData;
	}*/
	
	public void setValues(ObservableList<Employee> imports) {
		dgvEmployeeColName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
		dgvEmployeeColRate.setCellValueFactory(new PropertyValueFactory<Employee, Double>("rate"));
		dgvEmployeeColRegHours.setCellValueFactory(new PropertyValueFactory<Employee, Double>("regHours"));
		dgvEmployeeColOThours.setCellValueFactory(new PropertyValueFactory<Employee, Double>("otHours"));
		
		dgvEmployee.setItems(imports);
	}
	
	public void selectCell(MouseEvent event) {
		txtName.setText(dgvEmployee.getSelectionModel().getSelectedItem().getName());
		txtRate.setText(String.valueOf(dgvEmployee.getSelectionModel().getSelectedItem().getRate()));
		txtRegHours.setText(String.valueOf(dgvEmployee.getSelectionModel().getSelectedItem().getRegHours()));
		txtOTHours.setText(String.valueOf(dgvEmployee.getSelectionModel().getSelectedItem().getOtHours()));
	}
	
}
