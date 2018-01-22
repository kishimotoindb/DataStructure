package com.example.chapter3.implementation.Queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by BigFaceBear on 2018.01.15
 */

public class MyQueueBySingleLinkNode implements Queue<Integer> {
    Node header;
    Node tail;
    int size;

    @Override
    public boolean add(Integer integer) {
        if (integer == null) return false;

        Node newGay = new Node();
        newGay.value = integer;

        if (tail == null) {
            header = tail = newGay;
        } else {
            tail.next = newGay;
        }

        size++;
        return true;
    }

    @Override
    public boolean offer(Integer integer) {
        return add(integer);
    }

    @Override
    public Integer remove() {
        if (isEmpty()) throw new NoSuchElementException();

        return poll();
    }

    @Override
    public Integer poll() {
        if (isEmpty()) return null;

        Integer result = header.value;
        if (header.next != null) {
            header = header.next;
        } else {
            header = tail = null;
        }

        size--;
        return result;
    }

    @Override
    public Integer element() {
        if (isEmpty()) throw new NoSuchElementException();

        return header.value;
    }

    @Override
    public Integer peek() {
        if (isEmpty()) return null;

        return header.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new NoSuchElementException();
    }

    @Override
    public Iterator<Integer> iterator() {
        throw new NullPointerException();
    }

    @Override
    public Object[] toArray() {
        throw new NullPointerException();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new NullPointerException();
    }

    @Override
    public boolean remove(Object o) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        throw new IllegalStateException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new NoSuchElementException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new IllegalStateException();
    }

    @Override
    public void clear() {
        header = tail = null;
        size = 0;
    }

    private static class Node {
        int value;
        Node next;
    }
}
