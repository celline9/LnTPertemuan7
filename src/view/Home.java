package view;

import java.util.ArrayList;
import java.util.Observable;

import Model.AccountManagement;
import Model.User;
import Model.product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home {
    protected Stage stage;
    protected Scene scene;
    protected TableView<User> viewUser;
    protected TableView<product> viewProduct;
    protected ObservableList<product> productList;
    protected AccountManagement managementSys;
    protected BorderPane rootNode;
    protected VBox centerBox;
    protected Label current, list, productName, stock, price;
    protected Button deleteBtn, updateBtn, addBtn;
    protected product products;
    protected TextField productNameTf, stockTf, priceTf;
    ArrayList<product> productArray;

    public void init() {
        deleteBtn = new Button("Delete");
        updateBtn = new Button("Update");
        addBtn = new Button("Add");

        productNameTf = new TextField();
        stockTf = new TextField();
        priceTf = new TextField();

        centerBox = new VBox(10);
        rootNode = new BorderPane();
        productList = FXCollections.observableArrayList(); // Inisialisasi productList

        productName = new Label("Name");
        stock = new Label("Stock");
        price = new Label("Price");
        
        productArray = new ArrayList<>();
    }

    public void tableView() {
        ObservableList<User> userList = FXCollections.observableArrayList(managementSys.getUsers());
        TableColumn<product, String> nameColumn = new TableColumn<product, String>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<product, Integer> priceColumn = new TableColumn<product, Integer>("Price");
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());

        TableColumn<product, Integer> stockColumn = new TableColumn<product, Integer>("Stock");
        stockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty());

        viewProduct = new TableView<product>();
        viewProduct.setItems(productList); // Tambahkan productList ke viewProduct
        viewProduct.getColumns().addAll(nameColumn, priceColumn, stockColumn);
    }

    public void getData() {
        viewProduct.getItems().clear(); // Hapus data saat ini
        viewProduct.getItems().addAll(productArray); // Tambahkan data baru
    }

    public void eventHandler() {
        addBtn.setOnAction(event -> {
            String productInput = productNameTf.getText();
            String priceInput = priceTf.getText();
            int priceValue = Integer.parseInt(priceInput);
            String stockInput = stockTf.getText();
            int stockValue = Integer.parseInt(stockInput);

           
            productArray.add(new product(productInput, priceValue, stockValue));
            viewProduct.getItems().add(new product(productInput, priceValue, stockValue)); // Tambahkan produk baru ke viewProduct
            getData(); // Panggil getData() untuk memperbarui tabel
        });
        
        deleteBtn.setOnAction(event-> {
        	product temp = viewProduct.getSelectionModel().getSelectedItem();
        	
        	for (product product : productArray) {
				if(product.getName().equals(temp.getName())) {
					productArray.remove(product);
					break;
				}
			}
        	getData();
        });
        
        updateBtn.setOnAction(event-> {
        	 String productInput = productNameTf.getText();
             String priceInput = priceTf.getText();
             int priceValue = Integer.parseInt(priceInput);
             String stockInput = stockTf.getText();
             int stockValue = Integer.parseInt(stockInput);
             product temp = viewProduct.getSelectionModel().getSelectedItem();
             
             for (product product : productArray) {
				if(product.getName().equals(temp.getName())) {
					product.setName(productInput);
					product.setPrice(priceValue);
					product.setStock(stockValue);
					break;
				}
			}
             getData();
        });
    }
    

    public void setLayout() {
        centerBox.getChildren().addAll(productNameTf, stockTf, priceTf, viewProduct, updateBtn, deleteBtn, addBtn);
        rootNode = new BorderPane(centerBox);
    }

    public Scene getScene() {
        return scene;
    }

    public Home(Stage stage, AccountManagement managementSys) {
        this.managementSys = managementSys;
        init();
        tableView();
        setLayout();
        eventHandler();
        this.stage = stage;
        this.stage.setTitle("Home");
        this.scene = new Scene(rootNode, 600, 600);
    }
}