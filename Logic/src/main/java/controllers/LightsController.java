package controllers;

import dao.Dao;
import dao.XmlLightsDao;
import model.Lights;

import java.io.IOException;

public class LightsController {

    private Lights lights;

    public LightsController() {
        this.lights = new Lights();
    }

    public Lights getLights() {
    	return this.lights;
    }
    
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

    public void saveConfig() throws IOException {
        Dao<Lights> lightsDao = new XmlLightsDao();
        lightsDao.write(this.lights);
    }

    public void loadConfig() throws IOException {
        Dao<Lights> lightsDao = new XmlLightsDao();
        this.lights = lightsDao.read();
    }
    
    public boolean isTurnSignalRight() {
        return lights.isTurnSignalRight();
    }



    public boolean isTurnSignalLeft() {
        return lights.isTurnSignalLeft();
    }



    public boolean isPositionLights() {
        return lights.isPositionLights();
    }



    public boolean isLowBeam() {
        return lights.isLowBeam();
    }



    public boolean isHighBeams() {
        return lights.isHighBeams();
    }


    public boolean isFogLightsRight() {
        return lights.isFogLightsRight();
    }


    public boolean isFogLightsLeft() {
        return lights.isFogLightsLeft();
    }

}
