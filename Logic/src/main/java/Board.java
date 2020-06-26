import controllers.ComputerController;
import controllers.CountersController;
import controllers.LightsController;
import controllers.SpeedometerController;
import dao.Jdbc;

import java.util.Timer;

public class Board {

    private final ComputerController computerController;
    private final CountersController countersController;
    private final LightsController lightsController;
    private final SpeedometerController speedometerController;

    public Board() {
        this.computerController = new ComputerController();
        this.countersController = new CountersController();
        this.lightsController = new LightsController();
        this.speedometerController = new SpeedometerController();
        new Timer().schedule(new Travel(computerController, countersController, speedometerController), 0, 1000);
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
}
