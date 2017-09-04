package Model;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class TypeBox {

	private final IntegerProperty indexTypeBox;
	private final StringProperty typeBox;
	
	public TypeBox(){
		this.indexTypeBox = new SimpleIntegerProperty(1);
		this.typeBox = new SimpleStringProperty("Prospect");
	}

	public TypeBox(int indexTypeBox, String typeBox) {
		this.indexTypeBox = new SimpleIntegerProperty(indexTypeBox);
		this.typeBox = new SimpleStringProperty(typeBox);
	}
	
	
	public int getIndexTypeBox(){
		return indexTypeBox.get();
	}
	
	public void setIndexTypeBox(int indexTypeBox){
		this.indexTypeBox.set(indexTypeBox);
	}
	
	public IntegerProperty indexTypeBoxProperty(){
		return indexTypeBox;
	}
	
	public String getTypeBox(){
		return typeBox.get();
	}
	
	public void setTypeBox(String typeBox){
		this.typeBox.set(typeBox);
	}
	
	public StringProperty typeBoxProperty(){
		return typeBox;
	}
	
	@Override
	public String toString(){
		return this.getIndexTypeBox() + " - " + this.getTypeBox();
	}
	
	
}//End Class
