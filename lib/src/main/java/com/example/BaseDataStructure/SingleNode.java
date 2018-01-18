package com.example.BaseDataStructure;

/**
 * Created by BigFaceBear on 2018.01.16
 */

public class SingleNode {
    public Integer item;
    public SingleNode next;

    public SingleNode() {
    }

    public SingleNode(Integer element, SingleNode next) {
        this.item = element;
        this.next = next;
    }
}
