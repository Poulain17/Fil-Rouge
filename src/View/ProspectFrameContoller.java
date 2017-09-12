package View;

import java.io.File;

/**
 * Classe de controle de la fenetre Prospect
 * 
 * @author Pauline G.
 */

import Controleur.MainApp;
import Model.Client;
import Model.Prospect;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ProspectFrameContoller {
	

	@FXML
	private TableView<Prospect> prospectTable;
	@FXML
	private TableColumn<Prospect, String>raisonSocialeColumn;
	@FXML
	private TableColumn<Prospect, Integer>sirenColumn;
	@FXML
	private TableColumn<Prospect, Integer>regionColumn;
	@FXML
	private TableColumn<Prospect, String>VrpColumn;


	@FXML
	private Label numProspect;
	@FXML
	private Label  raisonSociale;
	@FXML
	private Label  siren;
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
	
	public static int PtoC = 0;
	public static Prospect selectProspect;

	
	
	private MainApp mainApp;



	public ProspectFrameContoller(){}
	
	@FXML
	private void initialize(){
	raisonSocialeColumn.setCellValueFactory(cellData->cellData.getValue().raisonSocialeProperty());
	sirenColumn.setCellValueFactory(cellData->cellData.getValue().sirenProperty().asObject());
	regionColumn.setCellValueFactory(cellData->cellData.getValue().indexRegionProperty().asObject());
	VrpColumn.setCellValueFactory(cellData->cellData.getValue().numVrpProperty());
	
	showProspectDetails(null);

	prospectTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showProspectDetails(newValue));
	
	}// end initialize
	
		
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	prospectTable.setItems(mainApp.getProspectData());}


	private void showProspectDetails(Prospect prospect){
		int i;
		int ir;

		if(prospect !=null){
			
			numProspect.setText(Integer.toString(prospect.getNumProspect()));
			raisonSociale.setText(prospect.getRaisonSociale());
			siren.setText(Integer.toString(prospect.getSiren()));
			numVoie.setText(Integer.toString(prospect.getNumVoie()));
			voie.setText(prospect.getVoie());
			typeVoie.setText(prospect.getTypeVoie());
			complement.setText(prospect.getComplement());
			codePostal.setText(prospect.getCodePostal());
			ville.setText(prospect.getVille());
			nom.setText(prospect.getNom());
			prenom.setText(prospect.getPrenom());
			mail.setText(prospect.getMail());
			tel.setText(prospect.getTel());
			numVrp.setText(mainApp.getRepresentant(prospect.getTel()).getNumVrp());
			nomVrp.setText(mainApp.getRepresentant(prospect.getTel()).getNomVrp());
			prenomVrp.setText(mainApp.getRepresentant(prospect.getTel()).getPrenomVrp());
			regionVrp.setText(mainApp.getRepresentant(prospect.getTel()).getregionVrp());

			
			ir=prospect.getIndexRegion();
			region.setText(Integer.toString(ir)+" - " + mainApp.getRegionBoxData().get(ir-1).getRegionBox());

			nbCommande.setText(Integer.toString(prospect.getNbCommande()));
			
		}else{
			numProspect.setText("");
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
			region.setText("");
			nom.setText("");
			prenom.setText("");
			mail.setText("");
			numVrp.setText("");
			nomVrp.setText("");
			prenomVrp.setText("");
			regionVrp.setText("");}}

			
	
	
	//********************** Nouveau Prospect 	**********************//
	
	@FXML
	void handleNewProspect(){
		System.out.println("Test Nouveau Client");
		Prospect tempProspect = new Prospect();
		boolean okClicked = mainApp.showEditDialogProspect(tempProspect);
		if (okClicked){
			mainApp.getProspectData().add(tempProspect);
		}
	}
	
	//********************** Editer Prospect **********************//
	
	@FXML
	void handleEditProspect(){
		Prospect selectProspect = prospectTable.getSelectionModel().getSelectedItem();
		if(selectProspect != null){
			boolean okClicked = mainApp.showEditDialogProspect(selectProspect);
			if(okClicked){
				showProspectDetails(selectProspect);		
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
		
	//********************** Supprimer Prospect 	**********************//

	@FXML
	void handleDeleteProsepect() {
		    int selectedIndex = prospectTable.getSelectionModel().getSelectedIndex();
		    if (selectedIndex >= 0) {
		        prospectTable.getItems().remove(selectedIndex);
		    } else {
		        // Nothing selected.
		        Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(mainApp.getPrimaryStage());
		        alert.setTitle("Erreur");
		        alert.setHeaderText("Aucune donn�e s�l�ctionn�e");
		        alert.setContentText("Merci de s�l�ctionner une donn�e.");

		        alert.showAndWait();}
		    
		} //end handleDeleteProspect

	
}//end prospectFrameController
