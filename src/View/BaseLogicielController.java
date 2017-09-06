package View;

import Controleur.MainApp;
import View.ProspectFrameContoller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;



public class BaseLogicielController {
	
	private MainApp mainApp;
	
	//test
	public void setMainApp(MainApp mainApp) {
		this.mainApp=mainApp;
	}

	@FXML
	private void HandleshowProspectFrame(){
		mainApp.showProspectFrame();}
	
	@FXML
	public void showRepresentantFrame(){
		mainApp.showVrpFrame();
	}
	
	@FXML
	public void showClientFrame(){
		mainApp.showClientFrame();
	}
	
	@FXML
	private void handleNewProspect(){
		}
	}

