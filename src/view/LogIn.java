package view;


import Model.AccountManagement;
import javafx.animation.ScaleTransition;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
	import javafx.scene.layout.VBox;
	import javafx.scene.text.Font;
	import javafx.scene.text.FontWeight;
	import javafx.scene.text.Text;
	import javafx.stage.Stage;
	import javafx.util.Duration;

	public class LogIn {
		protected Scene scene;
		protected Stage stage;
		protected VBox rootNode, welcome, user, bottom;	
		protected Label welcomeLbl, subLbl, forgotPass, question;
		protected TextField usernameTf, passTf;
		protected Button submitBtn;
		protected ComboBox<String> cbox;
		protected TextArea alamat;
		
		protected AccountManagement managementSys;
		
		public void initialize() {
			rootNode = new VBox();
			bottom = new VBox();
			welcomeLbl = new Label("Welcome Back");
			welcomeLbl.setFont(Font.font(null, FontWeight.BOLD, 20));
			welcome = new VBox();
			user = new VBox();
			submitBtn = new Button("Login");
			submitBtn.setPrefHeight(30);
			submitBtn.setPrefWidth(60);
			
			forgotPass = new Label("Forgot password?");
			
			subLbl = new Label("Enter your credential to login");
			subLbl.setFont(new Font(12));
			
			question = new Label("Don't have an account? Sign Up");
			usernameTf = new TextField();
			usernameTf.setPromptText("Username");
			passTf = new TextField();
			passTf.setPromptText("Password");
			usernameTf.setPrefWidth(10);
			usernameTf.setPrefHeight(30);	
			passTf.setPrefWidth(10);
			passTf.setPrefHeight(30);	
			usernameTf.setPadding(new Insets(5, 10, 5, 10));
			passTf.setPadding(new Insets(5, 10, 5, 10));
		}
		
		public void setLayout() {
			welcome.setAlignment(Pos.CENTER);
			welcome.setPadding(new Insets(50, 0, 50, 0));
			user.setAlignment(Pos.CENTER);
			user.setSpacing(10);
			user.setPadding(new Insets(0, 100, 0, 100));
			welcome.getChildren().addAll(welcomeLbl, subLbl);
			user.getChildren().addAll(usernameTf, passTf, submitBtn);
			
			bottom.setAlignment(Pos.CENTER);
			bottom.getChildren().addAll(forgotPass, question);
			bottom.setPadding(new Insets(100, 0, 0, 0));
			bottom.setSpacing(40);
			rootNode.getChildren().addAll(welcome, user, bottom);
		}
		
		public void eventHandler() {
			//efek hover
			submitBtn.setOnMouseEntered(e -> {
				submitBtn.setScaleX(1.1);
				submitBtn.setScaleY(1.1);
			});
			submitBtn.setOnMouseExited(e -> {
				submitBtn.setScaleX(1);
				submitBtn.setScaleY(1);
			});
			submitBtn.setOnAction(event-> {
				String usernameInput = usernameTf.getText();
				String passInput = passTf.getText();
				
				boolean attemptLogin = managementSys.login(usernameInput, passInput);
				if(attemptLogin) {
					System.out.println("Login is successfull");
					Home home = new Home(stage, managementSys);
					Scene homeScene = home.getScene();
					stage.setScene(homeScene);
				} else {
					System.out.println("Login is failed!");
				}
				
				ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), submitBtn);
				scaleTransition.setFromX(1);
				scaleTransition.setFromY(1);
				scaleTransition.setToX(1.5);
			    scaleTransition.setToY(1.5);
			    scaleTransition.setCycleCount(2);
			    scaleTransition.setAutoReverse(true);
			    scaleTransition.play();
			});
			
		}
		
		
		public Scene getScene() {
			return scene;
		}
		
		public LogIn(Stage stage, AccountManagement managementSys) {
			this.managementSys = managementSys;
			initialize();
			setLayout();
			eventHandler();
			this.stage = stage;
			this.scene = new Scene(rootNode, 600, 600);
			this.stage.setTitle("LogIn Page");
			
		}
	
}
