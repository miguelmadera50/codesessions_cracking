package com.company;

import java.util.ArrayList;
import java.util.EmptyStackException;

class PlateStack {
    ArrayList<Stack> array_stack = new ArrayList<>();
    ArrayList<Integer> stack_sizes = new ArrayList<>();

    int threshold;
    int current_stack = 0;
    int current_top = 0;

    public PlateStack(int threshold) {
        this.threshold = threshold;
        array_stack.add(new Stack());
        stack_sizes.add(0);
    }

    public void push (int item) {
        if (current_top == threshold) {  // At top of current stack
            current_top = 1;
            current_stack++;

            try {
                array_stack.get(current_stack).push(item);  // stack exists but is (should be) empty
            } catch (IndexOutOfBoundsException e) {
                array_stack.add(new Stack());
                array_stack.get(current_stack).push(item);  // stack doesn't yet exist
            }

            try {
                stack_sizes.set(current_stack, stack_sizes.get(current_stack) + 1);  // stack count exists here
            } catch (IndexOutOfBoundsException e) {
                stack_sizes.add(1);  // This will always be 1
            }
        } else {
            current_top++;
            array_stack.get(current_stack).push(item);
            stack_sizes.set(current_stack, stack_sizes.get(current_stack) + 1);
        }
    }

    // Can also be implemented as the default with pop() calling popAt(current_stack)
    public int popAt(int stack_position) {
        if (stack_position > current_stack) throw new EmptyStackException();
        if (stack_position == current_stack) return this.pop();


        Stack selected_stack = array_stack.get(stack_position);  // Copy reference
        if (selected_stack.isEmpty()) throw new EmptyStackException();

        stack_sizes.set(stack_position, stack_sizes.get(stack_position) - 1);
        return selected_stack.pop();
    }

    public int pop() {
        if (current_stack == 0 && current_top == 0) throw new EmptyStackException();
        if (current_top == 1) {  // Once this is popped, top will have to be set again
            int pop_value = array_stack.get(current_stack).pop();

            // Set current stack size to 0
            stack_sizes.set(current_stack, 0);

            // Find next empty stack
            for (int i = current_stack; i >= 0; i--) {
                if (stack_sizes.get(i) != 0 || i == 0) {  // 0 is min size
                    current_stack = i;
                    break;
                }
            }

            // Set current_top to stack size
            current_top = stack_sizes.get(current_stack);
            return pop_value;
        }

        stack_sizes.set(current_stack, stack_sizes.get(current_stack) - 1);
        current_top--;
        return array_stack.get(current_stack).pop();
    }

    public void printPlateStack() {
        System.out.println("current stack: " + current_stack);
        System.out.println("current top: " + current_top);
        for (int i = 0; i <= current_stack; i++) {
            try {
                System.out.print("PEEK: " + array_stack.get(i).peek() + " ");
            } catch (EmptyStackException e) {
                System.out.print("PEEK: EMPTY ");
            }
            System.out.print("SIZE: " + stack_sizes.get(i));
            System.out.println();
        }
        System.out.println();
    }
}
