package com.company;

import java.util.NoSuchElementException;

class ShelterQueue {
    private LinkedListNode dog_head;
    private LinkedListNode cat_head;
    private LinkedListNode animal_head; // 1s are dogs, 0 are cats

    public void add(int item, int is_dog) {
        if (is_dog == 1) {
            if (this.dog_head == null) this.dog_head = new LinkedListNode(item);
            else this.dog_head.append(item);
        }
        else {
            if (this.cat_head == null) this.cat_head = new LinkedListNode(item);
            else this.cat_head.append(item);
        }

        if (this.animal_head == null) this.animal_head = new LinkedListNode(item);
        else this.animal_head.append(is_dog);
    }

    public int dequeueDog(){
        if (this.dog_head == null) throw new NoSuchElementException();
        delete_from_any(1);

        int val = this.dog_head.data;
        this.dog_head = this.dog_head.next;
        return val;
    }

    public int dequeueCat(){
        if (this.cat_head == null) throw new NoSuchElementException();
        delete_from_any(0);

        int val = this.cat_head.data;
        this.cat_head = this.cat_head.next;
        return val;
    }

    public int dequeueAny(){
        if (this.animal_head == null) throw new NoSuchElementException();
        if (this.animal_head.data == 1) return dequeueDog();
        else return dequeueCat();
    }

    private void delete_from_any(int animal_type) {
        // Base case, delete first
        if (this.animal_head.data == animal_type) {
            this.animal_head = this.animal_head.next;
            return;
        }

        LinkedListNode animal_node = this.animal_head;
        while (animal_node.next != null) {
            if (animal_node.next.data == animal_type) {
                animal_node.next = animal_node.next.next;
                return;
            }
            animal_node = animal_node.next;
        }
        throw new NoSuchElementException();  // Should never get here
    }

    void printShelterQueue() {
        LinkedListNode cat_node = this.cat_head;
        LinkedListNode dog_node = this.dog_head;
        LinkedListNode animal_node = this.animal_head;

        System.out.println("ANY:" + this.animal_head);
        while (animal_node != null) {
            System.out.print(animal_node.data + " ");
            animal_node = animal_node.next;
        }
        System.out.println();
        System.out.println();

        System.out.println("DOG:" + this.dog_head);
        while (dog_node != null) {
            System.out.print(dog_node.data + " ");
            dog_node = dog_node.next;
        }
        System.out.println();
        System.out.println();

        System.out.println("CAT:" + this.cat_head);
        while (cat_node != null) {
            System.out.print(cat_node.data + " ");
            cat_node = cat_node.next;
        }
        System.out.println();
        System.out.println();
    }
}
