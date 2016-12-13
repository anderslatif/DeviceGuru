package javaFX.ui;

import javaFX.models.Assignment.AssignmentService;
import javaFX.models.Device.Device;
import javaFX.models.Login.LoginService;
import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.fxmisc.easybind.EasyBind;
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

        //loads all student objects from the databases student table.
        ArrayList<Student> studentsArray = (ArrayList<Student>)studentService.findAllStudents();
        ObservableList<Student> studentList = FXCollections.observableArrayList(studentsArray);

        createStudentTable();
        loadStudents(studentList);

    }


    // consider using EasyBind.. static bindings will be natively supported by Java 9
    // https://github.com/TomasMikula/EasyBind
    /**
     * creating the tablecolumns and defining them
     */
    public void createStudentTable(){

        //creating firstNamecolumn
        TableColumn<Student, String> firstNameColumn = new TableColumn<>("Fornavn");
        firstNameColumn.setMinWidth(200);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        //creating lastnamecolumn
        TableColumn<Student, String> lastNameColumn = new TableColumn<>("Efternavn");
        lastNameColumn.setMinWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //creating schoolclasscolumn
        TableColumn<Student, String> classColumn = new TableColumn<>("Klasse");
        classColumn.setMinWidth(200);
        classColumn.setCellValueFactory(new PropertyValueFactory<>("schoolClass"));

        //creating emailcolumn
        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //creating devicecolumn
        TableColumn<Student, String> deviceColumn = new TableColumn<>("Device");
        deviceColumn.setMinWidth(200);
        deviceColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> data) {
                return new SimpleStringProperty(data.getValue().getDevice().getType());
            }
        });

        //creating serialnumbercolumn
        TableColumn<Student, String> serialnumberColumn = new TableColumn<>("Serienummer");
        serialnumberColumn.setMinWidth(200);
        serialnumberColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> data) {
                return new SimpleStringProperty(data.getValue().getDevice().getSerialnumber());
            }
        });
        
        //creating adgangskode column
        TableColumn<Student, String> passwordColumn = new TableColumn<>("Adgangskode");
        passwordColumn.setMinWidth(200);
        passwordColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> data) {
                return new SimpleStringProperty(data.getValue().getDeviceLogin().getPassword());
            }
        });


        //todo adgangskode

        //adding columns
        studentTable.getColumns().addAll(firstNameColumn, lastNameColumn, classColumn, emailColumn, deviceColumn, serialnumberColumn, passwordColumn);


    }


    //setting content in tableView
    public void loadStudents(ObservableList<Student> studentList) {

        studentTable.setItems(studentList);

    }











}
