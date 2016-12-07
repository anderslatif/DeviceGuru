package javaFX.ui;

import javaFX.App;
import javaFX.models.Assignment.Assignment;
import javaFX.models.Assignment.AssignmentService;
import javaFX.models.Login.Login;
import javaFX.models.Login.LoginService;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LogInController {

	@Autowired
	StudentTabView studentTabView;




	@FXML
	private Button loginbutton;

	@FXML
	public void initialize() {

		loginbutton.setOnAction( e -> logInButtonClicked());
	}

	/**
	 * This is the login authorization method
	 */
	private void logInButtonClicked() {

		Stage stage = App.getStage();

		stage.setScene(new Scene(studentTabView.getView()));
		stage.setResizable(true);
		stage.centerOnScreen();
		stage.show();

	}






}
