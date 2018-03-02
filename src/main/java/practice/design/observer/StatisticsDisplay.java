package practice.design.observer;/*
 * Package name:test1.design.observer
 * File name:StatisticsDisplay.java
 * Date:2017-06-08 17:52
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */


import java.util.Observable;
import java.util.Observer;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-08 17:52
 */
public class StatisticsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;

    public StatisticsDisplay() {
    }

    public StatisticsDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("statistics data :" + temperature + " , " + humidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}