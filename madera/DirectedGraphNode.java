package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class DirectedGraphNode {
    int data;
    ArrayList<DirectedGraphNode> adjacent_nodes;

    DirectedGraphNode(int d) {
        this.data = d;
        this.adjacent_nodes = new ArrayList<>();
    }

    void add_adjacent(DirectedGraphNode node) {
        this.adjacent_nodes.add(node);
    }

    boolean is_adjacent(DirectedGraphNode node) {
        for (int i = 0; i < adjacent_nodes.size(); i++) {
            if (adjacent_nodes.get(i).data == node.data) return true;
        }
        return false;
    }
}

// Same implementation as Queue just for graph nodes
class DirectedGraphNodeQueue {
    static class GraphQueueNode {
        DirectedGraphNode node;
        GraphQueueNode next;

        GraphQueueNode(DirectedGraphNode n) {
            this.node = n;
        }
    }

    private GraphQueueNode first;
    private GraphQueueNode last;

    public void enqueue(DirectedGraphNode node) {
        GraphQueueNode t = new GraphQueueNode(node);
        if (last != null) last.next = t;
        last = t;

        if (first == null) first = last;
    }

    public DirectedGraphNode dequeue() {
        if (first == null) throw new NoSuchElementException();
        DirectedGraphNode node = first.node;
        first = first.next;
        if (first == null) last = null;
        return node;
    }

    public DirectedGraphNode peek() {
        if (first == null) throw new NoSuchElementException();
        return first.node;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
