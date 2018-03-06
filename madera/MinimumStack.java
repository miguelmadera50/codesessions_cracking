package com.company;

import java.util.EmptyStackException;

import static java.lang.Integer.MAX_VALUE;

class MinimumStack extends Stack {
    private Stack min_stack = new Stack();
    private StackNode top;

    MinimumStack() {
        min_stack.push(MAX_VALUE);
    }

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
        }
    }

    public int pop() {
        if (top == null) throw new EmptyStackException();
        min_stack.pop();

        int item = top.data;
        top = top.next;
        return item;
    }

    public void push (int item) {
        if (item < min_stack.peek()) min_stack.push(item);

        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
    }

    public int min() {
        if (top == null) throw new EmptyStackException();
        return min_stack.peek();
    }
}
