package Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListRegionBox")


public class RegionBoxListWrapper {
	private List<RegionBox> listRegionBox;
	
	@XmlElement(name = "Region")
	public List<RegionBox> getlistRegionBox(){
		return listRegionBox;}
	
	public void setListRegionBox(List<RegionBox>listRegionBox){
		this.listRegionBox = listRegionBox;}

}
