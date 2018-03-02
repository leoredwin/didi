/*
 * Package name:practice.design.command
 * File name:LightOnCommand.java
 * Date:2017-09-05 11:12
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.command;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-09-05 11:12
 */
public class LightOnCommand implements  Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}