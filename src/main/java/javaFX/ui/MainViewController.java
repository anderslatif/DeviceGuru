package javaFX.ui;

import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainViewController {

	@FXML TableView<Student> studentsTable;

	@FXML TableColumn<Student, String> idColumn;
	@FXML TableColumn<Student, String> firstnameColumn;
	@FXML TableColumn<Student, String> lastnameColumn;

	@FXML Text text;


	@Autowired
    StudentService studentService;

	@FXML
	public void initialize() {

		text.setText(studentService.findAllStudents().get(0).toString());



		studentService.save(new Student("Wrong", "DB"));

		for (Student s : studentService.findAllStudents()) {
			System.out.println(s.toString());
		}

		configureProjectsTable();


		for (Student student : studentService.findAllStudents()) {
			studentsTable.getItems().add(student);
		}
		studentsTable.getSelectionModel().selectFirst();
	}



	private void configureProjectsTable() {

		idColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("firstname"));
		firstnameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastname"));
		lastnameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastname"));

		ChangeListener<Student> studentSelectionChange = (observable, oldValue, newValue) -> {
			System.out.println("new click");
		};

		studentsTable.getSelectionModel().selectedItemProperty().addListener(studentSelectionChange);
	}
}
