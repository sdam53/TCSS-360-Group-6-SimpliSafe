package sample;

import model.*;

import java.util.ArrayList;

public class Controller {

    /** Array of smoke detector objects */
    private ArrayList<SmokeDetector> smokeDetectors = new ArrayList<>();

    /** Array of co detector objects */
    private ArrayList<CODetector> coDetectors = new ArrayList<>();

    /** Array of glass break sensor objects */
    private ArrayList<GlassBreakSensor> glassBreakSensors = new ArrayList<>();

    /** Array of entry sensor objects */
    private ArrayList<EntrySensor> entrySensors = new ArrayList<>();

    /** Array of motion sensor objects */
    private ArrayList<MotionSensor> motionSensors = new ArrayList<>();

    /** Array of temperature sensor objects */
    private ArrayList<TemperatureSensor> temperatureSensors = new ArrayList<>();

    /** Array of water sensor objects */
    private ArrayList<WaterSensor> waterSensors = new ArrayList<>();

    //Simulator class will contain the array of each device in order to change its status for testing
    //private Simulator simulator = new Simulator(smokeDetectors, coDetectors, glassBreakSensors, entrySensors,
    //                                           motionSensors, temperatureSensors, waterSensors);

    public Controller() {

    }

    /**
     * returns smokeDetectors ArrayList
     * @return smokeDetectors ArrayList
     */
    public ArrayList<SmokeDetector> getSmokeDetectors() {
        return smokeDetectors;
    }

    public ArrayList<CODetector> getCoDetectors() {
        return coDetectors;
    }

    public ArrayList<GlassBreakSensor> getGlassBreakSensors() {
        return glassBreakSensors;
    }

    public ArrayList<EntrySensor> getEntrySensors() {
        return entrySensors;
    }

    public ArrayList<MotionSensor> getMotionSensors() {
        return motionSensors;
    }

    public ArrayList<TemperatureSensor> getTemperatureSensors() {
        return temperatureSensors;
    }

    public ArrayList<WaterSensor> getWaterSensors() {
        return waterSensors;
    }

    /**
     * add new Smoke Detector object
     * @param name name of smoke detector
     */
    public void addSmokeDetector(String name) {
        this.smokeDetectors.add(new SmokeDetector(name));
    }

    public void addCODetector(String name) {
        this.coDetectors.add(new CODetector(name));
    }

    public void addGlassBreakSensor(String name) {
        this.glassBreakSensors.add(new GlassBreakSensor(name));
    }

    public void addEntrySensor(String name) {
        this.entrySensors.add(new EntrySensor(name));
    }

    public void addMotionSensor(String name) {
        this.motionSensors.add(new MotionSensor(name));
    }

    public void addTemperatureSensor(String name) {
        this.temperatureSensors.add(new TemperatureSensor(name));
    }

    public void addWaterSensor(String name) {
        this.waterSensors.add(new WaterSensor(name));
    }
}
