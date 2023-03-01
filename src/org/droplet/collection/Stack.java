package org.droplet.collection;

import java.util.NoSuchElementException;

public class Stack<E> {
    private final Node<E> head = new Node<>(null);

    public void push(E element) {
        Node<E> node = new Node<>(element);
        node.next = head.next;
        head.next = node;
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("栈为空");
        }
        E e = head.next.element;
        head.next = head.next.next;
        return e;
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
