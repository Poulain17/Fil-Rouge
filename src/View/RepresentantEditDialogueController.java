package View;

import Controleur.MainApp;
import Model.Representant;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RepresentantEditDialogueController {
	
	@FXML
	private TextField  nom;
	@FXML
	private TextField  prenom;
	@FXML
	private TextField  mail;
	@FXML
	private TextField tel;
	@FXML
	private TextField  salaire;
	@FXML
	private TextField  comm;
	@FXML
	private TextField  region;
	
	private Stage dialogStage;
	private Representant representant;
	private Boolean okClicked = false;
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
	    
	    public void setRepresentant(Representant representant){
	    	
	    	nom.setText(representant.getNomVrp());
	    	prenom.setText(representant.getNomVrp());
	    	mail.setText(representant.getMailVrp());
	    	tel.setText(representant.getTelVrp());
	    	salaire.setText(Integer.toString(representant.getSalaireVrp()));
	    	comm.setText(Integer.toString(representant.getCommVrp()));
	    	region.setText(representant.getregionVrp());
	    	
	    } //end SetRepresentant
	    
	    public boolean isOkClicked() {
	        return okClicked;}
	    
	    @FXML
	    private void handleOk(){
	    	if(isInputValid()){
	    		
	    		representant.setNomVrp(nom.getText());
	    		representant.setPrenomVrp(prenom.getText());
	    		representant.setMailVrp(mail.getText());
	    		representant.setTelVrp(tel.getText());
	    		representant.setRegionVrp(region.getText());
	    		representant.setSalaireVrp(Integer.parseInt(salaire.getText()));
	    		representant.setCommVrp(Integer.parseInt(comm.getText()));
	    		
	    		okClicked = true;
	            dialogStage.close();
	    		
	    	}
	    }//end handleOk
	    
	    @FXML
	    private void handleCancel(){
	    	dialogStage.close();  }
	    
	    private boolean isInputValid() {
	        String errorMessage = "";

	   
	        if (salaire.getText() == null || salaire.getText().length() ==0) {
	            errorMessage += "Salaire : Entrée invalide!\n"; 
	        }else {
	            // try to parse the postal code into an int.
	            try {
	                Integer.parseInt(salaire.getText());
	            } catch (NumberFormatException e) {
	                errorMessage +=  "Saisir des données numérique uniquement !\n";}}


	        if (comm.getText() == null || comm.getText().length() == 0) {
	            errorMessage += "Commission : Entrée invalide !\n" ;
	        }else {
	            // try to parse the postal code into an int.
	            try {
	                Integer.parseInt(comm.getText());
	            } catch (NumberFormatException e) {
	                errorMessage += "Saisir des données numérique uniquement!\n";}}

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
	    }  // end IsInuputValid

} //end Class

