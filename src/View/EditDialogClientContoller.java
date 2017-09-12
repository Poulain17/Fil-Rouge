package View;

	/**
	 * Classe de mise a jour des données
	 * 
	 * @author Pauline.G
	 */

import Controleur.MainApp;
import Model.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

	public class EditDialogClientContoller {

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
		@FXML
		private TextField nbCommande;
		
		private Stage dialogStage;
		private Client client;
		private boolean okClicked = false;
		private MainApp mainApp;


		    @FXML
		    private void initialize() {}
		
		    public void setMainApp(MainApp mainApp){
		    	this.mainApp= mainApp;
		    }
		    
		    public void setDialogStage(Stage dialogStage) {
		        this.dialogStage = dialogStage;}

/////////////////////////////// Afficher donnée dans MAJ \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
		    
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
				nom.setText(client.getNom());
		        prenom.setText(client.getPrenom());
		        mail.setText(client.getMail());
		        tel.setText(client.getTel());
		        numVrp.setText(client.getNumVrp());
		        nbCommande.setText(Integer.toString(client.getNbCommande()));
				
		        
		        /////Retirer les 0 present dans les TextField MAJ \\\\\
				if(client.getRaisonSociale()!=null){		
				}else{
					siren.setText(null);
					numVoie.setText(null);}
														
				///// Declaration ComboBox \\\\\
		    
				//////////RegionBox \\\\\\\\\\
				if(client == null){
					regionBox.setItems(mainApp.getRegionBoxData());
					regionBox.getSelectionModel().select(0);
				}else{
					regionBox.setItems(mainApp.getRegionBoxData());
					ir = client.getIndexRegion();
						regionBox.getSelectionModel().select(ir-1);}
		    	
				
					 okClicked = true;
					dialogStage.close();
		  		    
} //end setSocieteClient
		  

		    public boolean isOkClicked() {
		        return okClicked;}
		    
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
		    	            client.setNom(nom.getText());
		    	            client.setPrenom(prenom.getText());
		    	            client.setMail(mail.getText());
		    	            client.setTel(tel.getText());
		    	            client.setNumVrp(numVrp.getText());
		    	            client.setNbCommande(Integer.parseInt(nbCommande.getText()));
		    	            

	/////////////////////////////// ComboBox \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\       

		    				  
		    				  a = regionBox.getValue().toString();
		    				  System.out.println("a = "+a);
		    				  b=a.split("");
		    				  System.out.println("b = "+b[0]);
		    				  client.setIndexRegion(Integer.parseInt(b[0]));
		    				   
			        
		            okClicked = true;
		            dialogStage.close();
		        } 
		    }  //End HandleOk
		
		    
		    @FXML
		    private void handleCancel(){
		    	
		    	Client.clientCompteur--;
		    	mainApp.getClientData().remove(client);
		    	
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

		    
		    
} //end EditDialogClientController
