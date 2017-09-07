package Model;



import Controleur.MainApp;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Classe Prospect fille de la Classe Societe
 * 
 * @author Pauline.G
 */

public class Client extends Societe{
	

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


		this.setNbCommande(1);
		
		for(Representant vrp : MainApp.getVrp()){
			if(numVrp == (vrp.getNumVrp())){
				this.representant = new SimpleObjectProperty<Representant>(vrp);} //end if	
		}//end for
	
		numVrpCompteur ++;
		String numCompteur = Integer.toString(numVrpCompteur);
		numVrp = numCompteur;
			
	} //end Constuctor	

		
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


	public String getRegion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}// End Client
