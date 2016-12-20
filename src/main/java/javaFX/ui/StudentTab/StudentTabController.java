package javaFX.ui.StudentTab;

import javaFX.App;
import javaFX.models.Device.DeviceService;
import javaFX.models.DeviceLogin.DeviceLoginService;
import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import javaFX.ui.StudentTab.CreateStudents.CreateStudentsView;
import javaFX.ui.StudentTab.UploadStudents.UploadStudentsView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
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

    @Autowired
    CreateStudentsView createStudentsView;

    @Autowired
    UploadStudentsView uploadStudentsView;



    @FXML
    TableView<Student> studentTable;

    @FXML
    TextField firstNameTextField;

    @FXML
    TextField lastNameTextField;

    @FXML
    ComboBox departmentCombobox;

    @FXML
    ComboBox activeStudentCombobox;

    @FXML
    ComboBox schoolClassCombobox;

    @FXML
    TextField serialNumberTextField;

    @FXML
    TextField emailTextField;

    @FXML
    Button createStudentsButton;

    @FXML
    BorderPane mainStudentTabBorderPane;

    @FXML
    Button uploadButton;

    ArrayList<Student> deletedStudents = new ArrayList<>();

    ArrayList<Student> queryList;

    @FXML
    public void initialize() {

        //loads all student objects from the database student table.
        ArrayList<Student> studentsArray = (ArrayList<Student>)studentService.findAll();
        queryList = (ArrayList<Student>)studentService.findAll();
        ObservableList<Student> studentList = FXCollections.observableArrayList(studentsArray);


        createStudentTable();
        loadStudents(studentList);

        searchFieldOnKeyPress();
        setUpSearchComboboxes();

        createStudentsButton.setOnAction( e -> changeToCreateStudentsNode());
        uploadButton.setOnAction( e -> changeToUploadStudentsNode());
    }



    public void setUpSearchComboboxes() {

        // todo this list needs to be sorted!!
        // consider using comparator
        List<String> uniqueSchoolClasses = queryList.stream().map(Student::getSchoolClass).distinct()
                .filter(s -> !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));

        uniqueSchoolClasses.forEach(classString -> schoolClassCombobox.getItems().add(classString));


        activeStudentCombobox.getItems().addAll("Indmeldt", "Gradueret", "Alle");

    }




    // consider using EasyBind.. static bindings will be natively supported by Java 9
    // https://github.com/TomasMikula/EasyBind
    /**
     * creating the tablecolumns and defining them
     */
    public void createStudentTable(){

        studentTable.setEditable(true);

        studentTable.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE
        );

        // removes the extra undefined column
        studentTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        studentTable.setOnKeyPressed( e -> {
            if (e.getCode() == KeyCode.DELETE) {
                deleteStudent();
            }
        });

        StudentTableColumns.setUpColumns(studentTable, studentService, deviceService, deviceLoginService);
    }

    //setting content in tableView
    public void loadStudents(ObservableList<Student> studentList) {
        studentTable.setItems(studentList);
    }


    public void deleteStudent() {
        // delete student
        // add to arrayList
        // add regret button
        // implement regret deleted student method
    }

    public void regretDeletedStudent() {
        // get last item in arraylist
        // add to db and observable list
        // show success message
    }


    public void searchFieldOnKeyPress() {
        firstNameTextField.setOnKeyReleased( e -> search());
        lastNameTextField.setOnKeyReleased( e -> search());
        departmentCombobox.setOnAction( e -> search());
        activeStudentCombobox.setOnAction( e -> search());
        schoolClassCombobox.setOnAction( e -> search());
        serialNumberTextField.setOnKeyReleased( e -> search());
        emailTextField.setOnKeyReleased( e -> search());
    }

    public void search() {

        // remember to include indmeldt and department combobox.. create enums

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


    public void changeToCreateStudentsNode() {
        TabPane tabPane = (TabPane) App.getStage().getScene().getRoot().lookup("#tabPane");
        int selectedTabIndex = tabPane.getSelectionModel().getSelectedIndex();
        Tab selectedTab = tabPane.getTabs().get(selectedTabIndex);

        selectedTab.setContent(createStudentsView.getView());

    }

    public void changeToUploadStudentsNode() {
        TabPane tabPane = (TabPane) App.getStage().getScene().getRoot().lookup("#tabPane");
        int selectedTabIndex = tabPane.getSelectionModel().getSelectedIndex();
        Tab selectedTab = tabPane.getTabs().get(selectedTabIndex);

        selectedTab.setContent(uploadStudentsView.getView());
    }


}