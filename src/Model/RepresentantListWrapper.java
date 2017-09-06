package Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Classe qui  Wrap de la TypeBox. Sert a sauvegarder les donnée
 * en XML
 * @author Pauline G.
 */

@XmlRootElement(name = "Representant")

public class RepresentantListWrapper {


		private List<Representant> listRepresentant;
		
		@XmlElement(name = "NumVrp")
		public List<Representant> getlistRepresentant(){
			return listRepresentant;}
		
		public void setlistRepresentant(List<Representant>listTypeBox){
			this.listRepresentant = listTypeBox;}


}
