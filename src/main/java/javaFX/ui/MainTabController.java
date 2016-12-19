package javaFX.ui;

import antlr.MismatchedTokenException;
import com.google.common.eventbus.EventBus;
import javaFX.App;
import javaFX.models.Device.DeviceService;
import javaFX.models.DeviceLogin.DeviceLoginService;
import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import javaFX.ui.StudentTab.StudentTabController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@Component
public class MainTabController {


    @Autowired
    LoginView loginView;


    @FXML
    private Button logoutButton;

    @FXML
    TabPane tabPane;


    @FXML
    public void initialize() {

        setUpEventBus();
    }


    @FXML
    private void setUpEventBus() {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();

        selectionModel.selectedIndexProperty().addListener( e -> callController(selectionModel.getSelectedIndex(), selectionModel.getSelectedItem()));

        logoutButton.setOnAction(e -> loggingOut());

    }


    private void callController(int selectedTabNumber, Tab selectedTab) {

        switch (selectedTabNumber) {
            case 0:
                    break;
            case 1: //StudentTabController studentTabController = new StudentTabController();
                    //selectedTab.setContent();
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
        System.out.println();
        Stage stage = App.getStage();

        if (stage.getScene() != null) {
            stage.getScene().setRoot(new Region());
        }
        stage.setScene(new Scene(loginView.getView()));
        stage.centerOnScreen();
        stage.show();
    }



}
