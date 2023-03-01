package org.droplet.collection;

public class ArrayList<E> {
    private int size = 0;
    private int capacity = 10;
    private Object[] array = new Object[capacity];

    public void add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ " + size);
        }
        if (size >= capacity) {
            int newCapacity = capacity + (capacity >> 1); // 扩容为原来的 1.5 倍
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            capacity = newCapacity;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(array[i]).append(" ");
        }
        return builder.toString();
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("删除位置非法，合法的删除位置为：0 ~ " + (size - 1));
        }
        E e = (E) array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return e;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("非法的位置，合法的位置为：0 ~ " + (size - 1));
        }
        return (E) array[index];
    }

    public int size() {
        return size;
    }
}
