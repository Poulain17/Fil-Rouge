package View;

import java.io.File;

import Controleur.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;



public class BaseLogicielController {

	private MainApp mainApp;

	
	//test
	public void setMainApp(MainApp mainApp) {
		this.mainApp=mainApp;}


	@FXML
	private void showProspectFrame(){
		mainApp.showProspectFrame();}

	
	@FXML
	public void showRepresentantFrame(){
		mainApp.showVrpFrame();}

	
	@FXML
	public void showClientFrame(){
		mainApp.showClientFrame();}

	
	@FXML
	private void Ouvrir(){
		
		FileChooser fc = new FileChooser();
		
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fc.getExtensionFilters().add(extFilter);
        
        File file = fc.showOpenDialog(mainApp.getPrimaryStage());
        
        if(file !=null){
        	mainApp.loadMetierDataFromFile(file);}
        }
	
	
	@FXML
	private void handleSaveData(){
		
		
		System.out.println("Avant getMetierFilePath");
		File metierFile = mainApp.getMetierFilePath();
		System.out.println("Apres getMetierFilePath");
		if(metierFile !=null){
			mainApp.SaveMetierDataToFile(metierFile);
		}else{
			handleSaveAs();}
		}

	@FXML
	private void handleSaveAs(){
		
		System.out.println("SaveDataAs");
			FileChooser fc = new FileChooser();
			
			FileChooser.ExtensionFilter extFilters = new FileChooser.ExtensionFilter("XML files (*.xml)","*,xml");
			fc.getExtensionFilters().add(extFilters);
			
			File file = fc.showSaveDialog(mainApp.getPrimaryStage());
			
			if (file != null) {
				// Make sure it has the correct extension
				if (!file.getPath().endsWith(".xml")) {
					file = new File(file.getPath() + ".xml");}
				
				mainApp.SaveMetierDataToFile(file);}
	} // end SaveAs
			
	 @FXML
	 private void handleAPropos() {
				 
		 Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("ToutBois");
			   alert.setHeaderText("A propos");
			   alert.setContentText("DevTeam: Pauline Garrein & Florent Fardel \n" + 
			        		"Version 1.0 \n" + "\n" +
			        		"Date : Septembre 2017 \n" + "\n" +
			        		"Application réalisée dans le cadre du Fil-Rouge mis en place \n"+
			        		"lors de notre formation de Concepteur Developpeur Informatique à l'Afpa de Roubaix");

			    alert.showAndWait();
			    }
			 
			 
			 @FXML
			    private void handleQuitter() {
			        System.exit(0);
			    }

			
			
	} //end BaseLogiciel

