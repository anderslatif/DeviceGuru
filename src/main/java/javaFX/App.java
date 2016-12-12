package javaFX;

import javaFX.ui.LoginView;
import javafx.scene.Scene;
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

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;

		stage.setTitle(windowTitle);
		stage.setScene(new Scene(loginView.getView()));
		stage.centerOnScreen();
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
