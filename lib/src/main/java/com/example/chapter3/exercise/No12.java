package com.example.chapter3.exercise;

import java.util.ListIterator;

/**
 * Created by BigFaceBear on 2018.01.18
 */

public class No12 implements ListIterator<Integer> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Integer previous() {
        return null;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(Integer integer) {

    }

    @Override
    public void add(Integer integer) {

    }
}
