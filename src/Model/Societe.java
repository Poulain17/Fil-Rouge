package Model;



/**
 * Classe Mère Societe
 * 
 * @author Pauline G.
 */
import Controleur.MainApp;
import Model.Representant;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Societe {
	
	private final StringProperty raisonSociale;
	private final IntegerProperty siren;
	private final IntegerProperty idCompany;
	private final IntegerProperty numVoie;
	private final StringProperty typeVoie;
	private final StringProperty voie;
	private final StringProperty complement;
	private final StringProperty codePostal;
	private final StringProperty ville;
	private final StringProperty region;
	private final StringProperty nom;
	private final StringProperty prenom;
	private final StringProperty mail;
	private final StringProperty tel;
	private final StringProperty numVrp;
	private final IntegerProperty nbCommande;
	private final IntegerProperty indexTypeBox;
	private final IntegerProperty indexNumVrpBox;

	public MainApp mainApp;
	Representant representant;
	TypeBox typeBox;




	/**
     * Constructeur
     * 
     * @param typeLabel
     * @param raisonSocialeLabel
     * @param sirenLabel
     * @param idCompanyLabel
     * @param numVoieLabel
     * @param typeVoieLabel
     * @param voieLabel
     * @param complementLabel
     * @param codePostalLabel
     * @param villeLabel
     * @param nomLabel
     * @param PrenomLabel
     * @param mailLabel
     * @param telLabel
     * @param numVrp
     * 
     */
	

	
	public Societe(){
		this(null,0,null,0,0,null,null,null,null,null,null,null,null,null,null,0);
		
	}

	public Societe(String raisonSociale, Integer siren, String region, Integer idCompany, Integer numVoie, String typeVoie, String voie, 
			String complement, String codePostal, String ville, String nom, String prenom, String mail, String tel, String numVrp, Integer nbCommande) {

		this.raisonSociale = new SimpleStringProperty(raisonSociale);
		this.siren = new SimpleIntegerProperty(siren);
		this.region = new SimpleStringProperty(typeBox.toString());
		this.idCompany = new SimpleIntegerProperty(idCompany);
		this.numVoie = new SimpleIntegerProperty(numVoie);
		this.typeVoie = new SimpleStringProperty(typeVoie);
		this.voie = new SimpleStringProperty(voie);
		this.complement = new SimpleStringProperty(complement);
		this.codePostal = new SimpleStringProperty(codePostal);
		this.ville = new SimpleStringProperty(ville);
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.mail = new SimpleStringProperty(mail);
		this.tel = new SimpleStringProperty(tel);
		this.numVrp = new SimpleStringProperty(numVrp);
		this.nbCommande = new SimpleIntegerProperty(nbCommande);
		this.indexTypeBox = new SimpleIntegerProperty();
		this.indexNumVrpBox = new SimpleIntegerProperty();}
	
	public void  setMainApp(MainApp mainApp){
		mainApp = mainApp;
		}
	
	public void setRepresentant (Representant vrp){
		vrp = vrp;	
	}
	
	public void setClient (Client client){
		client = client;
	}

	
	public String getRaisonSociale() {
		return raisonSociale.get();}
	
	public void setRaisonSociale(String raisonSociale){
		this.raisonSociale.set(raisonSociale);}
	
	public StringProperty raisonSocialeProperty(){
		return raisonSociale;}

	public Integer getSiren() {
		return siren.get();}
	
	public void setSiren(Integer siren){
		this.siren.set(siren);}
	
	public IntegerProperty sirenProperty(){
		return siren;}

	public Integer getIdCompany() {
		return idCompany.get();}

	public void setIdCompany(Integer idCompany){
		this.idCompany.set(idCompany);}

	public Integer getNumVoie() {
		return numVoie.get();}
	
	public void setNumVoie(Integer numVoie){
		this.numVoie.set(numVoie);}

	public String getTypeVoie() {
		return typeVoie.get();}
	
	public void setTypeVoie(String typeVoie){
		this.typeVoie.set(typeVoie);}

	public String getVoie() {
		return voie.get();}
	
	public void setVoie(String voie){
		this.voie.set(voie);}

	public String getComplement() {
		return complement.get();}
	
	public void setComplement(String complement){
		this.complement.set(complement);}

	public String getCodePostal() {
		return codePostal.get();}
	
	public void setCodePostal(String codePostal){
		this.codePostal.set(codePostal);}

	public String getVille() {
		return ville.get();}
	
	public void setVille(String ville){
		this.ville.set(ville);}
	
	public String getRegion() {
		return region.get();}
	
	public void setRegion(String region){
		this.region.set(typeBox.toString());}
	
	public StringProperty regionProperty(){
		return region;}
	
	public String getNom() {
		return nom.get();}
	
	public void setNom(String nom){
		this.nom.set(nom);}
	
	public StringProperty nomProperty(){
		return nom;}
	
	public String getPrenom() {
		return prenom.get();}
	
	public void setPrenom(String prenom){
		this.prenom.set(prenom);}
	
	public StringProperty prenomProperty(){
		return prenom;}
	
	public String getMail() {
		return mail.get();}
	
	public void setMail(String mail){
		this.mail.set(mail);}
	
	public StringProperty mailProperty(){
		return mail;}
	
	public String getTel() {
		return tel.get();}
	
	public void setTel(String tel){
		this.tel.set(tel);}
	
	public StringProperty telProperty(){
		return tel;}

	public String getNumVrp(){
		return numVrp.get();}
	
	public void setNumVrp(String numVrp){
		this.numVrp.set(numVrp);}
	
	public StringProperty numVrpProperty(){
		return numVrp;}
	
	public Integer getNbCommande() {
		return nbCommande.get();}
	
	public void setNbCommande(Integer nbCommande){
		this.nbCommande.set(nbCommande);}
	
	public IntegerProperty nbCommandeProperty(){
		return nbCommande;}
	
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
	

}// End Class

