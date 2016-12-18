package javaFX;

import javaFX.ui.LoginView;
import javaFX.ui.MainTabView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class App extends AbstractJavaFxApplicationSupport {

	@Value("DeviceGuru")
	private String windowTitle;

	@Autowired
	LoginView loginView;

	@Autowired
	MainTabView mainTabView; //todo debug

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;

		stage.setTitle(windowTitle);
//		stage.setScene(new Scene(loginView.getView()));
		stage.setScene(new Scene(mainTabView.getView())); //todo debug
		stage.setMaximized(true); //todo debug
//		stage.centerOnScreen();
		BorderPane borderPane = (BorderPane) stage.getScene().getRoot(); //todo debug
		TabPane tabPane = (TabPane) borderPane.getCenter(); //todo debug
		SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel(); //todo debug
		selectionModel.select(1); //todo debug
		stage.show();
	}

	public static void main(String[] args) {
		launchApp(App.class, args);
	}


	static Stage stage;

	public static Stage getStage() {
		return stage;
	}
}
