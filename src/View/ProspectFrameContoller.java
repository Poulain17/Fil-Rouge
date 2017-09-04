package View;

import org.omg.Messaging.SyncScopeHelper;

/**
 * Classe de controle de la fenetre Prospect
 * 
 * @author Pauline G.
 */

import Controleur.MainApp;
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
	private TableColumn<Prospect, String>regionColumn;
	@FXML
	private TableColumn<Prospect, String>VrpColumn;


	
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

	
	
	private MainApp mainApp;


	public ProspectFrameContoller(){}
	
	@FXML
	private void initialize(){
	raisonSocialeColumn.setCellValueFactory(cellData->cellData.getValue().raisonSocialeProperty());
	sirenColumn.setCellValueFactory(cellData->cellData.getValue().sirenProperty().asObject());
	regionColumn.setCellValueFactory(cellData->cellData.getValue().regionProperty());
	VrpColumn.setCellValueFactory(cellData->cellData.getValue().numVrpProperty());
	
	showProspectDetails(null);

	prospectTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showProspectDetails(newValue));
	
	}// end initialize
	
		
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;

	prospectTable.setItems(mainApp.getProspectData());}


	
	
	private void showProspectDetails(Prospect prospect){
		int i;
		if(prospect !=null){
			raisonSociale.setText(prospect.getRaisonSociale());
			siren.setText(Integer.toString(prospect.getSiren()));
			idCompany.setText(Integer.toString(prospect.getIdCompany()));
			numVoie.setText(Integer.toString(prospect.getNumVoie()));
			typeVoie.setText(prospect.getTypeVoie());
			voie.setText(prospect.getVoie());
			complement.setText(prospect.getComplement());
			codePostal.setText(prospect.getCodePostal());
			ville.setText(prospect.getVille());
			region.setText(prospect.getRegion());
			nom.setText(prospect.getNom());
			prenom.setText(prospect.getPrenom());
			mail.setText(prospect.getMail());
			tel.setText(prospect.getTel());
			numVrp.setText(prospect.getRepresentant().getNumVrp());
			nomVrp.setText(prospect.getRepresentant().getNomVrp());
			prenomVrp.setText(prospect.getRepresentant().getPrenomVrp());
			regionVrp.setText(prospect.getRepresentant().getregionVrp());
			
			i=prospect.getIndexTypeBox();
			type.setText(Integer.toString(i)+" "+mainApp.getTypeBoxData().get(i-1).getTypeBox());

		}else{
			type.setText("");
			raisonSociale.setText("");
			siren.setText("");
			idCompany.setText("");
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
		Prospect tempSociete = new Prospect();
		boolean okClicked = mainApp.showEditDialog(tempSociete);
		if (okClicked){
			mainApp.getProspectData().add(tempSociete);
		}
	}
	
	//********************** Editer Prospect **********************//
	
	@FXML
	void handleEditProspect(){
		Prospect selectProspect = prospectTable.getSelectionModel().getSelectedItem();
		if(selectProspect != null){
			boolean okClicked = mainApp.showEditDialog(selectProspect);
			if(okClicked){
				showProspectDetails(selectProspect);		
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
	void handleDeleteProsepect() {
		    int selectedIndex = prospectTable.getSelectionModel().getSelectedIndex();
		    if (selectedIndex >= 0) {
		        prospectTable.getItems().remove(selectedIndex);
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
	
}//end prospectFrameController
