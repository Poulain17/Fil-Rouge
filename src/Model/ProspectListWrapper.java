package Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe Wrap liste de Prospect.
 * Utiliser pour sauvegarder la liste de Prospect au format XML
 * 
 * @author Pauline G.
 *
 */

@XmlRootElement(name = "Prospect")

public class ProspectListWrapper {
	
	private List<Prospect> vrp;
	
/////////////////////////////// Getter/Setter \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
	
	 @XmlElement(name = "prospect")
	 public List<Prospect> getVrp(){	 
		 return vrp;}
	 
	 public void setVrp(List<Prospect>vrp){
		 this.vrp = vrp;}

}
