package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegionBox {
	

	private final IntegerProperty indexRegionBox;
	private final StringProperty regionBox;
	
	public RegionBox(){
		this.indexRegionBox = new SimpleIntegerProperty();
		this.regionBox = new SimpleStringProperty();}

	public RegionBox(int indexRegionBox, String regionBox) {
		this.indexRegionBox = new SimpleIntegerProperty(indexRegionBox);
		this.regionBox = new SimpleStringProperty(regionBox);
	}
	
	
	public int getIndexRegionBox(){
		return indexRegionBox.get();
	}
	
	public void setIndexRegionBox(int indexRegionBox){
		this.indexRegionBox.set(indexRegionBox);
	}
	
	public IntegerProperty indexRegionBoxProperty(){
		return indexRegionBox;
	}
	
	public String getRegionBox(){
		return regionBox.get();
	}
	
	public void setRegionBox(String regionBox){
		this.regionBox.set(regionBox);
	}
	
	public StringProperty regionBoxProperty(){
		return regionBox;
	}
	
	@Override
	public String toString(){
		return this.getIndexRegionBox() + " - " + this.getRegionBox();
	}
	

}
