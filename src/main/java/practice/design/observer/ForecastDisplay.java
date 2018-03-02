package practice.design.observer;/*
 * Package name:test1.design.observer
 * File name:ForecastDisplay.java
 * Date:2017-06-08 18:13
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
 * @since 2017-06-08 18:13
 */
public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("currentPressure :" + currentPressure);
    }


}