/*
 * Package name:practice.design.observer
 * File name:Subject.java
 * Date:2017-06-08 17:34
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.observer;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-08 17:34
 */
public interface Subject {

    void registerObserver(Observer observer);
    void removerObserver(Observer observer);
    void notifyObserver();
}