package org.droplet.collection;

public class LinedList<E> {
    // 链表的头节点，用于连接之后的所有节点
    private final Node<E> head = new Node<>(null);
    private int size = 0;

    public void add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ " + size);
        }
        Node<E> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<E> node = new Node<>(element);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("删除位置非法，合法的删除位置为：0 ~ " + (size - 1));
        }
        Node<E> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        E e = prev.element;
        prev.next = prev.next.next;
        return e;
    }

    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("非法的位置，合法的位置为：0 ~ " + (size - 1));
        }
        Node<E> node = head;
        while (index-- >= 0) {
            node = node.next;
        }
        return node.element;
    }

    public int size(){
        return size;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = head.next;
        while (node != null) {
            builder.append(node.element).append(" ");
            node = node.next;
        }
        return builder.toString();
    }
}
