package com.example.chapter3.exercise;

/**
 * Created by BigFaceBear on 2018.01.18
 */

public class No24 {
    int[] array = new int[5];
    int pointerA = -1;
    int pointerB = array.length;

    void pushA(int elem) {

        if (checkOverflow()) {
            throw new StackOverflowError();
        }

        array[++pointerA] = elem;
    }

    void pushB(int elem) {
        if (checkOverflow()) {
            throw new StackOverflowError();
        }

        array[--pointerB] = elem;
    }

    int popA() {
        if (pointerA < 0) {
            return -1;
        }

        return array[pointerA--];
    }

    int popB() {
        if (pointerB >= array.length) {
            return -1;
        }

        return array[pointerB++];
    }

    boolean checkOverflow() {
        return pointerB - pointerA == 1;
    }
}
