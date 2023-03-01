package org.droplet.collection;

import java.util.NoSuchElementException;

public class Queue<E> {
    private final Node<E> head = new Node<>(null);

    public void offer(E element) {
        Node<E> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node<>(element);
    }

    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空");
        }
        E e = head.next.element;
        head.next = head.next.next;
        return e;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空");
        }
        return head.next.element;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}
