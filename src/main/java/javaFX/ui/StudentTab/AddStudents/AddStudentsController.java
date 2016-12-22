package javaFX.ui.StudentTab.AddStudents;

import javaFX.App;
import javaFX.ui.StudentTab.StudentTabView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddStudentsController {

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


    private void addColumn() {
        // add node block based on grid index

    }


    private void returnToMainNode() {
        TabPane tabPane = (TabPane) App.getStage().getScene().getRoot().lookup("#tabPane");
        int selectedTabIndex = tabPane.getSelectionModel().getSelectedIndex();
        Tab selectedTab = tabPane.getTabs().get(selectedTabIndex);

        selectedTab.setContent(studentTabView.getView());
    }

    private void uploadFile() {
        // filechoooser..
        // should receive file and return list
    }

    private void readToDB() {
        // check if columns more than one and allowed
    }


}
