package javaFX.ui.StudentTab.UploadStudents;

import javaFX.App;
import javaFX.models.Device.DeviceService;
import javaFX.models.DeviceLogin.DeviceLoginService;
import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import javaFX.ui.StudentTab.CreateStudents.CreateStudentsView;
import javaFX.ui.StudentTab.StudentTabView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UploadStudentsController {

    @Autowired
    StudentTabView studentTabView;



    @FXML
    Button uploadButton;

    @FXML
    Button readToDBButton;

    @FXML
    Button returnButton;

    @FXML
    Button addColumnButton;

    @FXML
    TextArea messageTextArea;




    @FXML
    public void initialize() {

        uploadButton.setOnAction( e -> uploadFile());
        readToDBButton.setOnAction( e -> readToDB());

        returnButton.setOnAction( e -> returnToMainNode());
        addColumnButton.setOnAction( e -> addColumn());
    }


    public void addColumn() {
        // add node block based on grid index

    }


    public void returnToMainNode() {
        TabPane tabPane = (TabPane) App.getStage().getScene().getRoot().lookup("#tabPane");
        int selectedTabIndex = tabPane.getSelectionModel().getSelectedIndex();
        Tab selectedTab = tabPane.getTabs().get(selectedTabIndex);

        selectedTab.setContent(studentTabView.getView());
    }

    public void uploadFile() {
        // filechoooser..
        // should receive file and return list
    }

    public void readToDB() {
        // check if columns more than one and allowed
    }


}
