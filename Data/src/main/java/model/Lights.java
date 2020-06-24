package model;

public class Lights {

    private boolean turnSignalRight;

    private boolean turnSignalLeft;

    private boolean positionLights;

    private boolean lowBeam;

    private boolean highBeams;

    private boolean fogLightsRight;

    private boolean fogLightsLeft;

    public boolean isTurnSignalRight() {
        return turnSignalRight;
    }

    public void setTurnSignalRight(boolean turnSignalRight) {
        this.turnSignalRight = turnSignalRight;
    }

    public boolean isTurnSignalLeft() {
        return turnSignalLeft;
    }

    public void setTurnSignalLeft(boolean turnSignalLeft) {
        this.turnSignalLeft = turnSignalLeft;
    }

    public boolean isPositionLights() {
        return positionLights;
    }

    public void setPositionLights(boolean positionLights) {
        this.positionLights = positionLights;
    }

    public boolean isLowBeam() {
        return lowBeam;
    }

    public void setLowBeam(boolean lowBeam) {
        this.lowBeam = lowBeam;
    }

    public boolean isHighBeams() {
        return highBeams;
    }

    public void setHighBeams(boolean highBeams) {
        this.highBeams = highBeams;
    }

    public boolean isFogLightsRight() {
        return fogLightsRight;
    }

    public void setFogLightsRight(boolean fogLightsRight) {
        this.fogLightsRight = fogLightsRight;
    }

    public boolean isFogLightsLeft() {
        return fogLightsLeft;
    }

    public void setFogLightsLeft(boolean fogLightsLeft) {
        this.fogLightsLeft = fogLightsLeft;
    }
}
