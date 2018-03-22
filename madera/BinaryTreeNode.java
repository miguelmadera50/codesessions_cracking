package com.company;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left_child;
    public BinaryTreeNode right_child;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left_child = null;
        this.right_child = null;
    }

    public static void print_subtree(BinaryTreeNode node) {
        if (node == null) return;
        System.out.println(node.data);
        print_subtree(node.left_child);
        print_subtree(node.right_child);
    }
}
