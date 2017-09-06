package View;

import Controleur.MainApp;
import Model.Prospect;
import Model.Representant;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class RepresentantFrameController {
	
	@FXML
	private TableView<Representant> RepresentantTable;
	@FXML
	private TableColumn<Representant, String>NomColumnn;
	@FXML
	private TableColumn<Representant, String>prenomColumn;
	@FXML
	private TableColumn<Representant, String> numVrpColumn;
	@FXML
	private TableColumn<Representant, String>RegionColumn;

	@FXML
	private Label  nom;
	@FXML
	private Label  prenom;
	@FXML
	private Label  numVrp;
	@FXML
	private Label  salaire;
	@FXML
	private Label  commission;
	@FXML
	private Label  email;
	@FXML
	private Label  telephone;
	@FXML
	private Label  region;
	
	private MainApp mainApp;
	
	@FXML
	private void initialize(){
		NomColumnn.setCellValueFactory(cellData->cellData.getValue().nomVrpProperty());
		prenomColumn.setCellValueFactory(cellData->cellData.getValue().prenomVrpProperty());
		numVrpColumn.setCellValueFactory(cellData->cellData.getValue().numVrpProperty());
		RegionColumn.setCellValueFactory(cellData->cellData.getValue().regionVrpProperty());
		
		System.out.println("showVrpDetails(null)");
		showVrpDetails(null);
		
		RepresentantTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showVrpDetails(newValue));
	}// end Initialize
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
		RepresentantTable.setItems(MainApp.getVrp());}
	
	private void showVrpDetails(Representant vrp){
		if(vrp !=null){
			nom.setText(vrp.getNomVrp());
			prenom.setText(vrp.getPrenomVrp());
			numVrp.setText(vrp.getNumVrp());
			
			email.setText(vrp.getMailVrp());
			telephone.setText(vrp.getTelVrp());
			region.setText(vrp.getregionVrp());
			salaire.setText(Integer.toString(vrp.getSalaireVrp()));
			commission.setText(Integer.toString(vrp.getCommVrp()));}
		else{
			nom.setText("");
			prenom.setText("");
			numVrp.setText("");
			salaire.setText("");
			commission.setText("");
			email.setText("");
			telephone.setText("");
			region.setText("");}
	} //end showVrpDertails
	
	//********************** Nouveau Representant 	**********************//
	
		@FXML
		void handleNewProspect(){
			System.out.println("Test Nouveau Representant");
			Representant tempRepresentant = new Representant();
			boolean okClicked = mainApp.showEditDialogVrp(tempRepresentant);
			if (okClicked){
				MainApp.getVrp().add(tempRepresentant);
			}
		}
	
		//********************** Editer Prospect **********************//
		
		@FXML
		void handleEditVrp(){
			Representant selectVrp = RepresentantTable.getSelectionModel().getSelectedItem();
			if(selectVrp != null){
				boolean okClicked = mainApp.showEditDialogVrp(selectVrp);
				if(okClicked){
					showVrpDetails(selectVrp);		
					}
			}
			else
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(mainApp.getPrimaryStage());
				alert.setTitle("Aucune Selection");
				alert.setHeaderText("Aucune données Selectionnées");
				alert.setContentText("Veuillez selectionner une société");
				
				alert.showAndWait();
			}
		}
			
		//********************** Supprimer Prospect 	**********************//
		
		@FXML
		void handleDeleteRepresentant() {
			    int selectedIndex = RepresentantTable.getSelectionModel().getSelectedIndex();
			    if (selectedIndex >= 0) {
			    	RepresentantTable.getItems().remove(selectedIndex);
			    } else {
			        // Nothing selected.
			        Alert alert = new Alert(AlertType.WARNING);
			        alert.initOwner(mainApp.getPrimaryStage());
			        alert.setTitle("Erreur");
			        alert.setHeaderText("Aucune donnée séléctionnée");
			        alert.setContentText("Merci de séléctionner une donnée.");

			        alert.showAndWait();}}
		
	
} //end Classe
