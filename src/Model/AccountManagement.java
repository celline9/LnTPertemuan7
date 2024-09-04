package Model;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.beans.property.SimpleStringProperty;

public class AccountManagement {
	protected ArrayList<User>Users;
	protected User activeUsers;
	public AccountManagement() {
		super();
		this.Users = new ArrayList<>();
	}
	public ArrayList<User> getUsers() {
		return Users;
	}
	public void setUsers(ArrayList<User> users) {
		Users = users;
	}
	public User getActiveUsers() {
		return activeUsers;
	}
	public void setActiveUsers(User activeUsers) {
		this.activeUsers = activeUsers;
	}
	
	public boolean login(String username, String password) {
		for (User user : Users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				this.activeUsers = user;
				return true;
			}
		}
		return false;
	}
	
	public void SignUp(User user) {
		Users.add(user);
	}
	
	
}
