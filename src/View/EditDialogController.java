package View;


import java.util.regex.Pattern;

import Controleur.MainApp;

/**
 * Classe de mise a jour des données
 * 
 * @author Pauline.G
 */

import Model.Prospect;
import Model.Societe;
import Model.TypeBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditDialogController {

	
	@FXML
	private ComboBox typeBox;
	@FXML
	private TextField  raisonSociale;
	@FXML
	private TextField  siren;
	@FXML
	private TextField  numVoie;
	@FXML
	private ComboBox typeVoieBox;
	@FXML
	private TextField  voie;
	@FXML
	private TextField  complement;
	@FXML
	private TextField  codePostal;
	@FXML
	private TextField  ville;
	@FXML
	private ComboBox  regionBox;
	@FXML
	private TextField  nom;
	@FXML
	private TextField  prenom;
	@FXML
	private TextField  mail;
	@FXML
	private TextField  tel;
	@FXML
	private ComboBox numVrp;

	
	private Stage dialogStage;
	private Prospect prospect;
	private boolean okClicked = false;
	private MainApp mainApp;

	    @FXML
	    private void initialize() {}
	
	    public void setMainApp(MainApp mainApp){
	    	this.mainApp= mainApp;
	    }
	    
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;  
	    }
	    
/////////////////////////////// Afficher donnée dans MAJ \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
	    public void setSociete(Prospect prospect) {
	    	int i;
	        this.prospect = prospect;
    
			raisonSociale.setText(prospect.getRaisonSociale());	
			siren.setText(Integer.toString(prospect.getSiren()));
			numVoie.setText(Integer.toString(prospect.getNumVoie()));
			typeVoieBox.setPromptText(prospect.getTypeVoie());
			voie.setText(prospect.getVoie());
			complement.setText(prospect.getComplement());
			codePostal.setText(prospect.getCodePostal());
			ville.setText(prospect.getVille());
			regionBox.setPromptText(prospect.getRegion());
			numVrp.setPromptText(prospect.getNumVrp());
			nom.setText(prospect.getNom());
	        prenom.setText(prospect.getPrenom());
	        mail.setText(prospect.getMail());
	        tel.setText(prospect.getTel());
			
///////////////////////////////Retirer les 0 present dans les TextField MAJ \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			if(prospect.getRaisonSociale()!=null){		
			}else{
				siren.setText(null);
				numVoie.setText(null);}
													
/////////////////////////////// Declaration ComboBox \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			
			////////// TypeBox \\\\\\\\\\
			if(prospect == null){
				typeBox.setItems(mainApp.getTypeBoxData());
				typeBox.getSelectionModel().select(0);
			}else{
				typeBox.setItems(mainApp.getTypeBoxData());
				i = prospect.getIndexTypeBox();
					typeBox.getSelectionModel().select(i-1);}}
	    
	    	////////// TypeVoieBox \\\\\\\\\\
	    
	    	////////// RegionBox \\\\\\\\\\
	    
	    	////////// NumVrpBox \\\\\\\\\\

	    public boolean isOkClicked() {
	        return okClicked;}

		@FXML
	    private void handleOk() {
			String s;
			String t[];
	        if (isInputValid()) {
	        	
	        	
	        	
	        	prospect.setRaisonSociale(raisonSociale.getText());
	        	prospect.setSiren(Integer.parseInt(siren.getText()));        
	        	prospect.setNumVoie(Integer.parseInt(numVoie.getText()));
	        	prospect.setTypeVoie(typeVoieBox.getPromptText());
	        	prospect.setVoie(voie.getText());
	        	prospect.setComplement(complement.getText());
	        	prospect.setCodePostal(codePostal.getText());
	        	prospect.setVille(ville.getText());
	            prospect.setRegion(regionBox.getPromptText());
	            prospect.setNom(nom.getText());
	            prospect.setPrenom(prenom.getText());
	            prospect.setMail(mail.getText());
	            prospect.setTel(tel.getText());

/////////////////////////////// ComboBox \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\       
	            
	            
	            s = typeBox.getValue().toString();
	            System.out.println("s = "+s);
		        t=s.split("");
		        System.out.println("t = "+t[0]);
		        prospect.setIndexTypeBox(Integer.parseInt(t[0]));
		        
	            okClicked = true;
	            dialogStage.close();
	        } 
	    }  //End HandleOk
	    
	    @FXML
	    private void handleCancel(){
	    	dialogStage.close();  }

	    
  private boolean isInputValid() {
	        String errorMessage = "";

	   
	        if (siren.getText() == null || siren.getText().length() ==0) {
	            errorMessage += "Siren : Entrée invalide!\n"; 
	        }else {
	            // try to parse the postal code into an int.
	            try {
	                Integer.parseInt(siren.getText());
	            } catch (NumberFormatException e) {
	                errorMessage +=  "Saisir des données numérique uniquement !\n"; 
	            }
	        }


	        if (numVoie.getText() == null || numVoie.getText().length() == 0) {
	            errorMessage += "Numéro de voie : Entrée invalide !\n" ;
	        }else {
	            // try to parse the postal code into an int.
	            try {
	                Integer.parseInt(numVoie.getText());
	            } catch (NumberFormatException e) {
	                errorMessage += "Saisir des données numérique uniquement!\n";
	                		 
	            }
	        }

	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	            // Show the error message.
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.initOwner(dialogStage);
	            alert.setTitle("Saisie invalide");
	            alert.setHeaderText("Merci de corrigé les données erronées");
	            alert.setContentText(errorMessage);
	            
	            alert.showAndWait();
	            
	            return false;
	        }
	    }
	} //Fin classe


