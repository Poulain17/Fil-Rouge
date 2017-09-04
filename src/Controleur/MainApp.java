package Controleur;


/**
 * Application Principal
 * @author Pauline
 * @version v1
 * @date Aout 2017
 * @Projet Fil Rouge Afpa - Logiciel de gestion CRM Societe ToutBois
 */

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Model.Client;
import Model.Prospect;
import Model.ProspectListWrapper;
import Model.Representant;
import Model.TypeBox;
import Model.VrpBox;
import View.BaseLogicielController;
import View.EditDialogController;
import View.ProspectFrameContoller;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	public static BorderPane rootLayout;
	private ObservableList<Prospect> prospectData = FXCollections.observableArrayList();
	private static ObservableList<Representant> vrpData = FXCollections.observableArrayList();
	private static ObservableList<Client> client = FXCollections.observableArrayList();
	private ObservableList<TypeBox> typeBoxData = FXCollections.observableArrayList();
	//private ObservableList<VrpBox> vrpBoxData = FXCollections.observableArrayList();
	

	

	public MainApp(){
		

		/**
		 * Instanciation des donn�es Representant
		 */
		
		
		Representant r1 = new Representant("10","Harleen","Quinzel","Dupont.Jacques@toutbois.fr","0625489752","Nord");
		vrpData.add(r1);
		Representant r2 = new Representant("20","Bruce","Banner","Deville.J@ulientoutbois.fr","0784934574","Ouest");
		vrpData.add(r2);
		Representant r3 = new Representant("30","Arthur","Accroc","Molinel.Sabine@toutbois.fr","0678963214","Sud-Ouest");
		vrpData.add(r3);
		Representant r4 = new Representant("40","Guigue","Noemie","Guigue.Noemie@toutbois.fr","0681497521","Est");
		vrpData.add(r4);
		Representant r5 = new Representant("50","Peter","Quill","Star.Lord@toutbois.fr","0748956217","Ile-De-France");
		vrpData.add(r5);



		/**
		 * Instanciation des donn�es Prospect
		 */
		prospectData.add(new Prospect("Le Bois Du Nord Savare",323995357,"Ouest",124875,4,"Rue","Augustin Fresnel","","35400","Saint Malo","Duval","Frederic","contact@savare.com","0299453190","20"));
		prospectData.add(new Prospect("Midas",323995357,"Sud-Ouest",789315,1,"Route","D'Ygos","","40090","Saint Martin D'oney","Stockstone","David","st.da@hotmail.fr","0558520015","30"));
		prospectData.add(new Prospect("Sarl Tressibois",318210507,"Nord",521478,1,"Rue","Du Gressart","","59152","Tressin ","Leconte","Claude","admin@tressibois.fr","0320854976","10"));
		prospectData.add(new Prospect("Solutions Bois",494596737,"Est",458716,20,"All�e","Des Grands Paquis","","54180","Heillecourt","Lejal","Sylvain","leja.sylvain@outlook.com","0383270021","40"));
		prospectData.add(new Prospect("Menuiserie Wood",441615168,"Ile-De-France",951234,73,"Avenue","De La Republique","","91560","Cosne","Martins","Joaquim","Joaquim,martins.joaquim@wood.fr","0169459188","50"));

		
		/**
		 * Instanciation des donn�e ComboBox de le fenetre de MAJ prospect
		 */
		typeBoxData.add(new TypeBox(1,"Prospect"));
		typeBoxData.add(new TypeBox(2,"Client"));
		for (int i=0;i<typeBoxData.size();i++){
			System.out.println(typeBoxData.get(i).toString());}
		
		
	} // end MainApp
	
		
	
	public ObservableList<Prospect> getProspectData(){
		return prospectData;}
	
	
	public ObservableList<TypeBox> getTypeBoxData(){
		return typeBoxData;}
	
	public void setTypeBoxData(ObservableList<TypeBox> typeBoxData){
		this.typeBoxData = typeBoxData;
	}
	
	public static ObservableList<Representant> getVrp(){
		return vrpData;}
	
	public static ObservableList<Client> getClient(){
		return client;
	}
	
	
	
	@Override
	public void start(Stage primaryStage) {
		
	this.primaryStage = primaryStage;
	this.primaryStage.setTitle("Gestion ToutBois");
	this.primaryStage.getIcons().add(new Image("file:View.Image/IconFrame.png"));
	this.primaryStage.setResizable(false);

	initBaseLogicielFrame();
	
	}	
	
////////////////////////////AFFICHAGE DE LA BASE LOGICIEL \\\\\\\\\\\\\\\\\\\\\\\\\\\\

	public void initBaseLogicielFrame(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/View/BaseLogiciel.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

			//test
			BaseLogicielController controller = loader.getController();
			controller.setMainApp(this);
		}
		catch(IOException e){
			e.printStackTrace();}
		}//end initLayout

////////////////////////////AFFICHAGE DE LA FENETRE PROSEPCT \\\\\\\\\\\\\\\\\\\\\\\\\\\\

	public void showProspectFrame(){
		try {
	        // Load person overview.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("/View/ProspectFrame.fxml"));
	        AnchorPane ProspectFrame = (AnchorPane) loader.load();
	        rootLayout.setCenter(ProspectFrame);
	        
		ProspectFrameContoller controller = loader.getController();
		controller.setMainApp(this);
		
		
		}

	    catch (IOException e) {
	        e.printStackTrace();}}

	
//////////////////////////// AFFICHAGE DE LA FENETRE DE MISE A JOUR \\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Ouverture de la fenetre de Mise � jour des donn�es soci�t�.
	 * 
	 * @param handleOk
	 * @return Sauvegarde des donn�es modifi�es.
	 */

	 public boolean showEditDialog(Prospect prospect) {
	        try {

	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("/view/EditDialog.fxml"));
	            AnchorPane ProspectFrame = (AnchorPane) loader.load();

	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Mise � Jour");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(ProspectFrame);
	            dialogStage.setScene(scene);

	            EditDialogController controller = loader.getController();
	            controller.setMainApp(this);
	            controller.setDialogStage(dialogStage);
	            controller.setSociete(prospect);

	            dialogStage.showAndWait();

	            return controller.isOkClicked();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 
	 //////////////////////////// SAUVEGARDE \\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 
	/* public File getSocieteFilePath(){
		 Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		 String filePath = prefs.get("FilePath", null);
		 if (filePath !=null){
			 return new File(filePath);
		 }else{
			 return null;
		 }
	 }*/
	 
	/* public void setSocieteFilePath(File file){
		 Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		 if(file !=null){
			 prefs.put("filesPath",file.getPath());
			 primaryStage.setTitle("AdresseApp - " + file.getName());
		 } else {
			 prefs.remove("filePatch");
			 primaryStage.setTitle("AdresseApp");
		 }
		 
	 
	 
	 
	 //////////////////////////// LECTURE ET ECRITURE DES DONNEES SOCIETE \\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 
	 /**
	  * Telecharge les donn�es soci�t�s du fichier source. Remplace ces donn�es
	  * suite � la sauvegarde
	  * 
	  * @param file
	  */
	
	 			/////////////////// Telechargement des donn�es  \\\\\\\\\\\\\\\\\\\
	/* public void loadSocieteDataFromFile(File file){
		 try{
			 JAXBContext context = JAXBContext.newInstance(ProspectListWrapper.class);
			 Unmarshaller um = context.createUnmarshaller();
			 
			 ProspectListWrapper wrapper = (ProspectListWrapper) um.unmarshal(file);
			 prospectData.clear();
			 prospectData.addAll(wrapper.getVrp());
			 
			 setSocieteFilePath(file);
			 }catch (Exception e){
				  Alert alert = new Alert(AlertType.ERROR);
			        alert.setTitle("Erreur");
			        alert.setHeaderText("Impossible de charger les donn�es");
			        alert.setContentText("Impossible de charg� les donn�es depuis le fichier : \n" + file.getPath());

			        alert.showAndWait();}
			 }*/
		 
	 			/////////////////// Telechargement des donn�es  \\\\\\\\\\\\\\\\\\\
	 
	 /*public void SaveSocieteDataToFile(File file){
		 try{
			 JAXBContext context = JAXBContext
		                .newInstance(ProspectListWrapper.class);
		        Marshaller m = context.createMarshaller();
		        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		        
		        ProspectListWrapper wrapper = new ProspectListWrapper();
		       // wrapper.setVrp((vrpData);
		        m.marshal(wrapper, file);
		        setSocieteFilePath(file);
		 }catch (Exception e){
			 Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Erreur");
		        alert.setHeaderText("Impossible de sauvegarder les donn�es");
		        alert.setContentText("Impossible de sauvegarder les donn�es depuis le fichier :\n" + file.getPath());

		        alert.showAndWait();
			 
		 }
	 }*/
	 
	 //////////////////////////// AUTRES \\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 
	public Stage getPrimaryStage(){
		return primaryStage;}


	
	public static void main(String[] args) {
		launch(args);}
}
