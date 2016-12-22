package javaFX.ui.StudentTab;

import javaFX.App;
import javaFX.models.Device.DeviceService;
import javaFX.models.DeviceLogin.DeviceLoginService;
import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import javaFX.ui.StudentTab.AddStudents.AddStudentsView;
import javaFX.util.UserMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.StringConverter;
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
    AddStudentsView addStudentsView;



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
    Button addStudentsButton;

    @FXML
    BorderPane mainStudentTabBorderPane;

    @FXML
    StackPane regretButtonStackPane;

    @FXML
    Slider deviceHistorySlider;

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
        setUpSlider();

        addStudentsButton.setOnAction( e -> changeToAddStudentsNode());
    }



    private void setUpSearchComboboxes() {

        // todo this list needs to be sorted!!
        // consider using comparator
        List<String> uniqueSchoolClasses = queryList.stream().map(Student::getSchoolClass).distinct()
                .filter(s -> !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));

        uniqueSchoolClasses.forEach(classString -> schoolClassCombobox.getItems().add(classString));

        activeStudentCombobox.getItems().addAll("Indmeldt", "Gradueret", "Alle");

        departmentCombobox.getItems().addAll("Alle", "Indskolingen", "Udskolingen");

    }




    // consider using EasyBind.. static bindings will be natively supported by Java 9
    // https://github.com/TomasMikula/EasyBind
    /**
     * creating the tablecolumns and defining them
     */
    private void createStudentTable(){

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

        studentTable.setOnMouseClicked( e -> showStudentHistory());

        StudentTableColumns.setUpColumns(studentTable, studentService, deviceService, deviceLoginService);
    }

    //setting content in tableView
    private void loadStudents(ObservableList<Student> studentList) {
        studentTable.setItems(studentList);
    }



    private void deleteStudent() {

        List<Student> studentsToDelete = studentTable.getSelectionModel().getSelectedItems();

        for (Student s : studentsToDelete) {
            System.out.println(s);
            deletedStudents.add(s);

            // delete device history
            //deviceService.delete(s.getDevice());
            deviceLoginService.delete(s.getDeviceLogin());

            // todo Figure out how to delete despite foreign key constraints
            //studentService.delete(s);

            studentTable.getItems().remove(s);
        }



        Button regretButton = new Button("Fortryd Sletning");
        Tooltip toolTip = new Tooltip("Fortryd den seneste slettede elev. \nFlere tryk fortryder flere slettede elever.");
        regretButton.setTooltip(toolTip);
        regretButton.setOnAction( e -> regretDeletedStudent());
        regretButtonStackPane.getChildren().add(regretButton);
        // implement regret deleted student method

        UserMessage.showSuccess("Du har slettet en elev.");
    }

    private void regretDeletedStudent() {

        Student studentToAddAgain = deletedStudents.get(deletedStudents.size()-1);
        deletedStudents.remove(studentToAddAgain);

        studentTable.getItems().add(studentToAddAgain);
        studentService.save(studentToAddAgain);

        if (deletedStudents.size() == 0) {
            regretButtonStackPane.getChildren().clear();
        }

        UserMessage.showSuccess("Du har fortrudt sidste slettede elev.");
    }

    // todo opryk button

    private void searchFieldOnKeyPress() {
        firstNameTextField.setOnKeyReleased( e -> search());
        lastNameTextField.setOnKeyReleased( e -> search());
        departmentCombobox.setOnAction( e -> search());
        activeStudentCombobox.setOnAction( e -> search());
        schoolClassCombobox.setOnAction( e -> search());
        serialNumberTextField.setOnKeyReleased( e -> search());
        emailTextField.setOnKeyReleased( e -> search());
    }

    private void search() {

        // remember to include indmeldt and department combobox.. create enums
        // need to change the entity model

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


    private void setUpSlider() {
        deviceHistorySlider.setShowTickMarks(false);
        // the thumb is the round selector on the slider
//        thumb.getChildren().clear();
    }


    private void showStudentHistory() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        selectedStudent.getDevice().getSerialnumber();

        // todo get studenthistory from table
        // easiest way to do this is to ignore time span and split the slider into equal parts depending on how many intervals there are
        // if end date and start date for something else isn't the same then another empty interval needs to be added
        // finally remember to leave the last tick empty unless it is current date

        // these values will have to be configured dynamically .. this is just an example
        deviceHistorySlider.setMin(0);
        deviceHistorySlider.setValue(1);
        deviceHistorySlider.setMax(3);
        deviceHistorySlider.setMinorTickCount(0);
        deviceHistorySlider.setMajorTickUnit(1);
        deviceHistorySlider.setShowTickMarks(true);
        deviceHistorySlider.setShowTickLabels(true);


        deviceHistorySlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                if (n < 0.5) return "Value1";
                if (n < 1.5) return "Value2";
                if (n < 2.5) return "Value3";

                return "Value 4";
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "Value1":
                        return 0d;
                    case "Value2":
                        return 1d;
                    case "Value3":
                        return 2d;
                    case "Value4":
                        return 3d;

                    default:
                        return 3d;
                }
            }
        });

    }



    private void changeToAddStudentsNode() {
        TabPane tabPane = (TabPane) App.getStage().getScene().getRoot().lookup("#tabPane");
        int selectedTabIndex = tabPane.getSelectionModel().getSelectedIndex();
        Tab selectedTab = tabPane.getTabs().get(selectedTabIndex);

        selectedTab.setContent(addStudentsView.getView());
    }


}