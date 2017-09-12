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
	
	protected StringProperty raisonSociale;
	protected IntegerProperty siren;
	protected IntegerProperty numVoie;
	protected StringProperty voie;
	protected StringProperty typeVoie;
	protected StringProperty complement;
	protected StringProperty codePostal;
	protected StringProperty ville;
	protected IntegerProperty indexRegion;
	protected StringProperty nom;
	protected StringProperty prenom;
	protected StringProperty mail;
	protected StringProperty tel;
	protected StringProperty numVrp;
	protected IntegerProperty nbCommande;
	protected IntegerProperty indexType;



	public MainApp mainApp;
	Representant representant;
	TypeVoieBox typeBox;




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
		this(null,0,0,0,null,null,null,null,null,null,null,null,null,null,0);
		
	}

	public Societe(String raisonSociale, Integer siren, Integer indexRegion, Integer numVoie, String typeVoie, String voie, 
			String complement, String codePostal, String ville, String nom, String prenom, String mail, String tel, String numVrp, Integer nbCommande) {


		this.raisonSociale = new SimpleStringProperty(raisonSociale);
		this.siren = new SimpleIntegerProperty(siren);
		this.indexRegion = new SimpleIntegerProperty(indexRegion);
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
		this.nbCommande = new SimpleIntegerProperty(nbCommande);}
	
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

	public Integer getNumVoie() {
		return numVoie.get();}
	
	public void setNumVoie(Integer numVoie){
		this.numVoie.set(numVoie);}
	
	public IntegerProperty numVoieProperty(){
		return numVoie;}
	
	public String getTypeVoie() {
		return typeVoie.get();}
	
	public void setTypeVoie(String typeVoie){
		this.typeVoie.set(typeVoie);}
	
	public StringProperty typeVoieProperty(){
		return typeVoie;}

	public String getVoie() {
		return voie.get();}
	
	public void setVoie(String voie){
		this.voie.set(voie);}
	
	public StringProperty voieProperty(){
		return voie;}

	public String getComplement() {
		return complement.get();}
	
	public void setComplement(String complement){
		this.complement.set(complement);}
	
	public StringProperty complementProperty(){
		return complement;}

	public String getCodePostal() {
		return codePostal.get();}
	
	public void setCodePostal(String codePostal){
		this.codePostal.set(codePostal);}
	
	public StringProperty codePostalProperty(){
		return codePostal;}

	public String getVille() {
		return ville.get();}
	
	public void setVille(String ville){
		this.ville.set(ville);}
	
	public StringProperty villeProperty(){
		return ville;}
	
	public Integer getIndexRegion() {
		return indexRegion.get();}
	
	public void setIndexRegion(Integer indexRegion){
		this.indexRegion.set(indexRegion);}
	
	public IntegerProperty indexRegionProperty(){
		return indexRegion;}
	
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
	

}// End Class

