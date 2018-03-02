/*
 * Package name:practice.design.observer
 * File name:WeatherData.java
 * Date:2017-06-08 17:37
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.observer;

import java.util.Observable;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-08 17:37
 */
public class WeatherData extends Observable{
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}