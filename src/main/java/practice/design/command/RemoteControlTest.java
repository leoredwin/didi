/*
 * Package name:practice.design.command
 * File name:RemoteControlTest.java
 * Date:2017-09-05 11:15
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.command;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-09-05 11:15
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}