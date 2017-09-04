package Model;


import Controleur.MainApp;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

/**
 * Classe Prospect fille de la Classe Societe
 * 
 * @author Pauline.G
 */


public class Prospect extends Societe{
	

	private final  IntegerProperty indexTypeBox;
	private static int numVrpCompteur;
	private String numVrp;
	public Prospect selectedProspect;
	
public MainApp mainApp;

private ObjectProperty<Representant> representant;


	public Prospect(){
		this(null,0,null,0,0,null,null,null,null,null,null,null,null,null,null,0);}


	public Prospect(String raisonSociale, Integer siren, String region, Integer idCompany, Integer numVoie,
			String typeVoie, String voie, String complement, String codePostal, String ville, String nom, String prenom,
			String mail, String tel, String numVrp, Integer nbCommande) {
		super(raisonSociale, siren, region, idCompany, numVoie, typeVoie, voie, complement, codePostal, ville, nom,
				prenom, mail, tel, numVrp, nbCommande);
		this.indexTypeBox = new SimpleIntegerProperty(01);
		this.setNbCommande(0);
		
		for(Representant vrp : MainApp.getVrp()){
			if(numVrp.equals(vrp.getNumVrp())){
				this.representant = new SimpleObjectProperty<Representant>(vrp);} //end if	
		}//end for
	
		numVrpCompteur ++;
		String numCompteur = Integer.toString(numVrpCompteur);
		numVrp = numCompteur;
			
	} //end Constuctor	
	
	
	
	
	public Integer getIndexTypeBox(){
		return indexTypeBox.get();
	}
	
	public void setIndexTypeBox(Integer indexTypeBox){
		this.indexTypeBox.set(indexTypeBox);
	}
	
	public IntegerProperty indexTypeBoxProperty(){
		return indexTypeBox;
	}
		
	public int getnumVrpCompteur(){
		return numVrpCompteur;
	}
	
	public void setnumVrpCompteur(int numVrp){
		numVrpCompteur = numVrpCompteur;
	}

	public  void setRepresentant(Representant value){
		representant.set(value);}
	
	public Representant getRepresentant(){
		return representant.get();
	}
	
	
	
	
}// end Prospect

