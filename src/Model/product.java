package Model;

import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class product {
	protected String name;
	protected int price;
	protected int stock;
	public static ArrayList<product> productList;
	public product(String name, int price, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.productList = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public StringProperty nameProperty() {
		return new SimpleStringProperty(name);
	}
	
	public ObjectProperty<Integer> priceProperty() {
	    return new SimpleIntegerProperty(price).asObject();
	}	
	
	public ObjectProperty<Integer> stockProperty() {
		return new SimpleIntegerProperty(stock).asObject();
	}
	
	public void addProduct(product products) {
		productList.add(products);
	}
	public ArrayList<product> getProductList() {
		return productList;
	}
	public void setProductList(ArrayList<product> productList) {
		this.productList = productList;
	}
			
}
