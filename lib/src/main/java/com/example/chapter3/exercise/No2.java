package com.example.chapter3.exercise;

import com.example.BaseDataStructure.DoubleNode;
import com.example.BaseDataStructure.SingleNode;

/**
 * Created by BigFaceBear on 2018.01.16
 */

public class No2 {

    public static void main(String[] args) {
        SingleNode s1 = new SingleNode();
        SingleNode s2 = new SingleNode();
        SingleNode s3 = new SingleNode();
        SingleNode s4 = new SingleNode();
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;

        DoubleNode d1 = new DoubleNode();
        DoubleNode d2 = new DoubleNode();
        DoubleNode d3 = new DoubleNode();
        DoubleNode d4 = new DoubleNode();
        d1.next = d2;
        d2.prev = d1;
        d2.next = d3;
        d3.prev = d2;
        d3.next = d4;
        d4.prev = d3;

        //单链表的两个节点（s2和s3）交换位置



        //双向链表的两个节点(d2和d3)交换位置
    }
}
