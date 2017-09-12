package Model;



import Controleur.MainApp;
import View.ProspectFrameContoller;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe Prospect fille de la Classe Societe
 * 
 * @author Pauline.G
 */

public class Client extends Societe{
	
	public final IntegerProperty numClient;
	public static int clientCompteur = 0;

	
	
public MainApp mainApp;

private ObjectProperty<Representant> representant;

	public Client(String raisonSociale, Integer siren, Integer indexRegion, Integer numVoie, String typeVoie, String voie, 
			String complement, String codePostal, String ville, String nom, String prenom, String mail, String tel, String numVrp, Integer nbCommande) {
		super(raisonSociale, siren, indexRegion, numVoie, typeVoie, voie, complement, codePostal, ville, nom,
				prenom, mail, tel, numVrp, nbCommande);
		
		clientCompteur ++;
		this.numClient = new SimpleIntegerProperty(clientCompteur);

		this.setNbCommande(1);
		
		for(Representant vrp : MainApp.getVrp()){
			if(numVrp == (vrp.getNumVrp())){
				this.representant = new SimpleObjectProperty<Representant>(vrp);} //end if	
		}//end for
	}	
		public Client(){
			this(null,0,0,0,null,null,null,null,null,null,null,null,null,null,0);}
		
		public Client (Prospect prospect){
		
		this.raisonSociale = prospect.raisonSocialeProperty();
		this.siren = prospect.sirenProperty();
		this.indexRegion = prospect.indexRegionProperty();
		this.numVoie = prospect.numVoieProperty();
		this.voie = prospect.voieProperty();
		this.complement = prospect.complementProperty();
		this.codePostal = prospect.codePostalProperty();
		this.ville = prospect.villeProperty();
		this.nom = prospect.nomProperty();
		this.prenom = prospect.prenomProperty();
		this.mail = prospect.mailProperty();
		this.tel = prospect.telProperty();
		this.numVrp = prospect.numVrpProperty();
		this.nbCommande = prospect.nbCommandeProperty();
		clientCompteur ++;
		this.numClient = new SimpleIntegerProperty(clientCompteur);

	
	} //end Constuctor	

		
	public Integer getNumClient() {
		return numClient.get();}
	
	public void setNumClient(Integer numClient){
		this.numClient.set(numClient);}
	
	public IntegerProperty numClientProperty(){
		return numClient;}
	
	public int getClientCompteur() {
		return clientCompteur;}
	
	public void setClientCompteur(int clientCompteur) {
		Client.clientCompteur = clientCompteur;}


	public  void setRepresentant(Representant value){
		representant.set(value);}
	
	public Representant getRepresentant(){
		return representant.get();}


	public String getRegion() {
		// TODO Auto-generated method stub
		return null;}
	
	
	
	
}// End Client
