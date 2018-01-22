package com.example.chapter4.AVLTree;

/**
 * Created by haichen.cui on 2017.10.13
 */

public class AVLNode<T> {

    public T element;
    public AVLNode<T> left;
    public AVLNode<T> right;
    public int height;

    public AVLNode(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
