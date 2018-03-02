package practice.design.observer;/*
 * Package name:test1.design.observer
 * File name:CurrentConditionsDisplay.java
 * Date:2017-06-08 17:43
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
 * @since 2017-06-08 17:43
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay() {
    }

    public CurrentConditionsDisplay(Observable observable) {
        observable.addObserver(this);
    }


    @Override
    public void display() {
        System.out.println("Current conditions:" + temperature + "F degrees and " + humidity + "% humidity");
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