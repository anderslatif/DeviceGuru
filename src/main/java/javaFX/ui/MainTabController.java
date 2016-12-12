package javaFX.ui;

import javaFX.models.Assignment.AssignmentService;
import javaFX.models.Login.LoginService;
import javaFX.models.Student.StudentService;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MainTabController {


    @Autowired
    StudentService studentService;


    @FXML
    public void initialize() {

        /**
         * Hej Mikkel.. Dette er muligt at få fat i alle elever.. returnerer List<Student>
         * Der er også et rodet eksempel nedenunder
         */
        studentService.findAllStudents();

        // se output i konsolen!
        studentService.findAllStudents().forEach( s -> System.out.println(s.toString()));


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
