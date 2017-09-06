package View;


import java.util.regex.Pattern;

import Controleur.MainApp;
import Model.Client;

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
	private TextField typeVoie;
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
	private TextField numVrp;

	
	private Stage dialogStage;
	private Prospect prospect;
	private Client client;
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
	    
	    		///// Prospect \\\\\
	    
	    public void setSocieteProspect(Prospect prospect) {
	    	int i;
	    	int ir;
	        this.prospect = prospect;
    
			raisonSociale.setText(prospect.getRaisonSociale());	
			siren.setText(Integer.toString(prospect.getSiren()));
			numVoie.setText(Integer.toString(prospect.getNumVoie()));
			typeVoie.setText(prospect.getTypeVoie());
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
	        numVrp.setText(prospect.getNumVrp());
			
	        /////Retirer les 0 present dans les TextField MAJ \\\\\
			if(prospect.getRaisonSociale()!=null){		
			}else{
				siren.setText(null);
				numVoie.setText(null);}
													
	////////////////// Declaration ComboBox \\\\\\\\\\\\\\\\\\\\
			
			////////// TypeBox \\\\\\\\\\
			if(prospect == null){
				typeBox.setItems(mainApp.getTypeBoxData());
				typeBox.getSelectionModel().select(0);
			}else{
				typeBox.setItems(mainApp.getTypeBoxData());
				i = prospect.getIndexTypeBox();
					typeBox.getSelectionModel().select(i-1);}
	    
	    	////////// RegionBox \\\\\\\\\\
			if(prospect == null){
				regionBox.setItems(mainApp.getRegionBoxData());
				regionBox.getSelectionModel().select(0);
			}else{
				regionBox.setItems(mainApp.getRegionBoxData());
				ir = prospect.getIndexRegionBox();
					regionBox.getSelectionModel().select(ir-1);}
	    
	    	
	    }//end setSocieteProspect

	  /////////////////////////////////// Client \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	    public void setSocieteClient(Client client) {
	    	int i;
	    	int ir;
	        this.client = client;
    
			raisonSociale.setText(client.getRaisonSociale());	
			siren.setText(Integer.toString(client.getSiren()));
			numVoie.setText(Integer.toString(client.getNumVoie()));
			typeVoie.setText(client.getTypeVoie());
			voie.setText(client.getVoie());
			complement.setText(client.getComplement());
			codePostal.setText(client.getCodePostal());
			ville.setText(client.getVille());
			regionBox.setPromptText(client.getRegion());
			numVrp.setPromptText(client.getNumVrp());
			nom.setText(client.getNom());
	        prenom.setText(client.getPrenom());
	        mail.setText(client.getMail());
	        tel.setText(client.getTel());
	        numVrp.setText(client.getNumVrp());
	        
	        /////Retirer les 0 present dans les TextField MAJ \\\\\
			if(client.getRaisonSociale()!=null){		
			}else{
				siren.setText(null);
				numVoie.setText(null);}
													
			///// Declaration ComboBox \\\\\
			
			////////// TypeBox \\\\\\\\\\
			if(client == null){
				typeBox.setItems(mainApp.getTypeBoxData());
				typeBox.getSelectionModel().select(0);
			}else{
				typeBox.setItems(mainApp.getTypeBoxData());
				i = client.getIndexTypeBox();
					typeBox.getSelectionModel().select(i-1);}
	    
			//////////RegionBox \\\\\\\\\\
			if(client == null){
				regionBox.setItems(mainApp.getRegionBoxData());
				regionBox.getSelectionModel().select(0);
			}else{
				regionBox.setItems(mainApp.getRegionBoxData());
				ir = client.getIndexTypeBox();
					regionBox.getSelectionModel().select(ir-1);}
	   
	    
	    
	    }//end SetSocieteClient

	    public boolean isOkClicked() {
	        return okClicked;}

		@FXML
	    private void handleOkProspect() {
			String s;
			String t[];
			String a;
			String b[];
	        if (isInputValid()) {
	        	
	        	prospect.setRaisonSociale(raisonSociale.getText());
	        	prospect.setSiren(Integer.parseInt(siren.getText()));        
	        	prospect.setNumVoie(Integer.parseInt(numVoie.getText()));
	        	prospect.setTypeVoie(typeVoie.getText());
	        	prospect.setVoie(voie.getText());
	        	prospect.setComplement(complement.getText());
	        	prospect.setCodePostal(codePostal.getText());
	        	prospect.setVille(ville.getText());
	            prospect.setRegion(regionBox.getPromptText());
	            prospect.setNom(nom.getText());
	            prospect.setPrenom(prenom.getText());
	            prospect.setMail(mail.getText());
	            prospect.setTel(tel.getText());
	            prospect.setNumVrp(numVrp.getText());
	            
	  /////////////////////////////// ComboBox \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\       
	            
		          
			  s = typeBox.getValue().toString();
			  System.out.println("s = "+s);
			  t=s.split("");
			  System.out.println("t = "+t[0]);
			  prospect.setIndexTypeBox(Integer.parseInt(t[0]));
			  
			  a = regionBox.getValue().toString();
			  System.out.println("s = "+a);
			  b=a.split("");
			  System.out.println("t = "+b[0]);
			  prospect.setIndexTypeBox(Integer.parseInt(b[0]));
			   
			  
			  okClicked = true;
			  dialogStage.close();} 
}  //End HandleOk
	            
	       @FXML
	     private void handleOkClient() {
	    			String s;
	    			String t[];
	    			String a;
	    			String b[];
	    	        if (isInputValid()) {
	    	        	
	    	        	
	    	        	
	    	        	client.setRaisonSociale(raisonSociale.getText());
	    	        	client.setSiren(Integer.parseInt(siren.getText()));        
	    	        	client.setNumVoie(Integer.parseInt(numVoie.getText()));
	    	        	client.setTypeVoie(typeVoie.getText());
	    	        	client.setVoie(voie.getText());
	    	        	client.setComplement(complement.getText());
	    	        	client.setCodePostal(codePostal.getText());
	    	        	client.setVille(ville.getText());
	    	        	client.setRegion(regionBox.getPromptText());
	    	        	client.setNom(nom.getText());
	    	        	client.setPrenom(prenom.getText());
	    	        	client.setMail(mail.getText());
	    	        	client.setTel(tel.getText());
	    	        	client.setNumVrp(numVrp.getText());
	    	        	
	    	        	

/////////////////////////////// ComboBox \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\       
    
	            s = typeBox.getValue().toString();
	            System.out.println("s = "+s);
		        t=s.split("");
		        System.out.println("t = "+t[0]);
		        client.setIndexTypeBox(Integer.parseInt(t[0]));
		        
		        a = regionBox.getValue().toString();
				  System.out.println("s = "+a);
				  b=a.split("");
				  System.out.println("t = "+b[0]);
				  prospect.setIndexTypeBox(Integer.parseInt(b[0]));
		        
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


