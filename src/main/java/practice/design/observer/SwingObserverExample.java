/*
 * Package name:practice.design.observer
 * File name:SwingObserverExample.java
 * Date:2017-06-08 18:24
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package practice.design.observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-08 18:24
 */
public class SwingObserverExample {

    private JFrame jFrame;

    public static void main(String[] args) {
        SwingObserverExample swingObserverExample = new SwingObserverExample();
        swingObserverExample.go();
    }

    public void go() {
        jFrame = new JFrame();
        JButton button = new JButton("Should I do it?");
        button.addActionListener(new AnglListener());
        button.addActionListener(new DevillListener());
        jFrame.getContentPane().add(BorderLayout.CENTER, button);
    }

    class AnglListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it ,you might regret it!");
        }
    }

    class DevillListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Come on ,do it!");

        }
    }
}