package com.company;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

class Chapter3 {
    Chapter3() {
        // Three in one: Describe how you could use a single array to implement three stacks
        ThreeStackArray arr_stack = new ThreeStackArray();

        assert arr_stack.isEmpty(0);
        assert arr_stack.isEmpty(1);
        assert arr_stack.isEmpty(2);

        arr_stack.push(0, 1);
        arr_stack.push(0, 2);
        arr_stack.push(1, 3);
        arr_stack.push(2, 4);
        arr_stack.push(2, 5);
        arr_stack.push(1, 6);
        arr_stack.push(0, 7);
        arr_stack.push(2, 8);

        assert !arr_stack.isEmpty(0);
        assert !arr_stack.isEmpty(1);
        assert !arr_stack.isEmpty(2);

        assert arr_stack.pop(0) == 7;
        assert arr_stack.pop(1) == 6;
        assert arr_stack.pop(2) == 8;
        assert arr_stack.pop(2) == 5;
        assert arr_stack.pop(1) == 3;
        assert arr_stack.pop(0) == 2;

        assert !arr_stack.isEmpty(0);
        assert arr_stack.isEmpty(1);
        assert !arr_stack.isEmpty(2);

        // Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns
        // the minimum element? Push pop and min should all operate in O(1) time.
        MinimumStack min_stack = new MinimumStack();

        min_stack.push(5);
        assert min_stack.min() == 5;
        min_stack.push(7);
        assert min_stack.min() == 5;
        min_stack.push(3);
        assert min_stack.min() == 3;
        min_stack.push(2);
        assert min_stack.min() == 2;
        assert min_stack.pop() == 2;
        assert min_stack.min() == 3;
        assert min_stack.pop() == 3;
        assert min_stack.min() == 5;

        // Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore,
        // in real life, we would likely start a new stack when the previous stack exceeds some threshold. Implement a
        // data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should
        // create a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should
        // behave identically to a single stack. FOLLOW UP: implement a function popAt(index) which performs a pop
        // operation on a specific sub-stack.
        PlateStack plate_stack = new PlateStack(3);
        plate_stack.push(1);
        plate_stack.push(2);
        plate_stack.push(3);
        plate_stack.push(4);
        plate_stack.push(5);
        plate_stack.push(6);
        plate_stack.push(7);
        plate_stack.push(8);
        plate_stack.push(9);

        assert plate_stack.popAt(1) == 6;
        assert plate_stack.popAt(1) == 5;
        assert plate_stack.popAt(1) == 4;
        assert _assert_plate_stack_pop_at_exception(plate_stack);

        assert plate_stack.pop() == 9;
        assert plate_stack.pop() == 8;
        assert plate_stack.popAt(0) == 3;
        assert plate_stack.popAt(0) == 2;

        assert plate_stack.pop() == 7;
        assert plate_stack.pop() == 1;
        assert _assert_plate_stack_pop_exception(plate_stack);

        // Queue via stacks: Implement a MyQueue class which implements a queue using two stacks.
        MyQueue my_queue = new MyQueue();

        assert my_queue.isEmpty();
        my_queue.add(1);
        my_queue.add(2);
        my_queue.add(3);

        assert my_queue.remove() == 1;
        assert my_queue.remove() == 2;
        assert !my_queue.isEmpty();
        my_queue.add(4);
        my_queue.add(5);
        assert my_queue.remove() == 3;
        assert my_queue.remove() == 4;
        assert my_queue.remove() == 5;
        assert _assert_my_queue_remove_exception(my_queue);

//        // Sort Stack: Write a program to sort a stack such that the smallest items are on the current_top. You can use an
//        // additional temporary stack, but you may not copy the elements into any other data structure. The stack
//        // supports the following operations: push, pop, peek, isEmpty.
//        // TODO use stack as placeholder for swaps?

        // Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly first in first out
        // basis. People must adopt either the oldest (based on a arrival time) of all the animals in the shelter, or
        // they can select whether the prefer a dog or a cat. The cannot select which specific animal the would like.
        // Create the data structures to maintain the system and implement operations such as add, dequeueAny,
        // dequeueDog, dequeueCat. You may use a built-in LinkedList data structure.
        ShelterQueue shelter_queue = new ShelterQueue();
        shelter_queue.add(1, 1);
        shelter_queue.add(2, 1);
        shelter_queue.add(3, 0);
        shelter_queue.add(4, 0);

        assert shelter_queue.dequeueCat() == 3;
        assert shelter_queue.dequeueDog() == 1;
        assert shelter_queue.dequeueAny() == 2;

        shelter_queue.add(5, 1);
        shelter_queue.add(6, 0);
        shelter_queue.add(7, 1);

        assert shelter_queue.dequeueCat() == 4;
        assert shelter_queue.dequeueCat() == 6;
        assert _assert_shelter_queue_dequeue_cat(shelter_queue);

        assert shelter_queue.dequeueAny() == 5;
        assert shelter_queue.dequeueAny() == 7;
        assert  _assert_shelter_queue_dequeue_any(shelter_queue);
    }

    private boolean _assert_plate_stack_pop_at_exception(PlateStack stack) {
        try {
            stack.popAt(1);
            return false;
        } catch (EmptyStackException e) {
            return true;
        }
    }

    private boolean _assert_plate_stack_pop_exception(PlateStack stack) {
        try {
            stack.pop();
            return false;
        } catch (EmptyStackException e) {
            return true;
        }
    }

    private boolean _assert_my_queue_remove_exception(MyQueue queue) {
        try {
            queue.remove();
            return false;
        } catch (EmptyStackException e) {
            return true;
        }
    }

    private boolean _assert_shelter_queue_dequeue_cat(ShelterQueue queue) {
        try {
            queue.dequeueCat();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    private boolean _assert_shelter_queue_dequeue_any(ShelterQueue queue) {
        try {
            queue.dequeueAny();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}
