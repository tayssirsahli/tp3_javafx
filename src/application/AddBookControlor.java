package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Window;
import javafx.util.Callback;

public class AddBookControlor implements Initializable{

    @FXML
    private TextField nom_id;

    @FXML
    private TextField email_id;

    @FXML
    private TextField prenom_id;

    @FXML
    private Button ajouterBtn;

    @FXML
    private TableColumn<Person, String> nomT_id;

    @FXML
    private TableColumn<Person, String> prenomT_id;

    @FXML
    private TableColumn<Person, String> emailT_id;

    @FXML
    private Button quiterBtn;

    @FXML
    private Button supprimerbtn;

    @FXML
    private Button importerbtn;

    @FXML
    private Button exporterbtn;
    @FXML
    private TableView<Person> table;
    
    private DataClass data;
    
    
    public static boolean isEmailAdress(String email){
    	Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$" );
    	Matcher m = p.matcher(email.toUpperCase());
    	return m.matches();
    	}

    @FXML
    void ajouter(ActionEvent event) {
    	if( nom_id.getText().isEmpty() && prenom_id.getText().isEmpty() && email_id.getText().isEmpty() )
    	{Window owner = ajouterBtn.getScene().getWindow();
		Alert alert = new Alert(AlertType.ERROR);
		 alert.setTitle("Form Error!");
		 alert.setHeaderText(null);
		 alert.setContentText("remplir tout les champs !");
		 alert.initOwner(owner);
		 alert.show();
    	
    	}else if(isEmailAdress(email_id.getText())==false) {
    		Window owner = ajouterBtn.getScene().getWindow();
    		Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("Form Error!");
			 alert.setHeaderText(null);
			 alert.setContentText(email_id.getText() +" : Email incorrect !");
			 alert.initOwner(owner);
			 alert.show();
    	}
    	else {
    		String nom = nom_id.getText();
        	String prenom = prenom_id.getText();
        	String email = email_id.getText();
        	
        	table.getItems().add(new Person(nom,prenom,email));
    	}
    	
    	}

   
    @FXML
    void exporter(ActionEvent event) {
    	List<Person> p =table.getItems();
    	data.setExportlist(p);
    	System.out.println(data.getExportlist());
    	
    	}

    @FXML
    void importer(ActionEvent event) {
    	
    	
    	for(Person p :data.getImportlist())
    	{
    		table.getItems().add(p);

    	}
			
    	
    	
    }

    @FXML
    void quiter(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void supprimer(ActionEvent event) {
    	Person selectedItem = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(selectedItem);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		table.setEditable(true);// Set the TableView to be editable
		nomT_id.setCellValueFactory(new PropertyValueFactory("nom"));
		prenomT_id.setCellValueFactory(new PropertyValueFactory("prenom"));
		emailT_id.setCellValueFactory(new PropertyValueFactory("email"));

		nomT_id.setCellFactory(TextFieldTableCell.forTableColumn());
	    prenomT_id.setCellFactory(TextFieldTableCell.forTableColumn());
	    emailT_id.setCellFactory(TextFieldTableCell.forTableColumn());
		data = new DataClass();
		
	}

	
}
