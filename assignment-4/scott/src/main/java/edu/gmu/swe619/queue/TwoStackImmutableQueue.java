package edu.gmu.swe619.queue;

public final class TwoStackImmutableQueue<E> {
    // We use two separate linked lists (stacks)
    private final Node<E> in;  // For adding
    private final Node<E> out; // For removing

    // Initial empty queue
    public TwoStackImmutableQueue() {
        this.in = null;
        this.out = null;
    }

    // Private constructor for internal state transitions
    private TwoStackImmutableQueue(Node<E> in, Node<E> out) {
        this.in = in;
        this.out = out;
    }

    // PRODUCER: O(1) - Just create one new node and point to the old 'in' stack
    public TwoStackImmutableQueue<E> enQueue(E e) {
        return new TwoStackImmutableQueue<>(new Node<>(e, in), out);
    }

    // OBSERVER: O(1) amortized
    public E getFirst() {
        if (isEmpty()) throw new IllegalStateException("Empty Queue");
        // If out-stack is empty, the "first" item is at the bottom of the in-stack
        if (out == null) {
            return reverse(in).value;
        }
        return out.value;
    }

    // PRODUCER: O(1) amortized
    public TwoStackImmutableQueue<E> deQueue() {
        if (isEmpty()) throw new IllegalStateException("Empty Queue");

        if (out != null) {
            return new TwoStackImmutableQueue<>(in, out.next);
        } else {
            // "Flip" the in-stack into the out-stack
            return new TwoStackImmutableQueue<>(null, reverse(in).next);
        }
    }

    public boolean isEmpty() {
        return in == null && out == null;
    }

    // Helper to reverse a linked list (the "Flip")
    private Node<E> reverse(Node<E> node) {
        Node<E> prev = null;
        while (node != null) {
            prev = new Node<>(node.value, prev);
            node = node.next;
        }
        return prev;
    }

    // Internal Immutable Linked List Node
    private static class Node<T> {
        final T value;
        final Node<T> next;
        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
