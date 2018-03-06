package com.company;

import java.util.ArrayList;

class Chapter2 {
    Chapter2() {
        // Remove Dupes: Write code to remove duplicates from an unsorted linked list. FOLLOW UP: How would you solve
        // this problem if a temporary buffer is not allowed?
        LinkedListNode problem_1_a = problem1(_createLinkedList(new int[] {1, 1}));
        LinkedListNode problem_1_b = problem1(_createLinkedList(new int[] {1, 2, 1}));
        LinkedListNode problem_1_c = problem1(_createLinkedList(new int[] {4, 3, 3, 4, 4}));
        LinkedListNode problem_1_d = problem1(_createLinkedList(new int[] {1, 4, 5, 5, 8, 2, 4, 1, 7, 1}));
        assert _verifyLinkedList(problem_1_a, new int[] {1});
        assert _verifyLinkedList(problem_1_b, new int[] {2, 1});
        assert _verifyLinkedList(problem_1_c, new int[] {3, 4});
        assert _verifyLinkedList(problem_1_d, new int[] {5, 8, 2, 4, 7, 1});

        // Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list
        LinkedListNode problem_2_a = _createLinkedList(new int[] {5, 4, 3, 2, 1, 0});
        for (int i = 0; i < 6; i++) assert problem2(problem_2_a, i) == i;

        // Delete Middle Node: Implement an algorithm to delete a node in the model (i.e., any node but the first and
        // last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
        LinkedListNode problem_3_a = _createLinkedList(new int[] {1, 2, 3, 4});
        LinkedListNode problem_3_b = _createLinkedList(new int[] {1, 2, 3, 4});
        LinkedListNode problem_3_c = _createLinkedList(new int[] {1, 2, 3, 4, 5});
        problem3(problem_3_a.next);
        problem3(problem_3_b.next.next);
        problem3(problem_3_c.next.next);
        assert _verifyLinkedList(problem_3_a, new int[] {1, 3, 4});
        assert _verifyLinkedList(problem_3_b, new int[] {1, 2, 4});
        assert _verifyLinkedList(problem_3_c, new int[] {1, 2, 4, 5});

        // Partition: Write code to partition a linked list around a value x, such that all nodes less than x com before
        // all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be
        // after the elements less than x. The partition element x can appear anywhere in the "right partition"; it does
        // not need to appear between the lest and right partitions.
        LinkedListNode problem_4_a = _createLinkedList(new int[] {3, 5, 8, 5, 10, 2, 1});
        LinkedListNode problem_4_b = _createLinkedList(new int[] {3, 5, 8, 5, 10, 2, 1});
        LinkedListNode problem_4_c = _createLinkedList(new int[] {3, 5, 8, 5, 10, 2, 1});
        assert _verifyLinkedList(problem4(problem_4_a, 5), new int[] {3, 2, 1, 5, 8, 5, 10});
        assert _verifyLinkedList(problem4(problem_4_b, 3), new int[] {2, 1, 3, 5, 8, 5, 10});
        assert _verifyLinkedList(problem4(problem_4_c, 8), new int[] {3, 5, 5, 2, 1, 8, 10});

        // Sum Lists: You have two numbers represented in a linked list, where each node contains a single digit. The
        // digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that
        // adds the two numbers and returns the sum as a linked list. FOLLOW UP: Suppose the digits are stored in
        // forward order, repeat the above problem.
        LinkedListNode problem_5a_1 = problem5a(_createLinkedList(new int[] {7, 1, 6}), _createLinkedList(new int[] {5, 9, 2}));
        LinkedListNode problem_5a_2 = problem5a(_createLinkedList(new int[] {1, 7, 4}), _createLinkedList(new int[] {2, 5, 4, 1}));
        LinkedListNode problem_5a_3 = problem5a(_createLinkedList(new int[] {7, 1}), _createLinkedList(new int[] {5, 3, 1}));
        LinkedListNode problem_5b_1 = problem5b(_createLinkedList(new int[] {7, 1, 6}), _createLinkedList(new int[] {5, 9, 2}));
        LinkedListNode problem_5b_2 = problem5b(_createLinkedList(new int[] {1, 7, 4}), _createLinkedList(new int[] {2, 5, 4, 1}));
        LinkedListNode problem_5b_3 = problem5b(_createLinkedList(new int[] {7, 1}), _createLinkedList(new int[] {5, 3, 1}));
        assert _verifyLinkedList(problem_5a_1, new int[] {2, 1, 9});
        assert _verifyLinkedList(problem_5a_2, new int[] {3, 2, 9, 1});
        assert _verifyLinkedList(problem_5a_3, new int[] {2, 5, 1});
        assert _verifyLinkedList(problem_5b_1, new int[] {9, 1, 2});
        assert _verifyLinkedList(problem_5b_2, new int[] {1, 9, 2, 3});
        assert _verifyLinkedList(problem_5b_3, new int[] {1, 5, 2});

        // Palindrome: Implement a function to check if a linked list is a palindrome.
        // Positive
        assert problem6(_createLinkedList(new int[] {1}));
        assert problem6(_createLinkedList(new int[] {1, 1}));
        assert problem6(_createLinkedList(new int[] {1, 1, 1}));
        assert problem6(_createLinkedList(new int[] {1, 3, 1}));
        assert problem6(_createLinkedList(new int[] {1, 2, 2, 1}));
        assert problem6(_createLinkedList(new int[] {1, 2, 3, 2, 1}));

        // Negative
        assert !problem6(_createLinkedList(new int[] {1, 2}));
        assert !problem6(_createLinkedList(new int[] {1, 1, 3}));
        assert !problem6(_createLinkedList(new int[] {1, 3, 2, 1}));
        assert !problem6(_createLinkedList(new int[] {2, 2, 1, 2}));
        assert !problem6(_createLinkedList(new int[] {1, 2, 3, 2, 1, 1}));

        // Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
        // node. Note that the intersection is defined based on reference, not value. That is, if the kth node of the
        // first linked list is the exact same node (by reference) as the jth node of the second linked list, then they
        // are intersecting.
        LinkedListNode problem_7a_1 = _createLinkedList(new int[] {1, 2});
        LinkedListNode problem_7a_2 = _createLinkedList(new int[] {1, 2, 2});
        problem_7a_1.next.next = problem_7a_2.next.next;                // Corrupting list
        LinkedListNode problem_7b_1 = _createLinkedList(new int[] {1});
        LinkedListNode problem_7b_2 = _createLinkedList(new int[] {5, 8, 10});
        problem_7b_1.next = problem_7b_2.next;                          // Corrupting list
        LinkedListNode problem_7c_1 = _createLinkedList(new int[] {1, 2, 3, 4});
        LinkedListNode problem_7c_2 = _createLinkedList(new int[] {5, 6, 8, 1});
        problem_7c_1.next.next.next.next = problem_7c_2.next.next;      // Corrupting list

        LinkedListNode problem_7d_1 = _createLinkedList(new int[] {1, 2, 2});
        LinkedListNode problem_7d_2 = _createLinkedList(new int[] {1, 2, 2});
        LinkedListNode problem_7e_1 = _createLinkedList(new int[] {1, 8, 10});
        LinkedListNode problem_7e_2 = _createLinkedList(new int[] {5, 8, 10});
        LinkedListNode problem_7f_1 = _createLinkedList(new int[] {1, 2, 3, 4, 8, 1});
        LinkedListNode problem_7f_2 = _createLinkedList(new int[] {5, 6, 8, 1});

        assert problem7(problem_7a_1, problem_7a_2).data == 2;
        assert problem7(problem_7b_1, problem_7b_2).data == 8;
        assert problem7(problem_7c_1, problem_7c_2).data == 8;
        assert problem7(problem_7d_1, problem_7d_2) == null;
        assert problem7(problem_7e_1, problem_7e_2) == null;
        assert problem7(problem_7f_1, problem_7f_2) == null;

//        // Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning
//        // of the loop.
//        // Input A B C D E C
//        // Output C
    }

    private LinkedListNode _createLinkedList(int[] arr) {
        LinkedListNode head = new LinkedListNode(arr[0]);
        for (int i = 1; i < arr.length; i++) head.append(arr[i]);
        return head;
    }

    private boolean _verifyLinkedList(LinkedListNode head, int[] arr) {
        LinkedListNode node = head;
        int i = 0;

        while (node != null) {
            if (node.data != arr[i++]) return false;
            node = node.next;
        }
        return true;
    }

    private boolean _printLinkedList(LinkedListNode head) {
        LinkedListNode node = head;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
        return true;
    }

    // TODO this doesnt feel right, it can be improved to O(n) using a hashmap maybe?
    // O(n^2) approach, 2 references, iterating ahead, no buffer, deletes previous
    private LinkedListNode problem1(LinkedListNode head) {
        LinkedListNode i = head;
        LinkedListNode j;

        while(i.next != null) {
            j = i.next;
            while (j != null) {
                if (i.data == j.data) head = head.deleteNode(head, j.data);
                j = j.next;
            }
            i = i.next;
        }
        return head;
    }

    // O(n) approach, simply obtains length and uses that to derive kth
    private int problem2(LinkedListNode head, int k) {
        LinkedListNode node = head;
        int i = 0;

        while (node.next != null) {
            i++;
            node = node.next;
        }

        i -= k;
        node = head;
        for (int j = i; j > 0; j--) node = node.next;
        return node.data;
    }

    // O(1) approach, just reassign
    private void problem3(LinkedListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    // O(n) approach, iterate below the pivot first, then after
    private LinkedListNode problem4(LinkedListNode head, int pivot) {
        LinkedListNode new_list_head = new LinkedListNode(0);
        LinkedListNode node = head;

        while (node != null) {
            if (node.data < pivot) new_list_head.append(node.data);
            node = node.next;
        }

        node = head;
        while (node != null) {
            if (node.data >= pivot) new_list_head.append(node.data);
            node = node.next;
        }

        return new_list_head.next;  // Skip initial 0
    }

    // Helper for problem 5
    private int _problem_5_sum_nodes(LinkedListNode node) {
        int sum = 0;
        int scale = 1;

        while (node != null) {
            sum += node.data * scale;
            node = node.next;
            scale *= 10;
        }
        return sum;
    }

    // O(n + m) where n and m are the sizes of the linked lists
    private LinkedListNode problem5a(LinkedListNode a, LinkedListNode b) {
        int sum = _problem_5_sum_nodes(a) + _problem_5_sum_nodes(b);
        LinkedListNode value = new LinkedListNode(0);

        while (sum > 0) {
            value.append(sum % 10);
            sum /= 10;
        }
        return value.next;
    }

    private LinkedListNode problem5b(LinkedListNode a, LinkedListNode b) {
        int multiplier = 10;
        int sum = _problem_5_sum_nodes(a) + _problem_5_sum_nodes(b);
        LinkedListNode value = new LinkedListNode(0);

        // Sets this to the first digit of the sum
        while (sum > multiplier) multiplier *= 10;
        multiplier /= 10;

        while (multiplier > 0) {
            value.append(sum / multiplier);
            sum %= multiplier;
            multiplier /= 10;
        }
        return value.next;
    }

    // O(n) approach using array list
    private boolean problem6(LinkedListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        LinkedListNode node = head;
        int len = 0;

        while (node != null) {
            arr.add(node.data);
            len++;
            node = node.next;
        }

        node = head;
        for (int i = 0; i < len / 2; i++) {
            if (node.data != arr.get(len - 1 - i)) return false;
            node = node.next;
        }
        return true;
    }

    // Helper for problem 7
    private LinkedListNode _problem_7_node_in_list(LinkedListNode node, LinkedListNode list_head) {
        LinkedListNode list_node = list_head;
        while (list_node != null) {
            if (list_node == node) return node;
            list_node = list_node.next;
        }
        return null;
    }

    // TODO Can this be improved?
    // Simple solution is O(n^2) by iterating both lists and comparing as you go.
    private LinkedListNode problem7(LinkedListNode a, LinkedListNode b) {
        LinkedListNode a_node = a;

        while (a_node != null) {
            if (_problem_7_node_in_list(a_node, b) != null) return a_node;
            a_node = a_node.next;
        }
        return null;
    }
}
