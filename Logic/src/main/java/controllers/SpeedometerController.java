package controllers;

import model.Speedometer;

public class SpeedometerController {

    private Speedometer speedometer;

    public SpeedometerController() {
        this.speedometer = new Speedometer();
    }

    public void speedUp() {
        float speed = speedometer.getSpeed() + 2f;
        if (speed > 280f) {
            speed = 280f;
        }
        speedometer.setSpeed(speed);
    }

    public void speedDown() {
        float speed = speedometer.getSpeed() - 2f;
        if (speed < 0f) {
            speed = 0f;
        }
        speedometer.setSpeed(speed);
    }

    public float getSpeed(){
        return speedometer.getSpeed();
    }

    public Speedometer getSpeedometer() {
        return speedometer;
    }
}
