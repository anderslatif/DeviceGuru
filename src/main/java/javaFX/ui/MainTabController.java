package javaFX.ui;

import javaFX.models.Assignment.AssignmentService;
import javaFX.models.Login.LoginService;
import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class MainTabController {


    @Autowired
    StudentService studentService;

    @FXML
    TableView<Student> studentTable;


    @FXML
    public void initialize() {


        //loads all student objects from the databases student tabel.
        ArrayList<Student> studentsArray = (ArrayList<Student>)studentService.findAllStudents();
        ObservableList<Student> studentList = FXCollections.observableArrayList(studentsArray);


        createStudentTable();
        loadStudents(studentList);

    }

    //creating the tablecolumns and defines them.
    public void createStudentTable(){

        //creating firstNamecolumn
        TableColumn<Student, String> firstNameColumn = new TableColumn<>("Fornavn");
        firstNameColumn.setMinWidth(200);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        //creating lastnamecolumn
        TableColumn<Student, String> lastNameColumn = new TableColumn<>("Efternavn");
        lastNameColumn.setMinWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //creating emailcolumn
        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //creating emailcolumn
        TableColumn<Student, String> classColoumn = new TableColumn<>("Klasse");
        classColoumn.setMinWidth(200);
        classColoumn.setCellValueFactory(new PropertyValueFactory<>("schoolClass"));

        //creating devicecolumn
        TableColumn<Student, String> deviceColoumn = new TableColumn<>("Device");
        deviceColoumn.setMinWidth(200);
        deviceColoumn.setCellValueFactory(new PropertyValueFactory<>("device"));

        //adding columns
        studentTable.getColumns().addAll(firstNameColumn, lastNameColumn, emailColumn, classColoumn, deviceColoumn);


    }


    //setting content in tableView
    public void loadStudents(ObservableList<Student> studentList) {

        studentTable.setItems(studentList);

    }






    /*	@FXML TableView<Assignment> studentsTable;

	@FXML TableColumn<Assignment, String> idColumn;
	@FXML TableColumn<Assignment, String> firstnameColumn;
	@FXML TableColumn<Assignment, String> lastnameColumn;

	@FXML Text text;


	@Autowired
	LoginService studentService;

	@FXML
	public void initialize() {

		System.out.println("AAAAAAAAAAA" + studentService.findAllAssignments().size());
//		text.setText(studentService.findAllAssignments().get(0).toString());



		studentService.save(new Assignment("Wrong", "DB"));

		for (Assignment s : studentService.findAllAssignments()) {
			System.out.println(s.toString());
		}

		configureProjectsTable();


		for (Assignment student : studentService.findAllAssignments()) {
			studentsTable.getItems().add(student);
		}
		studentsTable.getSelectionModel().selectFirst();
	}



	private void configureProjectsTable() {

		idColumn.setCellValueFactory(new PropertyValueFactory<Assignment, String>("firstname"));
		firstnameColumn.setCellValueFactory(new PropertyValueFactory<Assignment, String>("lastname"));
		lastnameColumn.setCellValueFactory(new PropertyValueFactory<Assignment, String>("lastname"));

		ChangeListener<Assignment> studentSelectionChange = (observable, oldValue, newValue) -> {
			System.out.println("new click");
		};

		studentsTable.getSelectionModel().selectedItemProperty().addListener(studentSelectionChange);
	}*/





}
