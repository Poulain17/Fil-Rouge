package Model;


import Controleur.MainApp;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;


/**
 * Classe Prospect fille de la Classe Societe
 * 
 * @author Pauline.G
 */


public class Prospect extends Societe{
	

	private static int CompteurProspect = 0;
	private IntegerProperty numProspect;
	public Prospect selectedProspect;
	
public MainApp mainApp;

private ObjectProperty<Representant> representant;


	public Prospect(){
		this(null,0,0,0,null,null,null,null,null,null,null,null,null,null,0);}


	
	public Prospect	(String raisonSociale, Integer siren, Integer indexRegion, Integer numVoie, String typeVoie, String voie, 
			String complement, String codePostal, String ville, String nom, String prenom, String mail, String tel, String numVrp, Integer nbCommande) {
		super(raisonSociale, siren, indexRegion, numVoie, typeVoie, voie, complement, codePostal, ville, nom,
				prenom, mail, tel, numVrp, nbCommande);
		
		CompteurProspect ++;
		this.numProspect = new SimpleIntegerProperty(CompteurProspect);
		
		this.setNbCommande(0);

		for(Representant vrp : MainApp.getVrp()){
			if(numVrp == (vrp.getNumVrp())){
				this.representant = new SimpleObjectProperty<Representant>(vrp);}}//end for


			
	} //end Constuctor	
	
	
	public Integer getNumProspect(){
		return numProspect.get();}
	
	public void setNumProspect(Integer numProspect){
		this.numProspect.set(numProspect);}
	
	public IntegerProperty numProspectProperty(){
		return numProspect;}

	public  void setRepresentant(Representant value){
		representant.set(value);}
	
	public Representant getRepresentant(){
		return representant.get();
	}
	
	
	
	
}// end Prospect