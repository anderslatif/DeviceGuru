package javaFX.ui;

import javaFX.App;
import javaFX.models.Login.LoginService;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


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

		boolean loginCheck = loginService.findAllLogins().stream()
				.anyMatch(login -> login.getUsername().equals(username.getText())&& login.getPassword().equals(password.getText()));

		if (loginCheck) {
			Stage stage = App.getStage();

			stage.setScene(new Scene(mainTabView.getView()));
			stage.setMaximized(true);
			stage.centerOnScreen();
			stage.show();
		} else {
			Label messageLabel = new Label("Wrong log in credentials");
			rootBorderPane.setTop(messageLabel);
		}
	}


}
