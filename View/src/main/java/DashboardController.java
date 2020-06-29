import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class DashboardController {
	
	Board board = new Board();
	long xd;
	
	public void initialize() {
		
		board.loadBoard();
		
    	//board.getComputerController().getOnBoardComputer().setDistance(10.0);
    	//board.getComputerController().getOnBoardComputer().setAverageSpeed(35.0);
    	//board.getComputerController().getOnBoardComputer().setMaxSpeed(180.0);
    	//board.getCountersController().getCounters().setDailyMileage(15.0);
		//board.getCountersController().getCounters().setTotalMileage(30000.0);
		//board.getComputerController().getOnBoardComputer().setTravelStart(10);
		//board.getComputerController().getOnBoardComputer().setTravelStop(20);
		//board.getComputerController().getOnBoardComputer().setAverageFuelConsumption(6.7f);
		
		
		//this.xd = (board.getComputerController().getOnBoardComputer().getTravelStop() - board.getComputerController().getOnBoardComputer().getTravelStart());
    	//czasPodr.setText(xd+" h");
		
		this.przebiegCalkowity.setText(board.getCountersController().getCounters().getTotalMileage()+" km");
    	this.przebiegDzienny.setText(board.getCountersController().getCounters().getDailyMileage()+" km");
    	this.predkoscMax.setText(board.getComputerController().getOnBoardComputer().getMaxSpeed()+" km/h");
    	this.predkoscSrednia.setText(board.getComputerController().getOnBoardComputer().getAverageSpeed()+" km/h");
    	this.dystans.setText(board.getComputerController().getOnBoardComputer().getDistance()+" km");
    	this.przebiegCalkowity1.setText(board.getSpeedometerController().getSpeed()+" km/h");
    	
    	//board.getComputerController().getOnBoardComputer().setTravelStart(travelStart);
    	//Travel lol = new Travel(board.getComputerController(), board.getCountersController(), board.getSpeedometerController());
    	//board.getTimer().schedule(lol, 0, 1000);
    	
    	
    	
    	try {
			board.getLightsController().loadConfig();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	if(board.getLightsController().isFogLightsLeft()==true)
    		this.kierLewo.setSelected(true);
    	if(board.getLightsController().isFogLightsRight()==true)
    		this.kierPrawo.setSelected(true);
    	if(board.getLightsController().isHighBeams()==true)
    		this.drogowe.setSelected(true);
    	if(board.getLightsController().isLowBeam()==true)
    		this.mijania.setSelected(true);
    	if(board.getLightsController().isPositionLights()==true)
    		this.pozycyjne.setSelected(true);
    	if(board.getLightsController().isFogLightsLeft()==true)
    		this.przeciwmPrzod.setSelected(true);
    	if(board.getLightsController().isFogLightsRight()==true)
    		this.przeciwmTyl.setSelected(true);
		
	}

    @FXML
    private Button buttonW;

    @FXML
    private Button buttonA;

    @FXML
    private Button buttonS;

    @FXML
    private TextField przebiegCalkowity;

    @FXML
    private TextField przebiegDzienny;

    @FXML
    private RadioButton kierLewo;

    @FXML
    private RadioButton kierPrawo;

    @FXML
    private RadioButton pozycyjne;

    @FXML
    private RadioButton mijania;

    @FXML
    private RadioButton drogowe;

    @FXML
    private RadioButton przeciwmPrzod;

    @FXML
    private RadioButton przeciwmTyl;

    @FXML
    private TextField predkoscMax;

    @FXML
    private TextField czasPodr;

    @FXML
    private TextField predkoscSrednia;

    @FXML
    private TextField dystans;

    @FXML
    private Button stopbutton;

    @FXML
    private Button settings;

    @FXML
    private Button buttonD;

    @FXML
    private TextField przebiegCalkowity1;

    @FXML
    private Button resetbutton;

    @FXML
    void A(KeyEvent event) {

    }

    @FXML
    void D(KeyEvent event) {

    }

    @FXML
    void S(KeyEvent event) {
    	if (event.getCode() == KeyCode.S)
    		board.getSpeedometerController().speedDown();
    		przebiegCalkowity1.setText(board.getSpeedometerController().getSpeed()+" km/h");
    }

    @FXML
    void W(KeyEvent event) {
    	if (event.getCode() == KeyCode.W)
    		board.getSpeedometerController().speedUp();
    		przebiegCalkowity1.setText(board.getSpeedometerController().getSpeed()+" km/h");
    }

    @FXML
    void czaspodrozy(ActionEvent event) {
    	
    }

    @FXML
    void drivingBack(ActionEvent event) {
    		board.getSpeedometerController().speedDown();
    		przebiegCalkowity1.setText(board.getSpeedometerController().getSpeed()+" km/h");
    		
    }

    @FXML
    void drivingForward(ActionEvent event) {
    		board.getSpeedometerController().speedUp();
    		przebiegCalkowity1.setText(board.getSpeedometerController().getSpeed()+" km/h");
    }

    @FXML
    void drivingLeft(ActionEvent event) {

    }

    @FXML
    void drivingRght(ActionEvent event) {

    }

    @FXML
    void dystans(ActionEvent event) {

    }

    @FXML
    void kierunekLewo(ActionEvent event) {

    }

    @FXML
    void kierunekPrawo(ActionEvent event) {

    }

    @FXML
    void licznikcalkowity(ActionEvent event) {
    	//double newTotal = board.getCountersController().getCounters().getTotalMileage();
    	//board.getCountersController().updateMileage(newTotal);
    }

    @FXML
    void licznikdzienny(ActionEvent event) {

    }

    @FXML
    void podrozStart(ActionEvent event) {

    }

    @FXML
    void podrozStop(ActionEvent event) {

    		board.saveBoard();
    		try {
				board.getLightsController().saveConfig();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

    	}
    }

    @FXML
    void predkosciomierz(ActionEvent event) {
    	
    }

    @FXML
    void predkoscmax(ActionEvent event) {

    }

    @FXML
    void predkoscsrednia(ActionEvent event) {

    }

    @FXML
    void resetprzebieg(ActionEvent event) {

    		board.getCountersController().resetDailyMileage();
    		przebiegDzienny.setText(board.getCountersController().getCounters().getDailyMileage()+" km");

    }

    @FXML
    void settingsAction(ActionEvent event) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/DialogPane.fxml"));
    		Parent rootl = (Parent) fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setTitle("Ustawienia");
    		stage.setScene(new Scene(rootl));
    		stage.show();
    	} catch (Exception e) {
    		System.out.println("Cant load new window");
    	}
    }

    @FXML
    void swiatlaDrogowe(ActionEvent event) {
    	
    	if(drogowe.isSelected()==true)
    		board.getLightsController().getLights().setHighBeams(true); 
    	
    	if(drogowe.isSelected()==false)
    		board.getLightsController().getLights().setHighBeams(false);	
    }

    @FXML
    void swiatlaMgielnePrzod(ActionEvent event) {
    	if(przeciwmPrzod.isSelected()==true)
    		board.getLightsController().getLights().setFogLightsLeft(true);
    	
    	if(przeciwmPrzod.isSelected()==false)
    		board.getLightsController().getLights().setFogLightsLeft(false);	
    }

    @FXML
    void swiatlaMgielneTyl(ActionEvent event) {
    	if(przeciwmTyl.isSelected()==true)
    		board.getLightsController().getLights().setFogLightsRight(true);
    	
    	if(przeciwmTyl.isSelected()==false)
    		board.getLightsController().getLights().setFogLightsRight(false);
    }

    @FXML
    void swiatlaMijania(ActionEvent event) {
    	if(mijania.isSelected()==true)
    		board.getLightsController().getLights().setLowBeam(true);
    	
    	if(mijania.isSelected()==false)
    		board.getLightsController().getLights().setLowBeam(false); 	
    }

    @FXML
    void swiatlaPozycyjne(ActionEvent event) {
    	if(pozycyjne.isSelected()==true)
    		board.getLightsController().getLights().setPositionLights(true);
    	
    	if(pozycyjne.isSelected()==false)
    		board.getLightsController().getLights().setPositionLights(false);
    }

}
