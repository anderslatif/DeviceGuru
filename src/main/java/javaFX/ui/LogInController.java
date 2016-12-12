package javaFX.ui;

import javaFX.App;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LogInController {

	@Autowired
    MainTabView mainTabView;




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

		stage.setScene(new Scene(mainTabView.getView()));
		stage.setResizable(true);
		stage.centerOnScreen();
		stage.show();

	}


}
