package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Chapter4 {
    Chapter4() {
        // Route Between Nodes: Given a directed graph, design an algorithm to find out whether these is a route between
        // two nodes.
        // TODO implement directed graph DS and then do bi-directional search (BFS) from both sides

        // Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm to
        // create a binary search tree with minimal height.
        BinarySearchTreeNode root_p2 = problem_2(new int[] {1,2,3,4,5,6,7,8,9});
        assert _validate_binary_search_tree(root_p2);

        // List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each
        // depth. e.g., if you have a tree with depth D, you have D linked lists.
        // Generated sample tree:
        //                      1
        //                 2          3
        //           4              5      6
        //         7   8          9          0
        BinaryTreeNode root = _create_problem_3_sample_tree();
        LinkedList<LinkedList> linked_list = problem_3(root);
        assert _compare_array_to_linked_list(linked_list.get(0), new int[] {1});
        assert _compare_array_to_linked_list(linked_list.get(1), new int[] {2, 3});
        assert _compare_array_to_linked_list(linked_list.get(2), new int[] {4, 5, 6});
        assert _compare_array_to_linked_list(linked_list.get(3), new int[] {7, 8, 9, 0});

        // Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of this
        // question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never
        // differ by more than one.
        // DONE
        BinaryTreeNode simple_tree = _create_problem_4_simple_tree();
        BinaryTreeNode balanced_tree = _create_problem_4_balanced_tree();
        BinaryTreeNode unbalanced_tree = _create_problem_4_unbalanced_tree();
        assert problem_4(simple_tree);
        assert problem_4(balanced_tree);
        assert !problem_4(unbalanced_tree);

        // Validate BST: Implement a function to check if a binary tree is a binary search tree.
        BinaryTreeNode root_a = _create_problem_5_example_a();
        BinaryTreeNode root_b = _create_problem_5_example_b();
        BinaryTreeNode root_c = _create_problem_5_example_c();
        assert !problem_5(root_a);
        assert !problem_5(root_b);
        assert problem_5(root_c);

        // Successor: Write an algorithm to find the 'next' node of a given node in a binary search tree. You may
        // assume that each node has a link to its parent
        ParentBinarySearchTreeNode problem_6_tree_a = _create_problem_6_tree_a();
        ParentBinarySearchTreeNode problem_6_tree_b = _create_problem_6_tree_b();
        // TODO problem 6 is WIP

        // Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
        // projects, where the first project is dependant on the second project). All of a project's dependencies must
        // be built before the project is. Find a build order that will allow the projects to be built. If there is no
        // valid build order, return an error.

        // First Common Ancestor: Design an algorithm and write code to find the first common ancestor of two nodes in a
        // binary tree. Avoid  storing additional nodes in a data structure. Note: This is not necessarily a binary
        // search tree.

        // BST Sequences: A binary search tree was created by traversing through an array from left to right and
        // inserting each element. Given a binary search tree with distinct elements, print all possible arrays that
        // could have led to this tree.

        // Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm to
        // determine if T2 is a subtree of T1.

        // Random Node: You are implementing a binary tree class from scratch with in addition to insert, find, delete,
        // has a method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to
        // be chosen. Design and implement and algorithm for getRandomNode(), and explain how you would implement the
        // rest of the methods.

        // Paths with Sum: You are given a binary search tree in which each node contains an integer value (which may be
        // positive or negative). Design and algorithm to count the number of paths that sum to a given value. The path
        // does not need to start or end at the root or a leaf, but it must go downwards (traveling from parent to
        // children nodes).
    }

    private boolean _compare_array_to_linked_list(LinkedList<Integer> list, int[] arr) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != arr[i]) return false;
        }
        return true;
    }

    private boolean _validate_binary_search_tree(BinarySearchTreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        _validate_binary_search_tree_iter(root, arr);

//        System.out.println(arr.size());

        for (int i = 0; i < arr.size() - 1; i++) {
//            System.out.println("i " + arr.get(i) + " j " + arr.get(i + 1));
            if (arr.get(i) > arr.get(i + 1)) return false;
        }
        return true;
    }

    private void _validate_binary_search_tree_iter(BinarySearchTreeNode node, ArrayList<Integer> arr) {
        if (node == null) return;

        _validate_binary_search_tree_iter(node.left_child, arr);
        arr.add(node.data);
        _validate_binary_search_tree_iter(node.right_child, arr);
    }

    private BinaryTreeNode _create_problem_3_sample_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);

        // Depth 1
        root.left_child = new BinaryTreeNode(2);
        root.right_child = new BinaryTreeNode(3);

        // Depth 2
        root.left_child.left_child = new BinaryTreeNode(4);
        root.right_child.left_child = new BinaryTreeNode(5);
        root.right_child.right_child = new BinaryTreeNode(6);

        // Depth 3
        root.left_child.left_child.left_child = new BinaryTreeNode(7);
        root.left_child.left_child.right_child = new BinaryTreeNode(8);
        root.right_child.left_child.left_child = new BinaryTreeNode(9);
        root.right_child.right_child.right_child = new BinaryTreeNode(0);

        return root;
    }

    private BinaryTreeNode _create_problem_4_simple_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);

        // 1
        // 2 3

        root.left_child = new BinaryTreeNode(2);
        root.right_child = new BinaryTreeNode(3);
        return root;
    }

    private BinaryTreeNode _create_problem_4_balanced_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);

        // 1
        // 2    3
        // 4 5  6 7
        // 8    9

        root.left_child = new BinaryTreeNode(2);
        root.right_child = new BinaryTreeNode(3);

        root.left_child.left_child = new BinaryTreeNode(4);
        root.left_child.right_child = new BinaryTreeNode(5);

        root.right_child.left_child = new BinaryTreeNode(6);
        root.right_child.right_child = new BinaryTreeNode(7);

        root.left_child.left_child.left_child = new BinaryTreeNode(8);
        root.right_child.left_child.right_child = new BinaryTreeNode(9);
        return root;
    }

    private BinaryTreeNode _create_problem_4_unbalanced_tree() {
        BinaryTreeNode root = new BinaryTreeNode(1);

        // 1
        // 2    3
        // 4    6 7
        // 8    9

        root.left_child = new BinaryTreeNode(2);
        root.right_child = new BinaryTreeNode(3);

        root.left_child.left_child = new BinaryTreeNode(4);

        root.right_child.left_child = new BinaryTreeNode(6);
        root.right_child.right_child = new BinaryTreeNode(7);

        root.left_child.left_child.left_child = new BinaryTreeNode(8);
        root.right_child.left_child.right_child = new BinaryTreeNode(9);
        return root;
    }

    // Not BST
    private BinaryTreeNode _create_problem_5_example_a() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left_child = new BinaryTreeNode(2);
        root.right_child = new BinaryTreeNode(3);
        root.left_child.left_child = new BinaryTreeNode(4);
        root.left_child.right_child = new BinaryTreeNode(5);
        root.right_child.left_child = new BinaryTreeNode(6);
        root.right_child.right_child = new BinaryTreeNode(7);
        return root;
    }

    // Also not BST
    private BinaryTreeNode _create_problem_5_example_b() {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left_child = new BinaryTreeNode(2);
        root.right_child = new BinaryTreeNode(6);
        root.left_child.left_child = new BinaryTreeNode(1);
        root.left_child.right_child = new BinaryTreeNode(4);
        root.right_child.left_child = new BinaryTreeNode(5);
        root.right_child.right_child = new BinaryTreeNode(7);
        root.right_child.right_child.right_child = new BinaryTreeNode(8);
        return root;
    }

    // BST
    private BinaryTreeNode _create_problem_5_example_c() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left_child = new BinaryTreeNode(3);
        root.right_child = new BinaryTreeNode(7);
        root.left_child.left_child = new BinaryTreeNode(2);
        root.left_child.right_child = new BinaryTreeNode(4);
        root.right_child.left_child = new BinaryTreeNode(6);
        root.right_child.right_child = new BinaryTreeNode(9);
        return root;
    }

    private ParentBinarySearchTreeNode _create_problem_6_tree_a() {
        ParentBinarySearchTreeNode root = new ParentBinarySearchTreeNode(8, null);
        root.add(3);
        root.add(10);
        root.add(1);
        root.add(6);
        root.add(4);
        root.add(7);
        root.add(14);
        root.add(13);
        return root;
    }

    private ParentBinarySearchTreeNode _create_problem_6_tree_b() {
        ParentBinarySearchTreeNode root = new ParentBinarySearchTreeNode(20, null);
        root.add(10);
        root.add(30);
        root.add(5);
        root.add(15);
        root.add(2);
        root.add(8);
        root.add(13);
        root.add(25);
        root.add(23);
        root.add(27);
        root.add(40);
        root.add(45);
        return root;
    }

    // Divide and conquer strategy, copies half of the array to each branch recursively
    // Results in a balanced binary tree of minimum size
    // Has 1 call for each of the nodes of the tress, so O(n log(n))
    private BinarySearchTreeNode problem_2(int[] arr) {
        int arr_len = arr.length;
        int pivot = (int) Math.ceil(arr_len / 2);
        int[] before = Arrays.copyOfRange(arr, 0, pivot);
        int[] after = Arrays.copyOfRange(arr, pivot + 1, arr_len);

        BinarySearchTreeNode head = new BinarySearchTreeNode(arr[pivot]);
        problem_2_iter(before, head);
        problem_2_iter(after, head);

        return head;
    }

    private void problem_2_iter(int[] arr, BinarySearchTreeNode head) {
        // Base Cases
        int arr_len = arr.length;
        if (arr_len == 1) {
            head.add(arr[0]);
//            System.out.println(" base " + arr[0]);
            return;
        } else if (arr_len == 0) {
            return;
        }

        int pivot = (int) Math.ceil(arr_len / 2);
        int[] before = Arrays.copyOfRange(arr, 0, pivot);
        int[] after = Arrays.copyOfRange(arr, pivot + 1, arr_len);

        // Only other place bst.add is called (for pivots), Pre order traversal
        head.add(arr[pivot]);
        problem_2_iter(before, head);
        problem_2_iter(after, head);
    }

    // Basically a pre-order traversal, keeping the level as an argument to the recursive functions
    // if list.add is O(1) then this strategy is O(n) where n is the number of nodes in the binary tree
    private LinkedList<LinkedList> problem_3(BinaryTreeNode root) {
        int level = 0;
        LinkedList<LinkedList> array = new LinkedList<>();
        problem_3_iter(array, root, level);
        return array;
    }

    private void problem_3_iter(LinkedList<LinkedList> array, BinaryTreeNode node, int level){
        if (node != null) {
            try {
                array.get(level).add(node.data);
            } catch (IndexOutOfBoundsException e) {
                LinkedList<Integer> arr = new LinkedList<>();
                arr.add(node.data);
                array.add(arr);
            }
            problem_3_iter(array, node.left_child, level + 1);
            problem_3_iter(array, node.right_child , level + 1);
        }
    }

    // Check each node (recursively) if its subtrees are off (in depth) by one
    // O(2n) because of the arraylist append.
    private boolean problem_4(BinaryTreeNode node) {
        ArrayList<Boolean> depth_array = new ArrayList<>();
        problem_4_iter(node, depth_array, 0);

        for (boolean a: depth_array) if (!a) return false;
        return true;
    }

    // Recursive function, returns subtree depth difference
    private int problem_4_iter(BinaryTreeNode node, ArrayList<Boolean> arr, int depth) {
        if (node == null) return depth;  // Base Case

        int left_depth = problem_4_iter(node.left_child, arr, depth + 1);
        int right_depth = problem_4_iter(node.right_child, arr, depth + 1);

        arr.add(Math.max(left_depth, right_depth) - Math.min(left_depth, right_depth) < 2);
        return Math.max(left_depth, right_depth);

        // In-order traversal of the tree, add everything to an ArrayList, then check if the arraylist is sorted
    // Traversal and append are O(n) then last check is also O(n) -> O(2n)
    private boolean problem_5(BinaryTreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        problem_5_iter(arr, root);

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) return false;
        }
        return true;
    }

    // In order traversal
    private void problem_5_iter(ArrayList<Integer> arr, BinaryTreeNode node) {
        if (node == null) return;
        problem_5_iter(arr, node.left_child);
        arr.add(node.data);
        problem_5_iter(arr, node.right_child);
    }

    private ParentBinarySearchTreeNode problem_6(ParentBinarySearchTreeNode node) {
        boolean has_left = node.left_child != null;
        boolean has_right = node.right_child != null;

        boolean parent_is_left = false;  // Should not be used without first checking has_parent
        boolean has_parent = node.parent != null;
        if (has_parent) parent_is_left = node.parent.left_child == node;

        // Leaf nodes
        if (!has_left && !has_right) {
            if (!has_parent) return null;  // Only node in the tree
            if (parent_is_left) return node.parent; // Left leaf node
        }

        // Non-leaves
        if (has_right) return _problem_6_get_leftmost_of_right_child();
        return _problem_6_get_next_right_parent(node);  // Any node that does not have right child (including leaf node)
    }

    private ParentBinarySearchTreeNode _problem_6_get_leftmost_of_right_child() {
        return node;
    }

    private ParentBinarySearchTreeNode _problem_6_get_next_right_parent(ParentBinarySearchTreeNode node) {
        return node;
    }

}
