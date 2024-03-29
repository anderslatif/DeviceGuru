package javaFX.ui.StudentTab;

import javaFX.App;
import javaFX.models.Device.Device;
import javaFX.models.Device.DeviceService;
import javaFX.models.DeviceHistory.DeviceHistory;
import javaFX.models.DeviceHistory.DeviceHistoryService;
import javaFX.models.DeviceLogin.DeviceLoginService;
import javaFX.models.Repair.RepairService;
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
import org.controlsfx.control.textfield.TextFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    RepairService repairService;

    @Autowired
    DeviceHistoryService deviceHistoryService;

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

        searchFieldsOnKeyPress();
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

        Collections.sort(uniqueSchoolClasses);

        uniqueSchoolClasses.add(0, "Alle");

        uniqueSchoolClasses.forEach(classString -> schoolClassCombobox.getItems().add(classString));

        activeStudentCombobox.getItems().addAll("Alle", "Indmeldt", "Gradueret");

        departmentCombobox.getItems().addAll("Alle", "Indskolingen", "Udskolingen");

    }




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

        studentTable.setOnKeyReleased( e -> showStudentHistory());
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
            deletedStudents.add(s);


            //Query query = entityManager.createNativeQuery("Delete From deviceguru.devices where serialnumber =" + s.getDevice().getSerialnumber());


/*            String serialNumber = s.getDevice().getSerialnumber();
            deviceHistoryService.deleteDeviceHistoryBySerialnumber(serialNumber);
            repairService.deleteRepairBySerialnumber(serialNumber);
            studentService.deleteStudent(s);*/
            //deviceLoginService.delete(s.getDeviceLogin());
            //deviceService.deleteDevice(s.getDevice());



            // todo Figure out how to delete despite foreign key constraints

            studentTable.getItems().remove(s);
        }



        Button regretButton = new Button("Fortryd Sletning");
        Tooltip toolTip = new Tooltip("Fortryd den seneste slettede elev. \nFlere tryk fortryder flere slettede elever.");
        regretButton.setTooltip(toolTip);
        regretButton.setOnAction( e -> undoDeletedStudent());
        regretButtonStackPane.getChildren().add(regretButton);
        // implement regret deleted student method

        UserMessage.showSuccess("Du har slettet en elev.");
    }

    private void undoDeletedStudent() {

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

    public void strangeUnknownName() {
        /*
        first loop through each selected
        if 9th grade is moved up then show warning
        else.. get class, analyze first char and increment.. then return as string


        */
    }

    private void searchFieldsOnKeyPress() {

        firstNameTextField.setOnKeyReleased( e -> search());
        lastNameTextField.setOnKeyReleased( e -> search());
        departmentCombobox.setOnAction( e -> search());
        activeStudentCombobox.setOnAction( e -> search());
        schoolClassCombobox.setOnAction( e -> search());
        serialNumberTextField.setOnKeyReleased( e -> search());
        emailTextField.setOnKeyReleased( e -> search());
    }

    private void search() {

        ArrayList<Student> filteredQueryList = queryList.stream()
                .filter(s ->
                        StringUtils.containsIgnoreCase(s.getFirstName(), firstNameTextField.getText()) &&
                        StringUtils.containsIgnoreCase(s.getLastName(), lastNameTextField.getText()) &&
                        StringUtils.containsIgnoreCase(s.getDevice().getSerialnumber(), serialNumberTextField.getText()) &&
                        StringUtils.containsIgnoreCase(s.getEmail(), emailTextField.getText())
                )
                .collect(Collectors.toCollection(ArrayList::new));

        String schoolClassBoxContent = schoolClassCombobox.getValue() == null ? "Alle" : schoolClassCombobox.getValue().toString();
        if (!schoolClassBoxContent.contains("Alle")) {
            filteredQueryList = filteredQueryList.stream().filter(s -> s.getSchoolClass() != null && StringUtils.containsIgnoreCase(s.getSchoolClass(), schoolClassBoxContent)).collect(Collectors.toCollection(ArrayList::new));
        }

        String departmentBoxContent = departmentCombobox.getValue() == null ? "Alle" : departmentCombobox.getValue().toString();
        if (!departmentBoxContent.contains("Alle")) {

            filteredQueryList = filteredQueryList.stream().filter(s -> s.getDepartment() != null && StringUtils.containsIgnoreCase(s.getDepartment(), departmentBoxContent)).collect(Collectors.toCollection(ArrayList::new));
        }

        String activeStudentBoxContent = activeStudentCombobox.getValue() == null ? "Alle" : activeStudentCombobox.getValue().toString();
        if (!activeStudentBoxContent.contains("Alle")) {
            filteredQueryList = filteredQueryList.stream().filter(s -> StringUtils.containsIgnoreCase(s.getActivestudent() != null ? s.getSchoolClass() : "", activeStudentBoxContent)).collect(Collectors.toCollection(ArrayList::new));
        }


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
        List<DeviceHistory> studentDeviceHistories = deviceHistoryService.findByEmail(selectedStudent.getEmail());
        double amountOfRows = studentDeviceHistories.size();

        // todo get studenthistory from table
        // easiest way to do this is to ignore time span and split the slider into equal parts depending on how many intervals there are
        // if end date and start date for something else isn't the same then another empty interval needs to be added
        // finally remember to leave the last tick empty unless it is current date

        // these values will have to be configured dynamically .. this is just an example
        deviceHistorySlider.setMin(0);
        deviceHistorySlider.setMax(2*amountOfRows-1);  // 2* because start and end date
        deviceHistorySlider.setValue(1);
        deviceHistorySlider.setMinorTickCount(0);
        deviceHistorySlider.setMajorTickUnit(1);
        deviceHistorySlider.setShowTickMarks(true);
        deviceHistorySlider.setShowTickLabels(true);

        if (amountOfRows == 0) {

            deviceHistorySlider.setMax(3);

            deviceHistorySlider.setLabelFormatter(new StringConverter<Double>() {
                @Override
                public String toString(Double n) {
                    if (n < 0.5) return ".";
                    if (n < 2) return "No device history to show";
                    return ".";
                }

                @Override
                public Double fromString(String s) {
                    switch (s) {
                        case ".":
                            return 0d;
                            case "No device history to show":
                            return 1d;
                        default:
                            return 1d;
                    }
                }
            });
        }

        else {
            ArrayList<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
            deviceHistorySlider.setMax(numbers.size()-1);
            numbers.add(0, "placeholder");

            deviceHistorySlider.setLabelFormatter(new StringConverter<Double>() {
                double currentTickCount = 0.5d;
                boolean isStartDate = true;
                int listCount = 0;
                boolean isFirstTime = true;
                boolean isSecondTime = true;

                ArrayList<Double> nValues = new ArrayList<Double>();

                @Override
                public String toString(Double n) {

/*                    for (String labelString : numbers) {
                        if (n < 0.5) return numbers.get(0);
                        if (n < 1.5) return numbers.get(1);
                        if (n < 2.5) return numbers.get(2);
                        if (n < 3.5) return numbers.get(3);
                    }
                    return ".";*/


                    while (listCount < numbers.size()-1) {

                        if (n < currentTickCount) {

                            if (isFirstTime) {
                                currentTickCount -= 1d;
                                listCount -= 1;
                                isFirstTime = false;
                            }
                            currentTickCount += 1d;
                            listCount += 1;


                            System.out.println(n + ": " + currentTickCount + "  ==  " + listCount + "  ==  "  + numbers.get(listCount));

                            return numbers.get(listCount);
                        } else {
                            return "Error";
                        }
                    }

                    if (n < currentTickCount) {
                        return numbers.get(listCount);
                    }

                    return numbers.get(listCount);
                }

                double tickCounter = -1d;

                @Override
                public Double fromString(String s) {

                    for (String labelString : numbers) {
                        if (s.contains("No value")) {
                            return tickCounter+1d;
                        }
                        if (s.contains(labelString)) {
                            return tickCounter+1d;
                        }
                    }

                    return tickCounter;
                }


                /*@Override
                public String toString(Double n) {

                    if (listCount < studentDeviceHistories.size()) {

                        currentTickCount += 1;

                        if (listCount < studentDeviceHistories.size() && isStartDate) {
                            listCount += 1;
                        }

                        if (isStartDate) {
                            isStartDate = !isStartDate;
                            if (n < currentTickCount) {
                                if (studentDeviceHistories.get(listCount).getStartdate() == null) {
                                    return "No value";
                                }
                                return studentDeviceHistories.get(listCount).getStartdate().toString();
                            }
                        } else {
                            isStartDate = !isStartDate;
                            if (studentDeviceHistories.get(listCount).getEnddate() == null) {
                                return "No value";
                            }
                            return studentDeviceHistories.get(listCount).getEnddate().toString();
                        }

                        return "No value";
                    }




*//*                    for (DeviceHistory devHis : studentDeviceHistories) {

                        currentTickCount += 1;
                        System.out.println(currentTickCount);

                        if (n < currentTickCount) {
                            if (devHis.getStartdate() == null) {
                                return "No value";
                            }
                            System.out.println("start" + currentTickCount);
                            return devHis.getStartdate().toString();
                        }

                        if (n < currentTickCount) {
                            if (devHis.getEnddate() == null) {
                                return "No value";
                            }
                            System.out.println("stop" + currentTickCount);
                            return devHis.getEnddate().toString();
                        }

                    }*//*


                    return "No value";
                }


                @Override
                public Double fromString(String s) {

                    double currentTickCount = 0d;

                    for (DeviceHistory devHis : studentDeviceHistories) {

                        if (s.contains("No value")) {
                            return currentTickCount + 1d;
                        }

                        if (devHis.getStartdate() != null && s.contains(devHis.getStartdate().toString())) {
                            return currentTickCount + 1d;
                        }

                        if (devHis.getStartdate() != null && s.contains(devHis.getEnddate().toString())) {
                            return currentTickCount + 1d;
                        }
                    }

                    return currentTickCount;


                }*/
            });

        }
    }



    private void changeToAddStudentsNode() {
        TabPane tabPane = (TabPane) App.getStage().getScene().getRoot().lookup("#tabPane");
        int selectedTabIndex = tabPane.getSelectionModel().getSelectedIndex();
        Tab selectedTab = tabPane.getTabs().get(selectedTabIndex);

        selectedTab.setContent(addStudentsView.getView());
    }


}