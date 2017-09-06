package Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe Wrap liste Client.
 * Utiliser pour sauvegarder la liste de Client au format XML
 * 
 * @author Pauline G.
 *
 */

@XmlRootElement(name = "Client")

public class ClientListWrapper {
	

		private List<Client> client;
		
	/////////////////////////////// Getter/Setter \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
		
		 @XmlElement(name = "client")
		 public List<Client> getClient(){	 
			 return client;}
		 
		 public void setClient(List<Client>client){
			 this.client = client;}

}
