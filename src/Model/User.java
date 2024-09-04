package Model;

import javafx.beans.property.SimpleStringProperty;

public class User {
	protected String username;
	protected String email;
	protected String password;
	
	public User(String username, String password) {
		super();
		this.username = username;
//		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public SimpleStringProperty username() {
		return new SimpleStringProperty(username);
	}
	
	public SimpleStringProperty password() {
		return new SimpleStringProperty(password);
	}
	
	
}
