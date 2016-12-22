package javaFX.ui;

import javaFX.App;
import javaFX.ui.StudentTab.StudentTabView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {


    @Autowired
    LoginView loginView;

    @Autowired
    StudentTabView studentTabView;

    @FXML
    private Button logoutButton;

    @FXML
    BorderPane borderPane;

    @FXML
    TabPane tabPane;


    @FXML
    public void initialize() {

        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();

        selectionModel.selectedIndexProperty().addListener((ov, oldTab, newTab) -> callViews());

        logoutButton.setOnAction(e -> loggingOut());

    }




    private void callViews() {

        int selectedTabIndex = tabPane.getSelectionModel().getSelectedIndex();
        Tab selectedTab = tabPane.getTabs().get(selectedTabIndex);

        switch (selectedTabIndex) {
            case 0:
                    break;
            case 1: selectedTab.setContent(studentTabView.getView());
                    break;
            case 2:
                    break;
            case 3:
                    break;
            case 4:
                    break;
            case 5:
                    break;
            default: throw new IndexOutOfBoundsException("Exception: The amount of tabs have changed. Refer to the switch case");
        }
    }


    public void loggingOut() {
        Stage stage = App.getStage();

        if (stage.getScene() != null) {
            stage.getScene().setRoot(new BorderPane());
        }
        stage.setScene(new Scene(loginView.getView()));
        stage.centerOnScreen();
        stage.show();
    }


}
