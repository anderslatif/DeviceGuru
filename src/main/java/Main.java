import com.sun.javafx.application.LauncherImpl;
import entityModels.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repControllers.EmployeeController;
import view.LoginController;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan
public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
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
		primaryStage.show();
	}

}
