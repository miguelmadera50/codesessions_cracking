package com.company;

public class BinarySearchTreeNode {
    public int data;
    public BinarySearchTreeNode left_child = null;
    public BinarySearchTreeNode right_child = null;

    public BinarySearchTreeNode (int data) {
        this.data = data;
    }

    public void add(int data) {
        if (data < this.data) {
            if (left_child == null) left_child = new BinarySearchTreeNode(data);
            else left_child.add(data);
        } else {
            if (right_child == null) right_child = new BinarySearchTreeNode(data);
            else right_child.add(data);
        }
    }

    public static void print_subtree(BinarySearchTreeNode node) {
        if (node == null) return;
        System.out.println(node.data);
        print_subtree(node.left_child);
        print_subtree(node.right_child);
    }
}