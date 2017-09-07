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
@XmlType(propOrder = {"Client","Prospect","Representant"})

public class MetierListWrapper {

	///////////////////// CLIENT \\\\\\\\\\\\\\\\\\
	
	private List<Client> client;
	


	@XmlElementWrapper(name = "Client")
	@XmlElement(name = "client")
	public List<Client> getListClient(){	
		return  (List<Client>) client;}
	
	public void setListClient(List<Client>client){
		this.client = client;}
		
	///////////////////// PROSPECT \\\\\\\\\\\\\\\\\\
	
	private List<Prospect> prospect;
	
	 @XmlElementWrapper(name = "Prospect")
	 @XmlElement(name = "Prospect")
	 public List<Prospect> getListProspect(){	 
		 return (List<Prospect>)prospect;}
	
	 public void setListProspect(List<Prospect>prospect){
		 this.prospect = prospect;}

	 ///////////////////// REPRESENTANT \\\\\\\\\\\\\\\\\\
	 
	 private List<Representant> listRepresentant;
		
	 	@XmlElementWrapper(name = "Representant")
		@XmlElement(name = "Representant")
		public List<Representant> getlistRepresentant(){
			return (List<Representant>)listRepresentant;}
		
		public void setlistRepresentant(List<Representant>listRepresentant){
			this.listRepresentant = listRepresentant;}
		
		
		///////////////////// REGION BOX \\\\\\\\\\\\\\\\\\
	
		/*private List<RegionBox> listRegionBox;
		
		@XmlElementWrapper(name = "RegionBox")
		@XmlElement(name = "Region Box")
		public List<RegionBox> getlistRegionBox(){
			return listRegionBox;}
		
		public void setListRegionBox(List<RegionBox>listRegionBox){
			this.listRegionBox = listRegionBox;}*/
		
		
		///////////////////// TYPE BOX \\\\\\\\\\\\\\\\\\

		/*private List<TypeBox> listTypeBox;
		
		@XmlElementWrapper(name = "TypeBox")
		@XmlElement(name = "Type Box")
		public List<TypeBox> getlistTypeBox(){
			return listTypeBox;}
		
		public void setListTypeBox(List<TypeBox>listTypeBox){
			this.listTypeBox = listTypeBox;}*/

} //end DataWrapper
