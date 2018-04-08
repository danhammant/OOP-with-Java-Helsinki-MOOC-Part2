package application;

import java.util.ArrayList;
import java.util.List;


public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensorList;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensorList = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensorList.add(sensor);
    }

    public List<Integer> readings() {
        return this.readings;
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : this.sensorList) {
            if (!sensor.isOn()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : this.sensorList) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : this.sensorList) {
            sensor.off();
        }

    }

    @Override
    public int measure() {
        if (!isOn() || this.sensorList.isEmpty()) {
            throw new IllegalStateException();
        }

        int average = 0;
        for (Sensor sensor : this.sensorList) {
            average += sensor.measure();
        }

        average = average / this.sensorList.size();

        this.readings.add(average);
        return average;
    }

}
