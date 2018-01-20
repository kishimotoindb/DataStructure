package com.example.chapter3.exercise;

import java.util.Stack;

/**
 * Created by BigFaceBear on 2018.01.18
 */

public class No25 {
    Stack<Integer> elements;
    Stack<Integer> mins;

    void push(Integer elem) {
        elements.push(elem);
        Integer min = mins.peek();
        if (elem <= min) {
            mins.push(elem);
        }
    }

    Integer pop() {
        Integer pop = elements.pop();
        Integer min = mins.peek();
        if (pop.equals(min)) {
            mins.pop();
        }
        return pop;
    }
}
