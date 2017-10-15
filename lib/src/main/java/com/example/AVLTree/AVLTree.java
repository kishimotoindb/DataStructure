package com.example.AVLTree;

/**
 * Created by BigFaceBear on 2017.10.14
 */

public class AVLTree {
    private static final int ALLOWED_IMBALANCE = 1;

    public AVLNode<Integer> root;

    /**
     * 插入节点
     *
     * @param x    待插入元素
     * @param node 插入节点的父节点
     * @return
     */
    public AVLNode<Integer> insert(Integer x, AVLNode<Integer> node) {
        if (node == null) {
            return new AVLNode<>(x);
        }

        if (x < node.element) {
            node.left = insert(x, node.left);
        } else if (x > node.element) {
            node.right = insert(x, node.right);
        }

        return balance(node);
    }

    public int getHeight(AVLNode<Integer> node) {
        if (node == null) return -1;

        int heightOfLeftChildTree = getHeight(node.left);
        int heightOfRightChildTree = getHeight(node.right);
        return Math.max(heightOfLeftChildTree, heightOfRightChildTree) + 1;
    }

    /**
     * 通过单旋转或双旋转重新平衡AVL树
     *
     * @param node 树或子树的根节点
     * @return 重新平衡后的树或子树的根节点
     */
    private AVLNode<Integer> balance(AVLNode<Integer> node) {
        if (node == null) return null;

        if (getHeight(node.left) - getHeight(node.right) > ALLOWED_IMBALANCE) {
            if (getHeight(node.left.left) > getHeight(node.left.right)) {
                return singleRotateWithLeftChild(node);
            } else {
                return doubleRotateWithLeftChild(node);
            }
        } else if (getHeight(node.right) - getHeight(node.left) > ALLOWED_IMBALANCE) {
            if (getHeight(node.right.left) > getHeight(node.right.right)) {
                return singleRotateWithRightChild(node);
            } else {
                return doubleRotateWithRightChild(node);
            }
        } else {
            return node;
        }
    }

    /**
     * 对不平衡节点的左儿子的左子树进行单旋转
     *
     * @param k2 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    private AVLNode<Integer> singleRotateWithLeftChild(AVLNode<Integer> k2) {
        AVLNode<Integer> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /**
     * 对不平衡节点的右儿子的右子树进行单旋转
     *
     * @param k2 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    private AVLNode<Integer> singleRotateWithRightChild(AVLNode<Integer> k2) {
        AVLNode<Integer> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        return k1;
    }

    /**
     * 对不平衡节点的左儿子的右子树进行双旋转
     *
     * @param k2 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    private AVLNode<Integer> doubleRotateWithLeftChild(AVLNode<Integer> k2) {
        k2.left = singleRotateWithRightChild(k2.left);
        return singleRotateWithLeftChild(k2);
    }

    /**
     * 对不平衡节点的右儿子的左子树进行双旋转
     *
     * @param k2 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    private AVLNode<Integer> doubleRotateWithRightChild(AVLNode<Integer> k2) {
        k2.right = singleRotateWithLeftChild(k2.left);
        return singleRotateWithRightChild(k2);
    }

    private static final int ELEMENT_SPAN = 2;  //最后一行每两个元素之间的间距
    private static final int ELEMENT_PLACE = 6; //每个元素所占的空间（6个空格的间距）


    public void PrintTree() {
        if (root == null) return;

        int treeHeight = getHeight(root);


        //将树中的元素放入二维数组中
        PrintNode[][] printNodes = new PrintNode[treeHeight + 1][];

        for (int i = 0; i < treeHeight + 1; i++) {
            printNodes[i] = new PrintNode[(int) Math.pow(2, i)];
        }

        addNodeToArray(root, 0, 0, printNodes);

        //计算树中节点的打印位置
        addNodePositionToArray(printNodes);

        //打印树的结构
        for (int i = 0; i < printNodes.length; i++) {
            for (int j = 0; j < printNodes[i].length; j++) {
                printElement(printNodes[i]);
            }

            System.out.println();

            if (i < printNodes.length - 1) {
                printLine(printNodes[i + 1]);
            }

            System.out.println();
        }
    }

    private void addNodeToArray(AVLNode<Integer> node, int row, int column, PrintNode[][] elementArray) {
        if (node == null) return;

        elementArray[row][column].element = node.element;

        addNodeToArray(node.left, row + 1, 2 * column, elementArray);
        addNodeToArray(node.right, row + 1, 2 * column + 1, elementArray);
    }

    private void addNodePositionToArray(PrintNode[][] printNodes) {
        PrintNode printNode;

        //计算数组最后一行的距离
        for (int j = 0; j < printNodes[printNodes.length - 1].length; j++) {
            printNode = printNodes[printNodes.length - 1][j];

            printNode.frontEmpty = j * (ELEMENT_PLACE + ELEMENT_SPAN);
        }

        //计算数组其他行的距离
        //左右节点可能没有数据，但是间距是有的
        PrintNode leftNode;
        PrintNode rightNode;
        for (int i = printNodes.length - 2; i >= 0; i--) {

            for (int j = 0; j < printNodes[i].length; j++) {
                leftNode = printNodes[i + 1][j * 2];
                rightNode = printNodes[i + 1][j * 2 + 1];
                printNode = printNodes[i][j];

                printNode.frontEmpty = leftNode.frontEmpty + rightNode.frontEmpty / 2;
            }
        }
    }

    private long getTotalWidth(int treeHeight, int elementPlace, int elementSpan) {
        return (long) Math.pow(2, treeHeight) * (elementPlace + elementSpan);
    }

    private void printElement(PrintNode[] printNodes) {
        for (PrintNode printNode : printNodes) {
            for (int i = 0; i < printNode.frontEmpty; i++) {
                System.out.print(" ");
            }

            System.out.print(printNode.element);
        }
    }

    private void printLine(PrintNode[] printNodes) {
        PrintNode leftNode;
        PrintNode rightNode;

        for (int j = 0; j < printNodes.length; j += 2) {
            leftNode = printNodes[j];
            rightNode = printNodes[j + 1];


            for (int i = 0; i < leftNode.frontEmpty; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < rightNode.frontEmpty / 2 - 1; i++) {
                System.out.print("_");
            }

            System.out.print("/");
            System.out.print("\\");

            for (int i = 0; i < rightNode.frontEmpty / 2 - 1; i++) {
                System.out.print("_");
            }
        }
    }


    /*
     * 打印树的时候，存储打印使用的节点
     */
    private class PrintNode {
        public Integer element; //需要打印的数值
        public long frontEmpty; //数值前的空格数
    }

}
