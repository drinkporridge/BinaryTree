package com.dick.node;


import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    /**
     *@Author: Cheng Leiyu
     *@Description: 二叉树的结点应为逆序建立，按照java的初始化机制，会先加载上面的结点，编译器会报错
     *@Date:2018-11-5_21:01
     *@Modify By
     */
    public static Node init() {
        Node J = new Node(9, null, null);
        Node H = new Node(8, null, null);
        Node G = new Node(7, null, null);
        Node F = new Node(6, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(4, null, G);
        Node C = new Node(3, F, null);
        Node B = new Node(2, D, E);
        Node A = new Node(1, B, C);
        return A;
    }

    public void printNode(Node node){
        System.out.println(node.getData());
    }

    /**
     *@Author: Cheng Leiyu
     *@Description: 二叉树先序遍历
     *@Date:2018-11-5_21:19
     *@Modify By
     */
    public void theFirstTraversal(Node node) {
        printNode(node);
        if (node.getLeftNode() != null) {
            theFirstTraversal(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            theFirstTraversal(node.getRightNode());
        }
    }

    /**
     *@Author: Cheng Leiyu
     *@Description: 二叉树中序遍历
     *@Date:2018-11-5_21:22
     *@Modify By
     */
    public void theInOrderTraversal(Node node) {
        if (node.getLeftNode() != null) {
            theInOrderTraversal(node.getLeftNode());
        }
        printNode(node);
        if (node.getRightNode() != null) {
            theInOrderTraversal(node.getRightNode());
        }
    }

    /**
     *@Author: Cheng Leiyu
     *@Description: 二叉树后续遍历
     *@Date:2018-11-6_21:13
     *@Modify By
     */
    public void thePostTraversal(Node node) {
        if (node.getLeftNode() != null) {
            thePostTraversal(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            thePostTraversal(node.getRightNode());
        }
        printNode(node);
    }

    /**
     *@Author: Cheng Leiyu
     *@Description: 二叉树深度优先遍历
     *@Date:2018-11-6_21:13
     *@Modify By
     */
    public void depthOrderTraversal(Node node) {
        if(node == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        stack.push(node);
        while(!stack.isEmpty()) {
            Node stackNode = stack.pop();
            System.out.println(stackNode.getData());
            if(stackNode.getRightNode() != null) {
                stack.push(stackNode.getRightNode());
            }
            if(stackNode.getLeftNode() != null) {
                stack.push(stackNode.getLeftNode());
            }
        }
    }

    public void LevelOrderTraversal(Node node){
        if (node == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
           Node queueNode = queue.poll();
           System.out.println(queueNode.getData());
           if (queueNode.getLeftNode() != null) {
               queue.add(queueNode.getLeftNode());
           }
           if (queueNode.getRightNode() != null) {
               queue.add(queueNode.getRightNode());
           }
        }
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //binaryTree.init();
        //binaryTree.theFirstTraversal(BinaryTree.init());
        //binaryTree.theInOrderTraversal(BinaryTree.init());

        //binaryTree.thePostTraversal(BinaryTree.init());

        //binaryTree.depthOrderTraversal(BinaryTree.init());
        binaryTree.LevelOrderTraversal(BinaryTree.init());
    }
}
