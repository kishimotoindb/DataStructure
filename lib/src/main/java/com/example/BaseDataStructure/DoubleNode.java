package com.example.BaseDataStructure;

/**
 * Created by BigFaceBear on 2018.01.16
 */

public class DoubleNode {
    public Integer item;
    public DoubleNode next;
    public DoubleNode prev;

    public DoubleNode() {
    }

    public DoubleNode(DoubleNode prev, Integer element, DoubleNode next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
