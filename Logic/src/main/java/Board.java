import controllers.ComputerController;
import controllers.CountersController;
import controllers.LightsController;
import controllers.SpeedometerController;

public class Board {

    private ComputerController computerController;
    private CountersController countersController;
    private LightsController lightsController;
    private SpeedometerController speedometerController;

    private boolean travel;

    public Board() {
        this.computerController = new ComputerController();
        this.countersController = new CountersController();
        this.lightsController = new LightsController();
        this.speedometerController = new SpeedometerController();
        this.travel = true;
    }

    public void travel(){

        while(travel){

        }
    }
}
