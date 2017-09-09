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
	private TableColumn<Client, Integer>regionColumn;
	@FXML
	private TableColumn<Client, String>VrpColumn;


	
	@FXML
	private Label  type;
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
	raisonSocialeColumn.setCellValueFactory(cellData->cellData.getValue().raisonSocialeProperty());
	sirenColumn.setCellValueFactory(cellData->cellData.getValue().sirenProperty().asObject());
	regionColumn.setCellValueFactory(cellData->cellData.getValue().indexRegionProperty().asObject());
	VrpColumn.setCellValueFactory(cellData->cellData.getValue().numVrpProperty());
	
	
	showClientDetails(null);

	ClientTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showClientDetails(newValue));
	
	}// end initialize
	
		
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;

		ClientTable.setItems(mainApp.getClientData());}


	
	
	private void showClientDetails(Client client){
		int i;
		int ir;
		if(ProspectFrameContoller.PtoC ==1){
			raisonSociale.setText(ProspectFrameContoller.selectProspect.getRaisonSociale());
			siren.setText(Integer.toString(ProspectFrameContoller.selectProspect.getSiren()));
			idCompany.setText(Integer.toString(ProspectFrameContoller.selectProspect.getIdCompany()));
			numVoie.setText(Integer.toString(ProspectFrameContoller.selectProspect.getNumVoie()));
			typeVoie.setText(ProspectFrameContoller.selectProspect.getTypeVoie());
			voie.setText(ProspectFrameContoller.selectProspect.getVoie());
			complement.setText(ProspectFrameContoller.selectProspect.getComplement());
			codePostal.setText(ProspectFrameContoller.selectProspect.getCodePostal());
			ville.setText(ProspectFrameContoller.selectProspect.getVille());
			type.setText(Integer.toString(ProspectFrameContoller.selectProspect.getIndexType()));
			region.setText(Integer.toString(ProspectFrameContoller.selectProspect.getIndexRegion()));
			nom.setText(ProspectFrameContoller.selectProspect.getNom());
			prenom.setText(ProspectFrameContoller.selectProspect.getPrenom());
			mail.setText(ProspectFrameContoller.selectProspect.getMail());
			tel.setText(ProspectFrameContoller.selectProspect.getTel());
			numVrp.setText(ProspectFrameContoller.selectProspect.getRepresentant().getNumVrp());
			nomVrp.setText(ProspectFrameContoller.selectProspect.getRepresentant().getNomVrp());
			prenomVrp.setText(ProspectFrameContoller.selectProspect.getRepresentant().getPrenomVrp());
			regionVrp.setText(ProspectFrameContoller.selectProspect.getRepresentant().getregionVrp());
			
			i=ProspectFrameContoller.selectProspect.getIndexType();
			type.setText(Integer.toString(i)+" - "+mainApp.getTypeBoxData().get(i-1).getTypeBox());
			ir=ProspectFrameContoller.selectProspect.getIndexRegion();
			region.setText(Integer.toString(ir)+" - " + mainApp.getRegionBoxData().get(ir-1).getRegionBox());
			
			nbCommande.setText(Integer.toString(ProspectFrameContoller.selectProspect.getNbCommande()));
		}else{
		
		
		if(client !=null){
			raisonSociale.setText(client.getRaisonSociale());
			siren.setText(Integer.toString(client.getSiren()));
			idCompany.setText(Integer.toString(client.getIdCompany()));
			numVoie.setText(Integer.toString(client.getNumVoie()));
			typeVoie.setText(client.getTypeVoie());
			voie.setText(client.getVoie());
			complement.setText(client.getComplement());
			codePostal.setText(client.getCodePostal());
			ville.setText(client.getVille());
			type.setText(Integer.toString(client.getIndexType()));
			region.setText(Integer.toString(client.getIndexRegion()));
			nom.setText(client.getNom());
			prenom.setText(client.getPrenom());
			mail.setText(client.getMail());
			tel.setText(client.getTel());
			numVrp.setText(client.getRepresentant().getNumVrp());
			nomVrp.setText(client.getRepresentant().getNomVrp());
			prenomVrp.setText(client.getRepresentant().getPrenomVrp());
			regionVrp.setText(client.getRepresentant().getregionVrp());
		
			
			i=client.getIndexType();
			type.setText(Integer.toString(i)+" - "+mainApp.getTypeBoxData().get(i-1).getTypeBox());

			ir=client.getIndexRegion();
			region.setText(Integer.toString(ir)+" - " + mainApp.getRegionBoxData().get(ir-1).getRegionBox());
			
			nbCommande.setText(Integer.toString(client.getNbCommande()));
		}else{
			type.setText("");
			region.setText("");
			raisonSociale.setText("");
			siren.setText("");
			idCompany.setText("");
			numVoie.setText("");
			typeVoie.setText("");
			voie.setText("");
			complement.setText("");
			codePostal.setText("");
			ville.setText("");
			nom.setText("");
			prenom.setText("");
			mail.setText("");
			numVrp.setText("");
			nomVrp.setText("");
			prenomVrp.setText("");
			regionVrp.setText("");}}}
			
	
	
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
			alert.setHeaderText("Aucune données Selectionnées");
			alert.setContentText("Veuillez selectionner une société");
			
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
		        alert.setHeaderText("Aucune donnée séléctionnée");
		        alert.setContentText("Merci de séléctionner une donnée.");

		        alert.showAndWait();
		    }
		}
	
	//********************** Transfert de collections 	**********************//

	
	
}//end prospectFrameController

