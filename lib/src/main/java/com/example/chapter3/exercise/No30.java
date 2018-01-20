package com.example.chapter3.exercise;

import com.example.BaseDataStructure.SingleNode;

/**
 * Created by BigFaceBear on 2018.01.20
 * 单链表实现栈结构
 */

public class No30 {
    SingleNode top, next;

    void push(Integer elem) {
        if (top != null) {
            SingleNode newGay = new SingleNode(elem, top);
            next = top;
            top = newGay;
        } else {
            top = new SingleNode(elem, null);
        }
    }

    Integer pop() {
        if (top == null) return null;

        Integer pop = top.item;

        if (next != null) {
            top = next;
            next = next.next;
        } else {
            top = null;
        }
        return pop;
    }
}
