/*
 * Package name:com.leo.dataStracture
 * File name:LoopExistCircle.java
 * Date:2018-01-18 11:33
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.dataStracture;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2018-01-18 11:33
 */
public class LoopExistCircle {

    public void circleExist(ListNode head) {
        ListNode fest = head;
        ListNode slow = head;
        int id = 1;
        while (fest != null && fest.getNext() != null) {
            fest = fest.getNext().getNext();
            slow = slow.getNext();
            if (fest == slow) {
                System.out.println("此链表存在环");
                int count = 0;
                while (true) {
                    fest = fest.getNext().getNext();
                    slow = slow.getNext();
                    count++;
                    if (fest == slow)
                        break;
                }
                System.out.println("此链表长度为:" + count);

                fest = head;
                while (fest != slow) {
                    fest = fest.getNext();
                    slow = slow.getNext();
                    id++;
                }
                System.out.println("此链表入环口为:" + id);
                return;
            }
        }
        System.out.println("此链表不存在环");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node3);

        LoopExistCircle loopExistCircle = new LoopExistCircle();
        loopExistCircle.circleExist(head);
    }
}