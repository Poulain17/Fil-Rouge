package View;

/**
 * Classe de mise a jour des données
 * 
 * @author Pauline.G
 */


import Controleur.MainApp;
import Model.Prospect;
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
	@FXML
	private TextField nbCommande;

	
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
			//regionBox.setPromptText(prospect.getRegion());
			numVrp.setPromptText(prospect.getNumVrp());
			nom.setText(prospect.getNom());
	        prenom.setText(prospect.getPrenom());
	        mail.setText(prospect.getMail());
	        tel.setText(prospect.getTel());
	        numVrp.setText(prospect.getNumVrp());
	        nbCommande.setText(Integer.toString(prospect.getNbCommande()));
			
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
				i = prospect.getIndexType();
					typeBox.getSelectionModel().select(i-1);}
	    
	    	////////// RegionBox \\\\\\\\\\
			if(prospect == null){
				regionBox.setItems(mainApp.getRegionBoxData());
				regionBox.getSelectionModel().select(0);
			}else{
				regionBox.setItems(mainApp.getRegionBoxData());
				ir = prospect.getIndexRegion();
					regionBox.getSelectionModel().select(ir-1);}
	    
	    	
	    }//end setSocieteProspect

	  /////////////////////////////////// Client \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	   
	    


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
	            prospect.setNom(nom.getText());
	            prospect.setPrenom(prenom.getText());
	            prospect.setMail(mail.getText());
	            prospect.setTel(tel.getText());
	            prospect.setNumVrp(numVrp.getText());
	            prospect.setNbCommande(Integer.parseInt(nbCommande.getText()));
	            
	  /////////////////////////////// ComboBox \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\       
	            
		          
			  s = typeBox.getValue().toString();
			  System.out.println("s = "+s);
			  t=s.split("");
			  System.out.println("t = "+t[0]);
			  prospect.setIndexType(Integer.parseInt(t[0]));
			  
			  a = regionBox.getValue().toString();
			  System.out.println("a = "+a);
			  b=a.split("");
			  System.out.println("b = "+b[0]);
			  prospect.setIndexRegion(Integer.parseInt(b[0]));
			  
			  
	////////////////////////////// ProspectToClient \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 	
			  
			  okClicked = true;
			  dialogStage.close();} 
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