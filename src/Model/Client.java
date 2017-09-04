package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {

	
	private StringProperty type;
	
	private Client(){
		this.type = new SimpleStringProperty(type);
	}
	
	public String getType(){
		return type.get();
	}
	
	public void setType(String type){
		this.type.set(type);
	}
}


