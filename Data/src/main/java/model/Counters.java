package model;

public class Counters {

    private double totalMileage;

    private double dailyMileage;

    public Counters() {
        totalMileage = 0;
        dailyMileage = 0;
    }

    public double getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(double totalMileage) {
        this.totalMileage = totalMileage;
    }

    public double getDailyMileage() {
        return dailyMileage;
    }

    public void setDailyMileage(double dailyMileage) {
        this.dailyMileage = dailyMileage;
    }
}
