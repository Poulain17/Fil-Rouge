package Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe qui aide le Wrap de la TypeBox. Sert a sauvegarder les donnée
 * en XML
 * @author Pauline G.
 */

@XmlRootElement(name = "TypeBox")


public class TypeBoxListWrapper {
	private List<TypeBox> listTypeBox;
	
	@XmlElement(name = "Type")
	public List<TypeBox> getlistTypeBox(){
		return listTypeBox;}
	
	public void setListTypeBox(List<TypeBox>listTypeBox){
		this.listTypeBox = listTypeBox;}

}
