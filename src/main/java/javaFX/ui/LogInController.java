package javaFX.ui;

import javaFX.App;
import javaFX.models.Login.LoginService;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LogInController {

	@Autowired
    MainTabView mainTabView;

	@Autowired
	LoginService loginService;

	@FXML
	private BorderPane rootBorderPane;

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Button loginbutton;

	@FXML
	public void initialize() {

		loginbutton.setOnAction( e -> logInButtonClicked());
		allowPressEnterToLogin();
	}

	private void allowPressEnterToLogin() {
		rootBorderPane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER)
				logInButtonClicked();
		});
	}


	/**
	 * This is the login authorization method
	 */
	private void logInButtonClicked() {

		if (loginService.authenticateUser(username.getText(), password.getText()) != null) {
			Stage stage = App.getStage();

			if (stage.getScene() != null) {
				stage.getScene().setRoot(new Region());
			}
			stage.setScene(new Scene(mainTabView.getView()));
			stage.setMaximized(true);
			stage.centerOnScreen();
			stage.show();

			// set empty string in fields to avoid them remembering your login after you log out and the application is still running
			// I choose to clear it here since it won't be used anymore, keeping it in the logincontroller seems logical
			// and these two lines will run parallel with stage.show() above
			username.setText("");
			password.setText("");
		} else {
			Label messageLabel = new Label("Wrong login credentials");
			rootBorderPane.setTop(messageLabel);
		}
	}


}
