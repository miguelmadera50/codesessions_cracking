package com.company;

public class LinkedListNode {
    LinkedListNode next = null;
    int data;

    public LinkedListNode(int d) {
        data = d;
    }

    void append(int d) {
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = this;

        while (n.next != null) n = n.next;
        n.next = end;
    }

    LinkedListNode deleteNode(LinkedListNode head, int d) {
        LinkedListNode n = head;
        if (n.data == d) return head.next;

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}


//2.1
//// Remove Dupes: Write code to remove duplicates from an unsorted linked list. FOLLOW UP: How would you solve
//// this problem if a temporary buffer is not allowed?
//// Note: There may be many solutions to this depending on where the removal is performed
//        (1, 1) -> (1)
//        (1, 2, 1) -> (1, 2)
//        (4, 3, 3, 4, 4) -> (4, 3)
//        (1, 4, 5, 5, 8, 2, 4, 1, 7, 1) -> (1, 4, 5, 8, 2, 7)
//
//
//        2.2
//// Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list
//        (5, 4, 3, 2, 1, 0), k -> k  // Answer to any is the element itself
//
//
//        2.3
//// Delete Middle Node: Implement an algorithm to delete a node in the model (i.e., any node but the first and
//// last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
//        (1, 2, 3, 4), 2 -> (1, 3, 4)
//        (1, 2, 3, 4), 3 -> (1, 2, 4)
//        (1, 2, 3, 4, 5), 3 -> (1, 2, 4, 5)
//
//
//        2.4
//// Partition: Write code to partition a linked list around a value x, such that all nodes less than x com before
//// all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be
//// after the elements less than x. The partition element x can appear anywhere in the "right partition"; it does
//// not need to appear between the lest and right partitions.
//// 3 5 8 5 10 2 1 partition = 5
//// 3 1 2 10 5 5 8
//// Note: There may be many solutions to this since the elements can appear anywhere before / after the partition.
//        (3, 5, 8, 5, 10, 2, 1), 5 -> (3, 1, 2, 10, 5, 5, 8)
//        (3, 5, 8, 5, 10, 2, 1), 3 -> (3, 2, 1, 5, 8, 5, 10)
//        (3, 5, 8, 5, 10, 2, 1), 8 -> (3, 5, 5, 2, 1, 8, 10)
//
//
//        2.5
//// Sum Lists: You have two numbers represented in a linked list, where each node contains a single digit. The
//// digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that
//// adds the two numbers and returns the sum as a linked list. FOLLOW UP: Suppose the digits are stored in forward
//// order, repeat the above problem.
//        Original Problem:
//        (7, 1, 6), (5, 9, 2) -> (2, 1, 9)  // 617 + 295 = 912
//        (1, 7, 4), (2, 5, 4, 1) -> (3, 2, 9, 1)  // 471 + 1452 = 1923
//        (7, 1), (5, 3, 1) -> (2, 5, 1)  // 17 + 135 = 152
//
//        Follow Up:
//        (7, 1, 6), (5, 9, 2) -> (9, 1, 2)  // 617 + 295 = 912
//        (1, 7, 4), (2, 5, 4, 1) -> (1, 9, 2, 3)  // 471 + 1452 = 1923
//        (7, 1), (5, 3, 1) -> (1, 5, 2)  // 17 + 135 = 152
//
//
//        2.6
//// Palindrome: Implement a function to check if a linked list is a palindrome.
//        Positive
//        (1)
//        (1, 1)
//        (1, 1, 1)
//        (1, 3, 1)
//        (1, 2, 2, 1)
//        (1, 2, 3, 2, 1)
//
//        Negative
//        (1, 2)
//        (1, 1, 3)
//        (1, 3, 2, 1)
//        (2, 2, 1, 2)
//        (1, 2, 3, 2, 1, 1)
//
//
//        2.7
//// Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
//// node. Note that the intersection is defined based on reference, not value. That is, if the kth node of the
//// first linked list is the exact same node (by reference) as the jth node of the second linked list, then they
//// are intersecting.
//        Positive
//        1 - 2  \
//        1 - 2 - 2
//
//        1  \
//        5 - 8 - 10
//
//        1 - 2 - 3 - 4  \
//                5 - 6 - 8 - 1
//
//        Negative
//        (1, 2, 2), (1, 2, 2)
//        (1, 8, 10), (5, 8, 10)
//        (1, 2, 3, 4, 8, 1), (5, 6, 8, 1)
//
//
//        2. 8
//// Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning
//// of the loop.
//        1 - 2 - 3
//        |   |  -> 3
//        -----
//
//        1 - 2 - 3
//        |       |  -> 3
//        ---------
//
//        1 - 2 - 3 - 4 - 5 - 6
//        |           |  -> 6
//        -------------
//
//        1 - 2 - 3 - 4 - 5 - 6
//        |       |  -> 6
//        ---------
//
//        1 - 2 - 3 - 4 - 5
//        |   |  -> 5
//        -----
