package com.company;

import java.util.EmptyStackException;

class MyQueue {
    private Stack push_stack = new Stack();
    private Stack pop_stack = new Stack();

    public void add(int item) {
        push_stack.push(item);
    }

    public int remove() {
        if (pop_stack.isEmpty() && push_stack.isEmpty()) throw new EmptyStackException();
        if (pop_stack.isEmpty()) flip_arrays();
        return pop_stack.pop();
    }

    public int peek() {
        if (pop_stack.isEmpty() && push_stack.isEmpty()) throw new EmptyStackException();
        if (pop_stack.isEmpty()) flip_arrays();
        return pop_stack.peek();
    }

    public boolean isEmpty() {
        return pop_stack.isEmpty() && push_stack.isEmpty();
    }

    private void flip_arrays() {
        while (!push_stack.isEmpty()) pop_stack.push(push_stack.pop());
    }
}
