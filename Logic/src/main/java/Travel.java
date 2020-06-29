import controllers.ComputerController;
import controllers.CountersController;
import controllers.SpeedometerController;

import java.util.TimerTask;

public class Travel extends TimerTask {

    private ComputerController computerController;
    private CountersController countersController;
    private SpeedometerController speedometerController;
    private long counter = 0;

    public Travel() {};
    
    public Travel(ComputerController computerController, CountersController countersController, SpeedometerController speedometerController) {
        this.computerController = computerController;
        this.countersController = countersController;
        this.speedometerController = speedometerController;
        this.computerController.setStartTime(System.currentTimeMillis());
    }

    @Override
    public void run() {
        counter++;

        float speed = speedometerController.getSpeed();

        countersController.updateMileage((speed*1000/3600));
        countersController.updateDailyMileage((speed*1000/3600));

        computerController.updateAverageSpeed(speed,counter);
        computerController.updateMaxSpeed(speed);
        //computerController.updateAverageFuelConsumption(speed);
        computerController.updateDistance((speed*1000/3600));

    }
    
    

}
