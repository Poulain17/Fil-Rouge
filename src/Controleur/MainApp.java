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
import Model.ClientListWrapper;
import Model.Prospect;
import Model.ProspectListWrapper;
import Model.RegionBox;
import Model.Representant;
import Model.RepresentantListWrapper;
import Model.TypeBox;
import View.BaseLogicielController;
import View.ClientFrameController;
import View.EditDialogClientContoller;
import View.EditDialogController;
import View.ProspectFrameContoller;
import View.RepresentantEditDialogueController;
import View.RepresentantFrameController;
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
	private ObservableList<TypeBox> typeBoxData = FXCollections.observableArrayList();
	private ObservableList<Client> clientData = FXCollections.observableArrayList();
	private ObservableList<RegionBox> regionBoxData = FXCollections.observableArrayList();


	

	

	public MainApp(){
		

		/**
		 * Instanciation des données Representant
		 */
		
		
		vrpData.add(new Representant("10","Quinzel","Harleen","Quinzel.Harleen@toutbois.fr","0625489752","Nord",1980,10));
		vrpData.add(new Representant("20","Banner","Bruce","Banner.Bruce@ulientoutbois.fr","0784934574","Ouest",1490,3));
		vrpData.add(new Representant("30","Accroc","Arthur","Accroc.Arthur@toutbois.fr","0678963214","Sud-Ouest",1490,3));
		vrpData.add(new Representant("40","Noemie","Guigue","Guigue.Noemie@toutbois.fr","0681497521","Est",1490,3));
		vrpData.add(new Representant("50","Quill","Peter","Star.Lord@toutbois.fr","0748956217","Ile-De-France",1600,5));
		vrpData.add(new Representant("60","Kirk","James","starFleet@toutbois.fr","0625487914","Sud-Est",2680,15));

		/**
		 * Instanciation des donnée ComboBox de le fenetre de MAJ prospect
		 */
		typeBoxData.add(new TypeBox(1,"Prospect"));
		typeBoxData.add(new TypeBox(2,"Client"));
		for (int i=0;i<typeBoxData.size();i++){
			System.out.println(typeBoxData.get(i).toString());}
		

		regionBoxData.add(new RegionBox(1,"Nord"));
		regionBoxData.add(new RegionBox(2,"Ouest"));
		regionBoxData.add(new RegionBox(3,"Sud-Ouest"));
		regionBoxData.add(new RegionBox(4,"Est"));
		regionBoxData.add(new RegionBox(5,"Ile-deFrance"));
		regionBoxData.add(new RegionBox(6,"Sud-Est"));
		for (int a=0;a<regionBoxData.size();a++){
			System.out.println(regionBoxData.get(a).toString());}
		
		
		

		/**
		 * Instanciation des données Prospect
		 */
		prospectData.add(new Prospect(1,"Le Bois Du Nord Savare",323995357,2,100001,4,"Rue","Augustin Fresnel","","35400","Saint Malo","Duval","Frederic","contact@savare.com","0299453190","20",0));
		prospectData.add(new Prospect(1,"Midas",323995357,3,100002,1,"Route","D'Ygos","","40090","Saint Martin D'oney","Stockstone","David","st.da@hotmail.fr","0558520015","30",0));
		prospectData.add(new Prospect(1,"Sarl Tressibois",318210507,1,100003,1,"Rue","Du Gressart","","59152","Tressin ","Leconte","Claude","admin@tressibois.fr","0320854976","10",0));
		prospectData.add(new Prospect(1,"Solutions Bois",494596737,4,100004,20,"Allée","Des Grands Paquis","","54180","Heillecourt","Lejal","Sylvain","leja.sylvain@outlook.com","0383270021","40",0));
		prospectData.add(new Prospect(1,"Menuiserie Wood",441615168,5,100005,73,"Avenue","De La Republique","","91560","Cosne","Martins","Joaquim","Joaquim,martins.joaquim@wood.fr","0169459188","50",0));

		/**
		 * Instanciation des données Client
		 */
		clientData.add(new Client(2,"Bricot Depot",451647903,5,200001,30,"Rue","De La Tourelle","CS 60501 Longpont Sur Orge","91315","Montlhery Cedex","Laporte","Marc","laporte.marc@Bricotdepot.fr","0625489712","50",12));
		clientData.add(new Client(2,"Meubles Meyer",301273751,4,200002,70,"Rue","Du General Leclerc","","67270","Schwindratzheim","Lucie","Schaeffer","commercial@meyer.fr","0388919992","40",4));
		clientData.add(new Client(2,"Demeure de Famille",434856381,1,200003,39,"Rue","Du Bosquiel","","59910","Bondues","Salome","Bleme","contact@fipo.com","0320760145","10",1));
		clientData.add(new Client(2,"Les Meubles Niolet",377942537,3,200004,11,"Allee ","des Coustous","","65200","Bagneres-de-Bigorre","Julien","Niolet","julien.niolet@gmail.com","0562950281","30",3));
		clientData.add(new Client(2,"Crea Mobilier",443393202,2,200005,74,"rue","d'Audierne","","29710","Plozevet","Bertrand","Claquin","Creamobilier@hotmail.fr","0298914951","20",7));

	} // end MainApp
	
		
	
	public ObservableList<Prospect> getProspectData(){
		return prospectData;}
	
	public ObservableList<TypeBox> getTypeBoxData(){
		return typeBoxData;}
	
	public void setTypeBoxData(ObservableList<TypeBox> typeBoxData){
		this.typeBoxData = typeBoxData;}
	
	public static ObservableList<Representant> getVrp(){
		return vrpData;}
	
	public ObservableList<Client>getClientData(){
		return clientData;}
	
	public ObservableList<RegionBox> getRegionBoxData(){
		return regionBoxData;}

	public void setRegionBoxData(ObservableList<RegionBox> regionBoxData){
		this.regionBoxData = regionBoxData;}
	
	

	
	
	
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

////////////////////////////AFFICHAGE DES FENETRES \\\\\\\\\\\\\\\\\\\\\\\\\\\\

		/////// PROSPECT \\\\\\\
	
	public void showProspectFrame(){
		try {
	        // Load person overview.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("/View/ProspectFrame.fxml"));
	        AnchorPane ProspectFrame = (AnchorPane) loader.load();
	        rootLayout.setCenter(ProspectFrame);
	        
		ProspectFrameContoller controller = loader.getController();
		controller.setMainApp(this);}

	    catch (IOException e) {
	        e.printStackTrace();}}
	
		/////// REPRESENTANT \\\\\\\
	
	public void showVrpFrame(){
		try {
	        // Load person overview.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("/View/RepresentantFrame.fxml"));
	        AnchorPane RepresentantFrame = (AnchorPane) loader.load();
	        rootLayout.setCenter(RepresentantFrame);
	        
		RepresentantFrameController controllerProspect = loader.getController();
		controllerProspect.setMainApp(this);}

	    catch (IOException e) {
	        e.printStackTrace();}}
	
		/////// CLIENT \\\\\\\

	public void showClientFrame(){
		try {
	        // Load person overview.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("/View/ClientFrame.fxml"));
	        AnchorPane ClientFrame = (AnchorPane) loader.load();
	        rootLayout.setCenter(ClientFrame);
	        
		ClientFrameController controllerClient = loader.getController();
		controllerClient.setMainApp(this);}

	    catch (IOException e) {
	        e.printStackTrace();}}
	
//////////////////////////// AFFICHAGE DE LA FENETRE DE MISE A JOUR \\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Ouverture de la fenetre de Mise à jour des données société.
	 * 
	 * @param handleOk
	 * @return Sauvegarde des données modifiées.
	 */

			/////// PROSPECT \\\\\\\
	
	 public boolean showEditDialogProspect(Prospect prospect) {
	        try {

	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("/view/EditDialog.fxml"));
	            AnchorPane ProspectFrame = (AnchorPane) loader.load();

	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Mise à Jour");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(ProspectFrame);
	            dialogStage.setScene(scene);

	            EditDialogController controller = loader.getController();
	            controller.setMainApp(this);
	            controller.setDialogStage(dialogStage);
	            controller.setSocieteProspect(prospect);

	            dialogStage.showAndWait();

	            return controller.isOkClicked();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 	/////// CLIENT \\\\\\\
	 
	 public boolean showEditDialogClient(Client client) {
	        try {

	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("/view/EditDialogClient.fxml"));
	            AnchorPane ClientFrame = (AnchorPane) loader.load();

	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Mise à Jour");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(ClientFrame);
	            dialogStage.setScene(scene);

	            EditDialogClientContoller controller = loader.getController();
	            controller.setMainApp(this);
	            controller.setDialogStage(dialogStage);
	            controller.setSocieteClient(client);

	            dialogStage.showAndWait();

	            return controller.isOkClicked();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;} }
	 
	 
	 
	 	/////// REPRESENTANT \\\\\\\
	 
	 public boolean showEditDialogVrp(Representant representant) {
	        try {

	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("/view/RepresentantEditDialog.fxml"));
	            AnchorPane ClientFrame = (AnchorPane) loader.load();

	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Mise à Jour");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(ClientFrame);
	            dialogStage.setScene(scene);

	            RepresentantEditDialogueController controllerVrp = loader.getController();
	            controllerVrp.setMainApp(this);
	            controllerVrp.setDialogStage(dialogStage);
	            controllerVrp.setRepresentant(representant);

	            dialogStage.showAndWait();

	            return controllerVrp.isOkClicked();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;} }
	 
	 
	/* 
	 //////////////////////////// SAUVEGARDE \\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 
	 public File getSocieteFilePath(){
		 Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		 String filePath = prefs.get("FilePath", null);
		 if (filePath !=null){
			 return new File(filePath);
		 }else{
			 return null;} }
	 
	 public void setSocieteFilePath(File file){
		 Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		 if(file !=null){
			 prefs.put("filesPath",file.getPath());
			 primaryStage.setTitle("ToutBois - " + file.getName());
		 } else {
			 prefs.remove("filePatch");
			 primaryStage.setTitle("ToutBois");}} 
		 
	 
	 
	 
	 //////////////////////////// LECTURE ET ECRITURE DES DONNEES SOCIETE \\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 
	 /**
	  * Telecharge les données sociétés du fichier source. Remplace ces données
	  * suite à la sauvegarde
	  * 
	  * @param file
	  */
	/*
	 			/////////////////// Telechargement des données  \\\\\\\\\\\\\\\\\\\
	public void loadSocieteDataFromFile(File file){
		 try{
			 JAXBContext context = JAXBContext.newInstance(ProspectListWrapper.class);
			 Unmarshaller um = context.createUnmarshaller();
			 
			 ProspectListWrapper wrapperP = (ProspectListWrapper) um.unmarshal(file);
			 prospectData.clear();
			 prospectData.addAll(wrapperP.getVrp());
			 
			 JAXBContext contextC = JAXBContext.newInstance(ClientListWrapper.class);
			 Unmarshaller umC = contextC.createUnmarshaller();
			 
			 ClientListWrapper wrapperC = (ClientListWrapper) umC.unmarshal(file);
			 clientData.clear();
			 clientData.addAll(wrapperC.getClient());
			 
			 JAXBContext contextR = JAXBContext.newInstance(RepresentantListWrapper.class);
			 Unmarshaller umR = contextR.createUnmarshaller();
			 
			 RepresentantListWrapper wrapperR = (RepresentantListWrapper)  umR.unmarshal(file);
			 vrpData.clear();
			 vrpData.addAll(wrapperR.getlistRepresentant());

			 setSocieteFilePath(file);
			 }catch (Exception e){
				  Alert alert = new Alert(AlertType.ERROR);
			        alert.setTitle("Erreur");
			        alert.setHeaderText("Impossible de charger les données");
			        alert.setContentText("Impossible de chargé les données depuis le fichier : \n" + file.getPath());

			        alert.showAndWait();}
			 }
		 
	 			/////////////////// Telechargement des données  \\\\\\\\\\\\\\\\\\\
	 
	 public void SaveSocieteDataToFile(File file){
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
		        alert.setHeaderText("Impossible de sauvegarder les données");
		        alert.setContentText("Impossible de sauvegarder les données depuis le fichier :\n" + file.getPath());

		        alert.showAndWait();}
		 
		 try{
			 JAXBContext context = JAXBContext
		                .newInstance(ClientListWrapper.class);
		        Marshaller m = context.createMarshaller();
		        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		        
		        ClientListWrapper wrapper = new ClientListWrapper();
		       // wrapper.setVrp((vrpData);
		        m.marshal(wrapper, file);
		        setSocieteFilePath(file);
		 }catch (Exception e){
			 Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Erreur");
		        alert.setHeaderText("Impossible de sauvegarder les données");
		        alert.setContentText("Impossible de sauvegarder les données depuis le fichier :\n" + file.getPath());

		        alert.showAndWait();}
		 
		 try{
			 JAXBContext context = JAXBContext
		                .newInstance(RepresentantListWrapper.class);
		        Marshaller m = context.createMarshaller();
		        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		        
		        RepresentantListWrapper wrapper = new RepresentantListWrapper();
		       // wrapper.setVrp((vrpData);
		        m.marshal(wrapper, file);
		        setSocieteFilePath(file);
		 }catch (Exception e){
			 Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Erreur");
		        alert.setHeaderText("Impossible de sauvegarder les données");
		        alert.setContentText("Impossible de sauvegarder les données depuis le fichier :\n" + file.getPath());

		        alert.showAndWait();}
		 
	 } //end SaveSocieteDataFile
	 */
	 
	 
	 //////////////////////////// AUTRES \\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 
	public Stage getPrimaryStage(){
		return primaryStage;}


	
	public static void main(String[] args) {
		launch(args);}
}
