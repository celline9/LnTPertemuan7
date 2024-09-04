package view;

import Model.AccountManagement;
import Model.User;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignUp {
	protected Scene scene;
	protected Stage stage;
	protected VBox top;
	protected FlowPane name, answer, genders;
	protected GridPane a;
	protected Label signUp, firstN, lastN, address, zodiac1, username, password, email;
	protected TextField first, last, username2, email2;
	protected PasswordField password2;
	protected TextArea address2;
	protected ComboBox<String> zodiac;
	protected RadioButton male, female, neutral;
	protected ToggleGroup gender;
	protected Button signUpbtn;
	
	AccountManagement managementSys= new AccountManagement();
	
	public void initialize() {
		answer = new FlowPane();
		name = new FlowPane();
		top = new VBox();
		
		signUp = new Label("Sign Up");
		zodiac1 = new Label("Zodiac");
		
		firstN = new Label("First Name");
		lastN = new Label("Last Name");
		first = new TextField();
		last = new TextField();
		
		address = new Label("Address");
		address2 = new TextArea();
	
		zodiac = new ComboBox<String>();
		zodiac.getItems().addAll("Sagittarius", "Gemini", "Libra");
		zodiac.getSelectionModel().selectFirst();
		
		genders = new FlowPane();
		gender = new ToggleGroup();
		male = new RadioButton("Male");
		female = new RadioButton("Female");
		neutral = new RadioButton("Rather not say");
		male.setToggleGroup(gender);
		female.setToggleGroup(gender);
		neutral.setToggleGroup(gender);
		
		username = new Label("Username");
		username2 = new TextField();
		username2.setMaxSize(180, 30);
	
		password = new Label("Password");
		password2 = new PasswordField();
		password2.setMaxSize(180, 30);	
		
		email = new Label("Email");
		email2 = new TextField();
		email2.setMaxSize(180, 30);
		
		signUpbtn = new Button("Sign Up");
	}
	
	public void setLayout() {
		signUp.setPadding(new Insets(0, 100, 0, 100));
//		address2.setPadding(new Insets(0, 100, 0 ,100));
//		address2.setMinSize(300, 50);
//		address2.setPrefSize(300, 40);
		address2.setMaxSize(350, 80);
		signUp.setFont(Font.font("null", FontWeight.BOLD, 20));
		name.getChildren().addAll(firstN, lastN);
		name.setHgap(120);

		answer.getChildren().addAll(first, last);
		answer.setHgap(30);
		
		genders.getChildren().addAll(male, female, neutral);
		genders.setHgap(10);

		top.getChildren().addAll(signUp, name, answer, address, address2, zodiac1, zodiac
			,genders, username, username2, password, password2, email, email2, signUpbtn);
		top.setSpacing(10);
		top.setPadding(new Insets(0, 15, 0, 15));
	}
	
	public void eventHandler() {
		signUpbtn.setOnAction(event-> {
			String usernameInput = username2.getText();
//			String emailInput = email2.getText();
			String passwordInput = password2.getText();
			
			User users = new User(usernameInput, passwordInput);
			managementSys.SignUp(users);
			System.out.println("Sign Up is successful");
			
			LogIn loginPage = new LogIn(stage, managementSys);
			Scene loginScene = loginPage.getScene();
			stage.setScene(loginScene);
		});
	}
	
	
	public Scene getScene() {
		return scene;
	}
	
	public SignUp(Stage stage, AccountManagement managementSys) {
		initialize();
		setLayout();
		eventHandler();
		this.managementSys = managementSys;
		this.stage = stage;
		this.scene = new Scene(top, 600, 600);
		this.stage.setTitle("LogIn Page");
		
	}
	
}


