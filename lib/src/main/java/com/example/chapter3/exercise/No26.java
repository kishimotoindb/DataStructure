package com.example.chapter3.exercise;

/**
 * Created by BigFaceBear on 2018.01.18
 */

public class No26 {
    int[] array = new int[20];

    int pointerA = -1;
    int pointerB = array.length;
    int bottomPointerOfC = -1;
    int pointerC = -1;

    void pushA(int elem) {
        pointerA++;
//        if (checkBoundary(0)) {
//            throw new IndexOutOfBoundsException();
//        }
        array[pointerA] = elem;
    }

    void pushB(int elem) {
        pointerB--;
//        if (checkBoundary(1)) {
//            throw new IndexOutOfBoundsException();
//        }
        array[pointerB] = elem;
    }

    void pushC(int elem) {
        if (bottomPointerOfC == -1) {
            if (pointerA == -1 && pointerB == array.length) {
                bottomPointerOfC = array.length / 3 * 2;
            } else if (pointerA == -1) {
                bottomPointerOfC = (pointerB - 1) / 3 * 2;
            } else if (pointerB == array.length) {
                bottomPointerOfC = (array.length - 1 - pointerA) / 3 * 2;
            }
        }
    }
}
