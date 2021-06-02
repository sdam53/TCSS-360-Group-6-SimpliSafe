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
}
