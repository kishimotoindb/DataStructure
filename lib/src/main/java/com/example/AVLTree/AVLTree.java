package com.example.AVLTree;

/**
 * Created by BigFaceBear on 2017.10.14
 */

public class AVLTree {
    private static final int ALLOWED_IMBALANCE = 1;

    public AVLNode<Integer> root;

    public AVLNode<Integer> insert(Integer x) {
        root = insert(x, root);
        return root;
    }

    /**
     * 插入节点
     *
     * @param x    待插入元素
     * @param node 插入节点的父节点
     * @return
     */
    private AVLNode<Integer> insert(Integer x, AVLNode<Integer> node) {
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
                return doubleRotateWithRightChild(node);
            } else {
                return singleRotateWithRightChild(node);
            }
        } else {
            return node;
        }
    }

    /**
     * 对不平衡节点的左儿子的左子树进行单旋转
     *
     * @param node 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    private AVLNode<Integer> singleRotateWithLeftChild(AVLNode<Integer> node) {
        AVLNode<Integer> k1 = node.left;
        node.left = k1.right;
        k1.right = node;
        return k1;
    }

    /**
     * 对不平衡节点的右儿子的右子树进行单旋转
     *
     * @param node 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    private AVLNode<Integer> singleRotateWithRightChild(AVLNode<Integer> node) {
        AVLNode<Integer> k1 = node.right;
        node.right = k1.left;
        k1.left = node;
        return k1;
    }

    /**
     * 对不平衡节点的左儿子的右子树进行双旋转
     *
     * @param node 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    private AVLNode<Integer> doubleRotateWithLeftChild(AVLNode<Integer> node) {
        node.left = singleRotateWithRightChild(node.left);
        return singleRotateWithLeftChild(node);
    }

    /**
     * 对不平衡节点的右儿子的左子树进行双旋转
     *
     * @param node 插入新节点后，第一个不平衡的节点
     * @return 重新平衡后的子树的根节点
     */
    private AVLNode<Integer> doubleRotateWithRightChild(AVLNode<Integer> node) {
        node.right = singleRotateWithLeftChild(node.right);
        return singleRotateWithRightChild(node);
    }

    private static final int ELEMENT_SPAN = 3;  //最后一行每两个元素之间的间距
    private static final int ELEMENT_PLACE = 1; //每个元素所占的空间（6个空格的间距）


    public void printTree() {
        if (root == null) return;

        int treeHeight = getHeight(root);


        //生成存储树元素的打印信息的二维数组
        PrintNode[][] printNodes = new PrintNode[treeHeight + 1][];

        for (int i = 0; i < treeHeight + 1; i++) {
            printNodes[i] = new PrintNode[(int) Math.pow(2, i)];
        }

        for (int i = 0; i < printNodes.length; i++) {
            for (int j = 0; j < printNodes[i].length; j++) {
                printNodes[i][j] = new PrintNode();
            }
        }

        //将树中的元素放入二维数组中
        addNodeElementToArray(root, 0, 0, printNodes);

        //计算树中节点的打印位置
        addNodePositionToArray(printNodes);

        //打印树的结构
        for (int i = 0; i < printNodes.length; i++) {
            printElement(printNodes[i]);

            System.out.println();

            if (i < printNodes.length - 1) {
                printLine(printNodes[i], printNodes[i + 1]);
            }

            System.out.println();
        }
    }

    /*
     * row从0开始计数，column从0开始计数
     */
    private void addNodeElementToArray(AVLNode<Integer> node, int row, int column, PrintNode[][] printNodes) {
        if (node == null) return;

        printNodes[row][column].element = node.element;

        addNodeElementToArray(node.left, row + 1, 2 * column, printNodes);
        addNodeElementToArray(node.right, row + 1, 2 * column + 1, printNodes);
    }

    private void addNodePositionToArray(PrintNode[][] printNodes) {
        PrintNode printNode;

        //元素本身的宽度
        for (int i = 0; i < printNodes.length; i++) {
            for (int j = 0; j < printNodes[i].length; j++) {
                printNode = printNodes[i][j];
                if (printNode.element != null) {
                    printNode.elemWidth = printNode.element.toString().length();
                } else {
                    printNode.elemWidth = 0;
                }
            }
        }

        //计算数组最后一行的距离
        for (int j = 0; j < printNodes[printNodes.length - 1].length; j++) {
            printNode = printNodes[printNodes.length - 1][j];


            if (j > 0) {
                PrintNode leftNode = printNodes[printNodes.length - 1][j - 1];
                printNode.frontSpace = ELEMENT_SPAN;
                printNode.distanceToLeftBoundary =
                        leftNode.distanceToLeftBoundary
                                + leftNode.elemWidth
                                + printNode.frontSpace;
            } else {
                printNode.frontSpace = 0;
                printNode.distanceToLeftBoundary = 0;
            }

        }

        //计算数组其他行的距离
        PrintNode leftChild;
        PrintNode rightChild;
        PrintNode leftNode;
        for (int i = printNodes.length - 2; i >= 0; i--) {

            for (int j = 0; j < printNodes[i].length; j++) {

                leftChild = printNodes[i + 1][j * 2];
                rightChild = printNodes[i + 1][j * 2 + 1];
                printNode = printNodes[i][j];

                //计算节点与树左边界的距离
                printNode.distanceToLeftBoundary =
                        leftChild.distanceToLeftBoundary
                                + leftChild.elemWidth
                                + rightChild.frontSpace / 2
                                - printNode.elemWidth / 2;

                //计算节点前的空格数
                if (j == 0) {
                    printNode.frontSpace = printNode.distanceToLeftBoundary;
                } else {
                    leftNode = printNodes[i][j - 1];
                    printNode.frontSpace =
                            printNode.distanceToLeftBoundary
                                    - leftNode.distanceToLeftBoundary
                                    - leftNode.elemWidth;
                }
            }
        }
    }

    private long getTotalWidth(int treeHeight, int elementPlace, int elementSpan) {
        return (long) Math.pow(2, treeHeight) * (elementPlace + elementSpan);
    }

    private void printElement(PrintNode[] printNodes) {
        for (PrintNode printNode : printNodes) {
            for (int i = 0; i < printNode.frontSpace; i++) {
                System.out.print(" ");
            }

            System.out.print(printNode.element == null ? "" : printNode.element);
        }
    }

    private void printLine(PrintNode[] upLineNodes, PrintNode[] downLineNodes) {
        PrintNode leftNode;
        PrintNode rightNode;
        PrintNode midNode;

        for (int j = 0; j < downLineNodes.length; j += 2) {
            leftNode = downLineNodes[j];
            rightNode = downLineNodes[j + 1];
            midNode = upLineNodes[j / 2];

            for (int i = 0; i < leftNode.frontSpace + leftNode.elemWidth; i++) {
                System.out.print(" ");
            }


            if (leftNode.element == null) {

                for (int i = 0; i < midNode.distanceToLeftBoundary - leftNode.distanceToLeftBoundary - leftNode.elemWidth + midNode.elemWidth / 2; i++) {
                    System.out.print(" ");
                }

            } else {

                for (int i = 0; i < midNode.distanceToLeftBoundary - leftNode.distanceToLeftBoundary - leftNode.elemWidth + midNode.elemWidth / 2 - 1; i++) {
                    System.out.print("_");
                }

                System.out.print("/");

            }


            if (rightNode.element == null) {

                for (int i = 0; i < rightNode.distanceToLeftBoundary - midNode.distanceToLeftBoundary - midNode.elemWidth / 2 + rightNode.elemWidth; i++) {
                    System.out.print(" ");
                }

            } else {

                System.out.print("\\");

                for (int i = 0; i < rightNode.distanceToLeftBoundary - midNode.distanceToLeftBoundary - midNode.elemWidth / 2 - 1; i++) {
                    System.out.print("_");
                }

            }

            for (int i = 0; i < rightNode.elemWidth; i++) {
                System.out.print(" ");
            }

        }
    }


    /*
     * 打印树的时候，存储打印使用的节点
     */
    private class PrintNode {
        public Integer element;             //需要打印的数值
        public long distanceToLeftBoundary; //元素中心点到树左边界的距离
        public long elemWidth;          //元素本身所占宽度
        public long frontSpace;             //打印时，元素前面需要打印的空格数
    }

}
