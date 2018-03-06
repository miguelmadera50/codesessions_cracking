package com.company;

import java.util.EmptyStackException;

public class ThreeStackArray {
    private int[] array = new int[1024];  // TODO Should be resizable array
    private int[] tops_index = new int[] {-3, -2, -1};  // Stacks are labeled 0, 1, 2

    public int pop(int stack) {

        // Base conditions
        if (stack < 0 || stack > 2) throw new IndexOutOfBoundsException();
        if (tops_index[stack] < 0) throw new EmptyStackException();

        int val = array[tops_index[stack]];
        tops_index[stack] -= 3;
        return val;
    }

    public void push(int stack, int item) {

        // Base condition
        if (stack < 0 || stack > 2) throw new IndexOutOfBoundsException();

        tops_index[stack] += 3;
        array[tops_index[stack]] = item;
    }

    public int peek(int stack) {
        if (stack < 0 || stack > 2) throw new IndexOutOfBoundsException();
        if (tops_index[stack] < 0) throw new EmptyStackException();
        return array[tops_index[stack]];
    }

    public boolean isEmpty(int stack) {
        return tops_index[stack] < 0;
    }
}
