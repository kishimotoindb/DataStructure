package com.example.chapter3.exercise;

import com.example.BaseDataStructure.SingleNode;

/**
 * Created by BigFaceBear on 2018.01.20
 */

public class No29 {
    SingleNode head = new SingleNode(0, null);

    {
        SingleNode n1 = new SingleNode(1, null);
        SingleNode n2 = new SingleNode(1, null);
        SingleNode n3 = new SingleNode(1, null);
        SingleNode n4 = new SingleNode(1, null);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
    }

    SingleNode reversalPrint(SingleNode head) {
        if (head == null) return null;

        SingleNode prev = null;
        SingleNode cur = head;
        SingleNode next = head.next;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }

        cur.next = prev;

        return cur;
    }

}
