package Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Sauvegarde des selections aux Format XML .
 * 
 * @author Pauline G.
 *
 */



@XmlRootElement(name = "data")
@XmlType(propOrder = {"client","prospect","representant"})

public class MetierListWrapper {

	///////////////////// CLIENT \\\\\\\\\\\\\\\\\\
	
	private List<Client> client;
	
	@XmlElement(name = "client")
	public List<Client> getClient(){	
		return  (List<Client>) client;}
	
	public void setClient(List<Client>client){
		this.client = client;}
		
	///////////////////// PROSPECT \\\\\\\\\\\\\\\\\\
	
	private List<Prospect> prospect;
	
	 @XmlElement(name = "prospect")
	 public List<Prospect> getProspect(){	 
		 return (List<Prospect>)prospect;}
	
	 public void setProspect(List<Prospect>prospect){
		 this.prospect = prospect;}

	 ///////////////////// REPRESENTANT \\\\\\\\\\\\\\\\\\
	 
	 private List<Representant> Representant;

		@XmlElement(name = "representant")
		public List<Representant> getRepresentant(){
			return (List<Representant>)Representant;}
		
		public void setRepresentant(List<Representant>listRepresentant){
			this.Representant = listRepresentant;}


} //end DataWrapper
