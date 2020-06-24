package controllers;

import model.Speedometer;

public class SpeedometerController {

    private Speedometer speedometer;


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


}
