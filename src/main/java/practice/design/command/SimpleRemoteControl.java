/*
 * Package name:practice.design.command
 * File name:SimpleRemoteControl.java
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
public class SimpleRemoteControl {
    Command command;

    public SimpleRemoteControl() {
    }

    public SimpleRemoteControl(Command command) {
        this.command = command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }


    public void  buttonWasPressed(){
//        command.execult();
    }
}