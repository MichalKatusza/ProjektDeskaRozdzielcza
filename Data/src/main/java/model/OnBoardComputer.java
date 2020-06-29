package model;

import java.sql.Timestamp;

public class OnBoardComputer {

    private double averageSpeed;

    private double maxSpeed;

    private float averageFuelConsumption;

    private double distance;

    private long travelStart;

    private long travelStop;

    public OnBoardComputer() {
        averageSpeed = 0;
        maxSpeed = 0;
        averageFuelConsumption = 0;
        distance = 0;
        travelStart = 0;
        travelStop = 0;
    }

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

    public long getTravelStart() {
        return travelStart;
    }

    public void setTravelStart(long travelStart) {
        this.travelStart = travelStart;
    }

    public long getTravelStop() {
        return travelStop;
    }

    public void setTravelStop(long travelStop) {
        this.travelStop = travelStop;
    }
}
