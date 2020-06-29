import controllers.ComputerController;
import controllers.CountersController;
import controllers.LightsController;
import controllers.SpeedometerController;
import dao.Jdbc;

import java.util.Timer;

public class Board {

    private ComputerController computerController;
    private CountersController countersController;
    private LightsController lightsController;
    private SpeedometerController speedometerController;
    private Timer timer;
    
    public Board() {
        this.computerController = new ComputerController();
        this.countersController = new CountersController();
        this.lightsController = new LightsController();
        this.speedometerController = new SpeedometerController();
        //this.timer.schedule(new Travel(computerController, countersController, speedometerController), 0, 1000);
    }

    public void killTimer(){
        this.timer.cancel();
    }

    public ComputerController getComputerController() {
        return computerController;
    }

    public CountersController getCountersController() {
        return countersController;
    }

    public LightsController getLightsController() {
        return lightsController;
    }

    public SpeedometerController getSpeedometerController() {
        return speedometerController;
    }

    public void saveBoard() {
        Jdbc jdbc = new Jdbc();
        jdbc.write(countersController.getCounters(), computerController.getOnBoardComputer(), speedometerController.getSpeedometer());
    }

    public void loadBoard() {
        Jdbc jdbc = new Jdbc();
        jdbc.read(countersController.getCounters(), computerController.getOnBoardComputer(), speedometerController.getSpeedometer());
    }


    public String toStringDoTestow() {
        return "Liczniki: " + countersController.getCounters().getTotalMileage() + " " + countersController.getCounters().getDailyMileage();
    }
    
    public Timer getTimer() {
    	return this.timer;	
    }

}
