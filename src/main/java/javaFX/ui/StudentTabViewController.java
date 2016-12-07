package javaFX.ui;

import javaFX.models.Assignment.AssignmentService;
import javaFX.models.Login.LoginService;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class StudentTabViewController {

/*    private HashMap<String, Object> sesssion;

    public StudentTabViewController(HashMap<String, Object> sesssion) {
        this.sesssion = sesssion;
    }*/

    @Autowired
    LoginService loginService;


    @FXML
    public void initialize() {


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
