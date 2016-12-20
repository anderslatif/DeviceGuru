package javaFX.ui.StudentTab.CreateStudents;

import javaFX.App;
import javaFX.models.Student.StudentService;
import javaFX.ui.StudentTab.StudentTabView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CreateStudentsController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentTabView studentTabView;

    @FXML
    Button returnButton;

    @FXML
    Button addStudent;

    @FXML
    BorderPane mainCreateStudentsBorderPane;


    @FXML
    public void initialize() {

        listenForKeyDown();

        returnButton.setOnAction( e -> returnToMainNode());
        addStudent.setOnAction( e -> validateEnteredUser());
    }


    public void listenForKeyDown() {

        App.getStage().getScene().getRoot().setOnKeyPressed( e -> {
            if (e.getCode() == KeyCode.ENTER) {
                validateEnteredUser();
            }
            if (e.getCode() == KeyCode.TAB) {
                validateEnteredUser();
            }

        });

    }


    public void validateEnteredUser() {

        boolean oneRequiredItemNotFilledOut = false;

/*        if (nameTextField.getText.equals("")) {

        }*/



        if (oneRequiredItemNotFilledOut) {
            return;
        }

        // check if required fields have been filled out
        // if not then warn the user

        // clear textFields

        // add status message .. increment counter

    }




    public void returnToMainNode() {
        TabPane tabPane = (TabPane) App.getStage().getScene().getRoot().lookup("#tabPane");
        int selectedTabIndex = tabPane.getSelectionModel().getSelectedIndex();
        Tab selectedTab = tabPane.getTabs().get(selectedTabIndex);

        selectedTab.setContent(studentTabView.getView());

    }

}
