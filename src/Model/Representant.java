package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Classe Representant
 * 
 * @author Pauline G.
 */


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Representant {
	
	
	
	
	private final StringProperty numVrp;
	private final StringProperty nomVrp;
	private final StringProperty prenomVrp;
	private final StringProperty mailVrp;
	private final StringProperty telVrp;
	private final StringProperty regionVrp;
	private final IntegerProperty salaireVrp;
	private final IntegerProperty commVrp;

	
	
	public Representant(){
		this(null,null, null, null, null, null,0,0);
	}

	public Representant(String numVrp, String nomVrp, String prenomVrp,
			String mailVrp, String telVrp, String regionVrp, Integer salaireVrp, Integer commVrp) {

		this.numVrp = new SimpleStringProperty(numVrp);
		this.nomVrp = new SimpleStringProperty(nomVrp);
		this.prenomVrp = new SimpleStringProperty(prenomVrp);
		this.mailVrp = new SimpleStringProperty(mailVrp);
		this.telVrp = new SimpleStringProperty(telVrp);
		this.regionVrp = new SimpleStringProperty(regionVrp);
		this.salaireVrp = new SimpleIntegerProperty(salaireVrp);
		this.commVrp = new SimpleIntegerProperty(commVrp);}

	
	public String getNumVrp() {
		return numVrp.get();}

	public void setNumVrp(String numVrp) {
		this.numVrp.set(numVrp);}
	
	public StringProperty numVrpProperty(){
		return numVrp;}
	
	
	public String getNomVrp() {
		return nomVrp.get();}

	public void setNomVrp(String nomVrp) {
		this.nomVrp.set(nomVrp);}
	
	public StringProperty nomVrpProperty(){
		return nomVrp;}
	
	public String getPrenomVrp() {
		return prenomVrp.get();}

	public void setPrenomVrp(String prenomVrp) {
		this.prenomVrp.set(prenomVrp);}
	
	public StringProperty prenomVrpProperty(){
		return prenomVrp;}
	
	public String getMailVrp() {
		return mailVrp.get();}

	public void setMailVrp(String mailVrp) {
		this.mailVrp.set(mailVrp);}
	
	public StringProperty mailVrpProperty(){
		return mailVrp;}
	
	public String getTelVrp() {
		return telVrp.get();}

	public void setTelVrp(String telVrp) {
		this.telVrp.set(telVrp);}
	
	public StringProperty telVrpProperty(){
		return telVrp;}
	
	public Integer getSalaireVrp(){
		return salaireVrp.get();
	}
	
	public void setSalaireVrp(Integer salaireVrp) {
		this.salaireVrp.set(salaireVrp);}
	
	public IntegerProperty salaireVrpProperty(){
		return salaireVrp;
	}
	
	public Integer getCommVrp(){
		return commVrp.get();
	}

	public void setCommVrp(Integer commVrp) {
		this.commVrp.set(commVrp);}
	
	public IntegerProperty commVrpProperty(){
		return commVrp;
	}

	public String getregionVrp() {
		return regionVrp.get();}

	public void setRegionVrp(String regionVrp) {
		this.regionVrp.set(regionVrp);}
	
	public StringProperty regionVrpProperty(){
		return regionVrp;}

	
	public StringProperty representantProperty(){
			return new SimpleStringProperty(getNomVrp() + " " + getPrenomVrp());}


	@Override
	public String toString() {
		return  nomVrp + " " + prenomVrp;
	}
	


	
	
	
} //end Representant
