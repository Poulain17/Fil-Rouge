package View;

import Controleur.MainApp;
import Model.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class ClientFrameController {
	
	@FXML
	private TableView<Client> ClientTable;
	@FXML
	private TableColumn<Client, String>raisonSocialeColumn;
	@FXML
	private TableColumn<Client, Integer>sirenColumn;
	@FXML
	private TableColumn<Client, Integer>numClientColumn;
	@FXML
	private TableColumn<Client, String>VrpColumn;


	@FXML
	private Label numClient;
	@FXML
	private Label  raisonSociale;
	@FXML
	private Label  siren;
	@FXML
	private Label  idCompany;
	@FXML
	private Label  numVoie;
	@FXML
	private Label  typeVoie;
	@FXML
	private Label  voie;
	@FXML
	private Label  complement;
	@FXML
	private Label  codePostal;
	@FXML
	private Label  ville;
	@FXML
	private Label  region;
	@FXML
	private Label  nom;
	@FXML
	private Label  prenom;
	@FXML
	private Label  mail;
	@FXML
	private Label  tel;
	@FXML
	private Label  nomVrp;
	@FXML
	private Label  prenomVrp;
	@FXML
	private Label  regionVrp;
	@FXML
	private Label numVrp;
	@FXML
	private Label nbCommande;

	
	
	private MainApp mainApp;
	public static boolean presser;
	
	public static boolean isPresser(){
		return presser;
		
	}




	public ClientFrameController(){}
	
	@FXML
	private void initialize(){
	numClientColumn.setCellValueFactory(cellData->cellData.getValue().numClientProperty().asObject());
	raisonSocialeColumn.setCellValueFactory(cellData->cellData.getValue().raisonSocialeProperty());
	sirenColumn.setCellValueFactory(cellData->cellData.getValue().sirenProperty().asObject());
	VrpColumn.setCellValueFactory(cellData->cellData.getValue().numVrpProperty());
	
	
	showClientDetails(null);

	ClientTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showClientDetails(newValue));
	
	}// end initialize
	
		
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;

		ClientTable.setItems(mainApp.getClientData());}


	
	
	private void showClientDetails(Client client){
		int ir;
		
			///////////////// Donn�e creer depuis Client \\\\\\\\\\\\\\\\\
		if(client !=null){
			numClient.setText(Integer.toString(client.getNumClient()));
			raisonSociale.setText(client.getRaisonSociale());
			siren.setText(Integer.toString(client.getSiren()));
			numVoie.setText(Integer.toString(client.getNumVoie()));
			voie.setText(client.getVoie());
			typeVoie.setText(client.getTypeVoie());
			complement.setText(client.getComplement());
			codePostal.setText(client.getCodePostal());
			ville.setText(client.getVille());
			region.setText(Integer.toString(client.getIndexRegion()));
			nom.setText(client.getNom());
			prenom.setText(client.getPrenom());
			mail.setText(client.getMail());
			tel.setText(client.getTel());
			nbCommande.setText(Integer.toString(client.getNbCommande()));
			System.out.println(client.getNumVrp());
			numVrp.setText(client.getNumVrp());
			System.out.println(mainApp.getRepresentant(client.getNumVrp()).getNomVrp());
			nomVrp.setText(mainApp.getRepresentant(client.getNumVrp()).getNomVrp());
			
			prenomVrp.setText(mainApp.getRepresentant(client.getNumVrp()).getPrenomVrp());
			regionVrp.setText(mainApp.getRepresentant(client.getNumVrp()).getregionVrp());
			
	
			ir=client.getIndexRegion();
			region.setText(Integer.toString(ir)+" - " + mainApp.getRegionBoxData().get(ir-1).getRegionBox());		
			
		}else{
			numClient.setText("");
			typeVoie.setText("");
			region.setText("");
			raisonSociale.setText("");
			siren.setText("");
			numVoie.setText("");
			typeVoie.setText("");
			voie.setText("");
			complement.setText("");
			codePostal.setText("");
			ville.setText("");
			nom.setText("");
			prenom.setText("");
			mail.setText("");
			nbCommande.setText("");
			numVrp.setText("");
			nomVrp.setText("");
			prenomVrp.setText("");
			regionVrp.setText("");}}
			
	
	
	//********************** Nouveau Client 	**********************//
	
	@FXML

	void handleNewClient(){
		System.out.println("Test Nouveau Client");
		Client tempClient = new Client();
		boolean okClicked = mainApp.showEditDialogClient(tempClient);
		if (okClicked){
			mainApp.getClientData().add(tempClient);
		}
	}
	
	//********************** Editer Client **********************//
	
	@FXML
	void handleEditClient(){
		Client selectClient = ClientTable.getSelectionModel().getSelectedItem();
		if(selectClient != null){
			boolean okClicked = mainApp.showEditDialogClient(selectClient);
			if(okClicked){
				showClientDetails(selectClient);		
				}
		}
		else
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Aucune Selection");
			alert.setHeaderText("Aucune donn�es Selectionn�es");
			alert.setContentText("Veuillez selectionner une soci�t�");
			
			alert.showAndWait();
		}
	}
		
	//********************** Supprimer Client 	**********************//
	
	@FXML
	void handleDeleteClient() {
		    int selectedIndex = ClientTable.getSelectionModel().getSelectedIndex();
		    if (selectedIndex >= 0) {
		    	ClientTable.getItems().remove(selectedIndex);
		    } else {
		        // Nothing selected.
		        Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(mainApp.getPrimaryStage());
		        alert.setTitle("Erreur");
		        alert.setHeaderText("Aucune donn�e s�l�ctionn�e");
		        alert.setContentText("Merci de s�l�ctionner une donn�e.");

		        alert.showAndWait();
		    }
		}
	
	//********************** Transfert de collections 	**********************//

	
	
}//end prospectFrameController

