package controllers;

import model.Lights;

public class LightsController {

    private Lights lights;

    public void switchTurnSignalRight() {
        lights.setTurnSignalRight(!lights.isTurnSignalRight());
    }

    public void switchTurnSignalLeft() {
        lights.setTurnSignalLeft(!lights.isTurnSignalLeft());
    }

    public void switchPositionLights() {
        lights.setPositionLights(!lights.isPositionLights());
    }

    public void switchLowBeam() {
        lights.setLowBeam(!lights.isLowBeam());
    }

    public void switchHighBeams() {
        lights.setHighBeams(!lights.isHighBeams());
    }

    public void switchFogLightsRight() {
        lights.setFogLightsRight(!lights.isFogLightsRight());
    }

    public void switchFogLightsLeft() {
        lights.setFogLightsLeft(!lights.isFogLightsLeft());
    }
}
