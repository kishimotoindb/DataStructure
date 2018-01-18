package com.example.chapter3.exercise;

import com.example.BaseDataStructure.DoubleNode;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by BigFaceBear on 2018.01.16
 * <p>
 * josephus问题
 */

public class No6 {
    DoubleNode header = new DoubleNode(null, 0, null);
    ArrayList<Integer> L;
    int M = 7;
    int playerNumber = 100;

    {
        DoubleNode cur = header;
        for (int i = 1; i < playerNumber; i++) {
            cur.next = new DoubleNode(null, i, null);
            cur.next.prev = cur;
            cur = cur.next;
        }
        cur.next = header;
        header.prev = cur;

        L = new ArrayList<Integer>();
        for (int i = 0; i < playerNumber; i++)
            L.add(i);
    }

    DoubleNode play(DoubleNode header) {
        DoubleNode winner = header;
        int time = 0;
        while (winner.next != winner) {
            winner = winner.next;
            time++;
            if (time == M) {
                time = 0;
                winner.prev.next = winner.next;
                winner.next.prev = winner.prev;
                winner = winner.next;
            }

        }
        return winner;
    }

    //没完全理解，待分析
    void playV2(int m, int n) {
        int i, j, mPrime, numLeft;
        ListIterator<Integer> iter = L.listIterator();
        Integer item = 0;
        numLeft = n;
        for (i = 0; i < n; i++) {
            mPrime = m % numLeft;
            if (mPrime <= numLeft / 2) {
                if (iter.hasNext())
                    item = iter.next();

                for (j = 0; j < mPrime; j++) {
                    if (!iter.hasNext())
                        iter = L.listIterator();
                    item = iter.next();
                }
            } else {
                for (j = 0; j < numLeft - mPrime; j++) {
                    if (!iter.hasPrevious())
                        iter = L.listIterator(L.size());
                    item = iter.previous();
                }
            }

            System.out.print("Removed " + item + " ");
            iter.remove();
            if (!iter.hasNext())
                iter = L.listIterator();
            System.out.println();
            for (Integer x : L)
                System.out.print(x + " ");
            System.out.println();
            numLeft--;
        }

        System.out.println();
    }

    public void playV2Copy(int m, int n) {
        ListIterator<Integer> iter = L.listIterator();
//        if (!iter.hasNext()) return;
//
//        int numLeft = n;
//        int prime = m;
//        int i, j;
//
//        for (i = 0; i < n; i++) {
//            if (iter.hasNext())
//                iter.next();
//            else {
//                iter = L.listIterator();
//                iter.next();
//            }
//
//            int mPrime = m % numLeft;
//            if (mPrime <= numLeft / 2) {
//                for (j = 0; j < mPrime; j++) {
//
//                }
//            } else {
//
//            }
//
//            numLeft--;
//        }

        while (L.size() > 1) {
            iter.next();

            for (int i = 0; i < m; i++) {
                if (iter.hasNext())
                    iter.next();
                else
                    iter = L.listIterator();
            }

            iter.remove();
        }

        System.out.println(L.get(0));
    }


    public static void main(String[] args) {
        No6 no6 = new No6();

//        long startV1 = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
        Integer item = no6.play(no6.header).item;
        System.out.println("v1 is " + item);
//        }
//        long endV1 = System.currentTimeMillis();
//        System.out.println("v1 is " + (endV1 - startV1) + " ms");

//        long startV2 = System.currentTimeMillis();
        no6.playV2(no6.M, no6.playerNumber);
        System.out.println("v2 is " + item);
//        long endV2 = System.currentTimeMillis();
//        System.out.println("v2 is " + (endV2 - startV2) + " ms");

        no6.playV2Copy(no6.M, no6.playerNumber);
        System.out.println("v2copy is " + item);
    }


}
