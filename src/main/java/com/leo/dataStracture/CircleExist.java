/*
 * Package name:com.leo.dataStracture
 * File name:CircleExist.java
 * Date:2018-01-17 10:31
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.dataStracture;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-17 10:31
 */
public class CircleExist {

    public Node existCircle(Node head) {
        Node fest = head;
        Node slow = head;
        int step = 1;
        while (fest != null && fest.getNext() != null) {
            fest = fest.getNext().getNext();
            slow = slow.getNext();
            if (fest == slow) {
                System.out.println("存在环节值为:" + slow.getValue());
                int count = 0;
                while (true) {
                    fest = fest.getNext().getNext();
                    slow = slow.getNext();
                    count++;
                    if (fest == slow) {
                        System.out.println("环的长度为:" + count);
                        break;
                    }
                }

                fest = head;
                while (fest != slow) {
                    fest = fest.getNext();
                    slow = slow.getNext();
                    step++;
                }
                System.out.println("环入口点为:" + step);
                return slow;
            }
        }
        System.out.println("不存在环");
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node3);

        CircleExist circleExist = new CircleExist();
        circleExist.existCircle(head);

    }

}