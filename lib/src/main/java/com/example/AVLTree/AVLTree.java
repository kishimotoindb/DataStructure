package com.example.AVLTree;

/**
 * Created by BigFaceBear on 2017.10.14
 */

public class AVLTree {
    AVLNode<Integer> root;

    /**
     * 插入节点
     *
     * @param x
     * @param node
     * @return
     */
    AVLNode<Integer> insert(Integer x, AVLNode<Integer> node) {
        return null;
    }

    int getHeight(AVLNode<Integer> node) {

        return 0;
    }

    /**
     * 通过单旋转或双旋转重新平衡AVL树
     *
     * @param k2 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    AVLNode<Integer> balance(AVLNode<Integer> k2) {
        return null;
    }

    /**
     * 对不平衡节点的左儿子的左子树进行单旋转
     *
     * @param k2 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    AVLNode<Integer> singleRotateWithLeftChild(AVLNode<Integer> k2) {
        return null;
    }

    /**
     * 对不平衡节点的右儿子的右子树进行单旋转
     *
     * @param k2 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    AVLNode<Integer> singleRotateWithRightChild(AVLNode<Integer> k2) {
        return null;
    }

    /**
     * 对不平衡节点的左儿子的右子树进行双旋转
     *
     * @param k2 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    AVLNode<Integer> doubleRotateWithLeftChild(AVLNode<Integer> k2) {
        return null;
    }

    /**
     * 对不平衡节点的右儿子的左子树进行双旋转
     *
     * @param k2 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    AVLNode<Integer> doubleRotateWithRightChild(AVLNode<Integer> k2) {
        return null;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /*
                                               100
                                               / \
                                            /       \
                                          /           \
                                        /               \
                                      /                   \
                                    /                       \
                                   /                          \
                                 /                             \
                                50                             150
                               /  \                            /  \
                              /    \                          /    \
                             /      \                        /      \
                            /        \                      /        \
                           /          \                    /          \
                          /            \                  /            \
                        25              75             125             175
                       /  \            /  \                            /  \
                      /    \          /    \                          /    \
                     /      \        /      \                        /      \
                    15      40      60      90                      160     190
                            /       /
                          30      55
         */

        //根
        tree.root = new IntNode(100);
        //1层节点
        tree.root.left = new IntNode(50);
        tree.root.right = new IntNode(150);
        //2层节点
        tree.root.left.left = new IntNode(25);
        tree.root.left.right = new IntNode(75);

        tree.root.right.left = new IntNode(125);
        tree.root.right.right = new IntNode(175);

        //3层节点
        tree.root.left.left.left = new IntNode(15);
        tree.root.left.left.right = new IntNode(40);

        tree.root.left.right.left = new IntNode(60);
        tree.root.left.right.right = new IntNode(90);

        tree.root.right.right.left = new IntNode(160);
        tree.root.right.right.right = new IntNode(190);

        //4层节点
        tree.root.left.left.right.left = new IntNode(30);

        tree.root.left.right.left.left = new IntNode(55);


    }
}
