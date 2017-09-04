package Model;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import Controleur.MainApp;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

/**
 * Classe Prospect fille de la Classe Societe
 * 
 * @author Pauline.G
 */




public class Prospect extends Societe{
	

	
	private static int numVrpCompteur;
	private String numVrp;
	
public MainApp mainApp;

private ObjectProperty<Representant> representant;



	public Prospect(){}


	public Prospect(String raisonSociale, Integer siren, String region, Integer idCompany, Integer numVoie,
			String typeVoie, String voie, String complement, String codePostal, String ville, String nom, String prenom,
			String mail, String tel, String numVrp) {
		super(raisonSociale, siren, region, idCompany, numVoie, typeVoie, voie, complement, codePostal, ville, nom,
				prenom, mail, tel, numVrp);
		
		for(Representant vrp : MainApp.getVrp()){
			if(numVrp.equals(vrp.getNumVrp())){
				this.representant = new SimpleObjectProperty<Representant>(vrp);} //end if
			
			numVrpCompteur ++;
			String numCompteur = Integer.toString(numVrpCompteur);
			numVrp = numCompteur;
			
		}//end for
			
	} //end Constuctor	
		
		
	public int getnumVrpCompteur(){
		return numVrpCompteur;
	}
	
	public void setnumVrpCompteur(int numVrp){
		Prospect.numVrpCompteur = numVrpCompteur;
	}

	public  void setRepresentant(Representant value){
		representant.set(value);}
	
	public Representant getRepresentant(){
		return representant.get();
	}
	
	
	
	
}// end Prospect
