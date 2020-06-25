package controllers;

import model.OnBoardComputer;

public class ComputerController {

    private OnBoardComputer onBoardComputer;

    public ComputerController() {
        this.onBoardComputer = new OnBoardComputer();
    }

    public void updateAverageSpeed(float value, long counter) {
        onBoardComputer.setAverageSpeed((onBoardComputer.getAverageSpeed() * (counter - 1) + value) / counter);
    }

    public void updateMaxSpeed(float value) {
        if (value > onBoardComputer.getMaxSpeed()) {
            onBoardComputer.setMaxSpeed(value);
        }
    }

    public void updateAverageFuelConsumption(float speed){
        //TODO: nie ogarniam jak to zaimplementować, zostawiam
    }

    public void updateDistance(float value){
        onBoardComputer.setDistance(onBoardComputer.getDistance() + value);
    }

    public void setStartTime(long value){
        onBoardComputer.setTravelStart(value);
    }


}
