package com.example.chapter3.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by BigFaceBear on 2018.01.15
 * 注意，linkedlist是双链表，查找的时候是，离哪一端近，从哪一端开始搜索。所以计算时间复杂度时，不要
 * 忘记这一点。
 */

public class No1 {
    static List<Integer> arraylist = new ArrayList<>();
    static List<Integer> linklist = new LinkedList<>();
    static List<Integer> p = new ArrayList<>();

    static {
        for (int i = 0; i < 50; i++) {
            arraylist.add(i);
        }

        for (int i = 0; i < 50; i++) {
            linklist.add(i);
        }

        p.add(5);
        p.add(10);
        p.add(15);
        p.add(20);
        p.add(25);
        p.add(30);
        p.add(35);
        p.add(40);
        p.add(45);
    }

    public static void main(String[] args) {
        int recycle = 10000000;

        //No0
        long start0 = System.currentTimeMillis();
        for (int i = 0; i < recycle; i++) {
            sequencePrintArrayList();
        }
        long end0 = System.currentTimeMillis();
        long time0 = end0 - start0;

        //No1
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < recycle; i++) {
            sequencePrintLinkedList();
        }
        long end1 = System.currentTimeMillis();
        long time1 = end1 - start1;

        //No2
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < recycle; i++) {
            sequencePrintLinkedListForEach();
        }
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;

        System.out.println("time0 is O(3), and it is " + time0);
        System.out.println("time1 is O(30), and it is " + time1);
        System.out.println("time2 is O(50), and it is " + time2);

    }

    static void sequencePrintArrayList() {
        int lSize = arraylist.size();
        for (Integer end : p) {
            if (end < lSize) {
                //System.out.println(arraylist.get(end));
                arraylist.get(end);
            } else {
                break;
            }
        }
    }

    static void sequencePrintLinkedList() {
        int lSize = linklist.size();
        for (Integer end : p) {
            if (end < lSize) {
                //System.out.println(linklist.get(end));
                linklist.get(end);
            } else {
                break;
            }
        }
    }

    static void sequencePrintLinkedListForEach() {
        int indexOfTarget = 0;
        int target = p.get(indexOfTarget);
        int index = 0;
        for (Integer elem : linklist) {
            if (index++ == target) {
                //System.out.println(elem);

                indexOfTarget++;
                if (indexOfTarget < p.size()) {
                    target = p.get(indexOfTarget);
                } else {
                    break;
                }
            }
        }
    }
}
