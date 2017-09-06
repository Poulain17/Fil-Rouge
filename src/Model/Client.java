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

public class Client extends Societe{
	
	private final  IntegerProperty indexTypeBox;
	private final IntegerProperty indexRegionBox;
	private final IntegerProperty indexNumVrpBox;

	private static int numVrpCompteur;
	private String numVrp;
	int indexClient = 2;
	
public MainApp mainApp;

private ObjectProperty<Representant> representant;



	public Client(){
		this(null,0,null,0,0,null,null,null,null,null,null,null,null,null,null,0);}


	public Client(String raisonSociale, Integer siren, String region, Integer idCompany, Integer numVoie,
			String typeVoie, String voie, String complement, String codePostal, String ville, String nom, String prenom,
			String mail, String tel, String numVrp, Integer nbCommande) {
		super(raisonSociale, siren, region, idCompany, numVoie, typeVoie, voie, complement, codePostal, ville, nom,
				prenom, mail, tel, numVrp, nbCommande);
		this.indexTypeBox = new SimpleIntegerProperty(02);
		this.indexRegionBox = new SimpleIntegerProperty(0);
		this.indexNumVrpBox = new SimpleIntegerProperty(0);
		this.setNbCommande(1);
		
		for(Representant vrp : MainApp.getVrp()){
			if(numVrp == (vrp.getNumVrp())){
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
	
	public Integer getIndexNumVrpBox(){
		return indexNumVrpBox.get();
	}
	
	public void setIndexNumVrpBox(Integer indexNumVrpBox){
		this.indexNumVrpBox.set(indexNumVrpBox);
	}
	
	public IntegerProperty indexNumVrpBoxProperty(){
		return indexNumVrpBox;
	}
	
	public Integer getIndexRegionBox(){
		return indexTypeBox.get();
	}
	
	public void setIndexRegionBox(Integer indexRegionBox){
		this.indexRegionBox.set(indexRegionBox);
	}
	
	public IntegerProperty indexRegionBoxProperty(){
		return indexRegionBox;
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
