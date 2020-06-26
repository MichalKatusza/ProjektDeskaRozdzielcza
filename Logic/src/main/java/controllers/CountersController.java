package controllers;

import model.Counters;

public class CountersController {

    private Counters counters;

    public CountersController() {
        this.counters = new Counters();
    }

    public void updateMileage(double value) {
        counters.setTotalMileage(counters.getTotalMileage() + value);
    }

    public void updateDailyMileage(double value){
        counters.setDailyMileage(counters.getDailyMileage() + value);
    }

    public void resetDailyMileage(){
        counters.setDailyMileage(0);
    }

    public Counters getCounters() {
        return counters;
    }
}
