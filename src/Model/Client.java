package Model;



import Controleur.MainApp;
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
	
	private final StringProperty numClient;
	public static int clientCompteur;
	private static int numVrpCompteur;
	private String numVrp;
	int indexClient = 2;
	
public MainApp mainApp;

private ObjectProperty<Representant> representant;



	public Client(){
		this(0,null,0,0,0,0,null,null,null,null,null,null,null,null,null,null,0);}


	public Client(Integer indexType,String raisonSociale, Integer siren, Integer indexRegion, Integer idCompany, Integer numVoie,
			String typeVoie, String voie, String complement, String codePostal, String ville, String nom, String prenom,
			String mail, String tel, String numVrp, Integer nbCommande) {
		super(indexType, raisonSociale, siren, indexRegion, idCompany, numVoie, typeVoie, voie, complement, codePostal, ville, nom,
				prenom, mail, tel, numVrp, nbCommande);
		clientCompteur ++;// Compteur pour l'incrementation du numero de client
		String numCompteur = Integer.toString(clientCompteur);
		this.numClient = new SimpleStringProperty(numCompteur);

		this.setNbCommande(1);
		
		for(Representant vrp : MainApp.getVrp()){
			if(numVrp == (vrp.getNumVrp())){
				this.representant = new SimpleObjectProperty<Representant>(vrp);} //end if	
		}//end for
	
	} //end Constuctor	

		
	public String getNumClient() {
		return numClient.get();}
	
	public void setNumClient(String numClient){
		this.numClient.set(numClient);}
	
	public StringProperty numClientProperty(){
		return numClient;}
	
	public int getClientCompteur() {
		return clientCompteur;}
	
	public void setClientCompteur(int clientCompteur) {
		Client.clientCompteur = clientCompteur;}

	
	public int getnumVrpCompteur(){
		return numVrpCompteur;}
	
	public void setnumVrpCompteur(int numVrp){
		numVrpCompteur = numVrpCompteur;}

	public  void setRepresentant(Representant value){
		representant.set(value);}
	
	public Representant getRepresentant(){
		return representant.get();}


	public String getRegion() {
		// TODO Auto-generated method stub
		return null;}
	
	
	
	
}// End Client
