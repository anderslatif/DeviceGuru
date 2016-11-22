import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.LoginController;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 300, 250);

		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();


		/*
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Login.fxml"));

		Map<String, Object> session = new HashMap<String, Object>();
		session.put("root_loader", loader);
		LoginController mainController = new LoginController(session);
		loader.setController(mainController);
		BorderPane root = loader.load();



		primaryStage.setTitle("DeviceManager");
		Scene scene = new Scene(root);
		//primaryStage.getIcons().add(new Image("images/Logo.png"));
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();*/
	}

}
