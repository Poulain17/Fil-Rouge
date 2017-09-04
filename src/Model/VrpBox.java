package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class VrpBox {
	
	private final IntegerProperty indexVrpBox;

	
	public VrpBox(){
		this.indexVrpBox = new SimpleIntegerProperty(10);

	}
	
	public VrpBox(Integer indexVrpBox){
		this.indexVrpBox = new SimpleIntegerProperty(indexVrpBox);	
	}
	
	public Integer getindexVrpBox(){
		return indexVrpBox.get();
	}
	
	public void setindexVrpBox(Integer indexVrpBox){
		this.indexVrpBox.set(indexVrpBox);
	}
	
	public IntegerProperty indexVrpBoxProperty(){
		return indexVrpBox;
	}
	
	@Override
	public String toString(){
		return this.getindexVrpBox() + " - " + this.getVrpBox();
	}
	
	

}
