package javaFX.ui.StudentTab;

import javaFX.models.Device.DeviceService;
import javaFX.models.DeviceLogin.DeviceLoginService;
import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentTabController {

    @Autowired
    StudentService studentService;

    @Autowired
    DeviceService deviceService;

    @Autowired
    DeviceLoginService deviceLoginService;



    @FXML
    TableView<Student> studentTable;

    @FXML
    TextField firstNameTextField;

    @FXML
    TextField lastNameTextField;

    @FXML
    ComboBox schoolClassCombobox;

    @FXML
    TextField serialNumberTextField;

    @FXML
    TextField emailTextField;




    ArrayList<Student> queryList;


    @FXML
    public void initialize() {





        studentTable.setEditable(true);

        //loads all student objects from the databases student table.
        ArrayList<Student> studentsArray = (ArrayList<Student>)studentService.findAll();
        queryList = (ArrayList<Student>)studentService.findAll();
        ObservableList<Student> studentList = FXCollections.observableArrayList(studentsArray);


        createStudentTable();
        loadStudents(studentList);


        searchFieldOnKeyPress();

        setUpSearchFields();
    }


    public void setUpSearchFields() {

        List<String> nonUniqueSchoolClasses = queryList.stream().map(Student::getSchoolClass).distinct().collect(Collectors.toCollection(ArrayList::new));
        // .groupingBy
    }




    // consider using EasyBind.. static bindings will be natively supported by Java 9
    // https://github.com/TomasMikula/EasyBind
    /**
     * creating the tablecolumns and defining them
     */
    public void createStudentTable(){

/*        studentTable.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE
        );*/

        //creating firstNamecolumn
        TableColumn<Student, String> firstNameColumn = new TableColumn<>("Fornavn");
        firstNameColumn.setMinWidth(150);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        firstNameColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setFirstName(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            studentService.save(student);
        });


        //creating lastnamecolumn
        TableColumn<Student, String> lastNameColumn = new TableColumn<>("Efternavn");
        lastNameColumn.setMinWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        lastNameColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setLastName(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            studentService.save(student);
        });


        //creating schoolclasscolumn
        TableColumn<Student, String> classColumn = new TableColumn<>("Klasse");
        classColumn.setMinWidth(50);
        classColumn.setCellValueFactory(new PropertyValueFactory<>("schoolClass"));
        classColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        classColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setSchoolClass(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            studentService.save(student);
        });

        //creating emailcolumn
        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        emailColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setEmail(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            studentService.save(student);
        });

        //creating devicecolumn
        TableColumn<Student, String> deviceColumn = new TableColumn<>("Device");
        deviceColumn.setMinWidth(200);
        deviceColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> data) {
                return new SimpleStringProperty(data.getValue().getDevice().getType());
            }
        });
        deviceColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        deviceColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).getDevice().setType(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            deviceService.save(student.getDevice());
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
        serialnumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        serialnumberColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).getDevice().setSerialnumber(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            deviceService.save(student.getDevice());
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
        passwordColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        passwordColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).getDeviceLogin().setPassword(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            deviceLoginService.save(student.getDeviceLogin());
        });


        //adding columns
        studentTable.getColumns().addAll(firstNameColumn, lastNameColumn, classColumn, emailColumn, deviceColumn, serialnumberColumn, passwordColumn);

    }


    //setting content in tableView
    public void loadStudents(ObservableList<Student> studentList) {

        studentTable.setItems(studentList);
    }


    public void searchFieldOnKeyPress() {
        firstNameTextField.setOnKeyReleased( e -> search());
        lastNameTextField.setOnKeyReleased( e -> search());
        schoolClassCombobox.setOnAction( e -> search());
        serialNumberTextField.setOnKeyReleased( e -> search());
        emailTextField.setOnKeyReleased( e -> search());
    }

    public void search() {

        String comboBoxContent = schoolClassCombobox.getSelectionModel().getSelectedItem() == null ? "" :
                schoolClassCombobox.getSelectionModel().getSelectedItem().toString();

        // todo needs more search queries inside filter.. add &&
        ArrayList<Student> filteredQueryList = queryList.stream()
                .filter(s ->
                        StringUtils.containsIgnoreCase(s.getFirstName(), firstNameTextField.getText()))
                .collect(Collectors.toCollection(ArrayList::new));

        ObservableList<Student> searchResultObsList = FXCollections.observableArrayList(filteredQueryList);
        studentTable.setItems(searchResultObsList);
    }


}
