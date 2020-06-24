import java.sql.Timestamp;

public class OnBoardComputer {

    private double averageSpeed;

    private double maxSpeed;

    private float averageFuelConsumption;

    private double distance;

    private Timestamp travelStart;

    private Timestamp travelStop;

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public void setAverageFuelConsumption(float averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Timestamp getTravelStart() {
        return travelStart;
    }

    public void setTravelStart(Timestamp travelStart) {
        this.travelStart = travelStart;
    }

    public Timestamp getTravelStop() {
        return travelStop;
    }

    public void setTravelStop(Timestamp travelStop) {
        this.travelStop = travelStop;
    }
}
