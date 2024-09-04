package application;
	
import Model.AccountManagement;
import javafx.application.Application;
import javafx.stage.Stage;
import view.Home;
import view.SignUp;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

// testing 123
public class Main extends Application {
	public AccountManagement managementSys = new AccountManagement();
	
	public AccountManagement getManagementSys() {
		return managementSys;
	}

	@Override
	public void start(Stage stage) {
//		SignUp SignUp = new SignUp(stage, managementSys);
		Home home = new Home(stage, managementSys);
		stage.setScene(home.getScene());
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
