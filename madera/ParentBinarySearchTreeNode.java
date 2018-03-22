package com.company;

public class ParentBinarySearchTreeNode {
    int data;
    ParentBinarySearchTreeNode parent;
    ParentBinarySearchTreeNode left_child = null;
    ParentBinarySearchTreeNode right_child = null;

    ParentBinarySearchTreeNode(int data, ParentBinarySearchTreeNode parent) {
        this.parent = parent;
        this.data = data;
    }

    public void add(int data) {
        if (data < this.data) {
            if (left_child == null) left_child = new ParentBinarySearchTreeNode(data, this);
            else left_child.add(data);
        } else {
            if (right_child == null) right_child = new ParentBinarySearchTreeNode(data, this);
            else right_child.add(data);
        }
    }

    public static void print_subtree(ParentBinarySearchTreeNode node) {
        if (node == null) return;
        print_subtree(node.left_child);
        if (node.parent == null) System.out.println("Data: " + node.data + " Parent: null");
        else System.out.println("Data: " + node.data + " Parent: " + node.parent.data);
        print_subtree(node.right_child);
    }
}