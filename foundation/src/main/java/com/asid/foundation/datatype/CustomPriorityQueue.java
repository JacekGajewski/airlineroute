package com.asid.foundation.datatype;

import com.asid.foundation.datastructure.list.CustomArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * CustomPriorityQueue data type.
 */
public class CustomPriorityQueue<T> extends AbstractCustomPriorityQueueAdapter<T> {
    private Comparator<? super T> comparator = null;
    private List<T> list = null;

    public CustomPriorityQueue(int initialCapacity, Comparator<? super T> comparator) {
        this.comparator = comparator;
        list = new CustomArrayList<>(initialCapacity);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param t
     * @return
     */
    @Override
    public boolean add(T t) {
        list.add(t);
        int index = size() - 1;

        if (list.size() == 1) return true;
        goUp(t, index);
        return true;
    }

    private void goUp(T t, int index) {
        while (comparator.compare(t, list.get(index / 2)) == -1) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void goDown(T t, int index) {
        while (size() - 1 >= 2 * index + 1 &&
                (comparator.compare(t, list.get(2 * index)) == 1 ||
                        comparator.compare(t, list.get(2 * index + 1)) == 1)) {
            if (comparator.compare(list.get(2 * index + 1), list.get(2 * index)) == -1) {
                swap(index, 2 * index + 1);
                index = 2 * index + 1;
            } else {
                swap(index, 2 * index);
                index = 2 * index;
            }
        }
    }

    private void swap(int a, int b) {
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
    /**
     * Removes all of the elements from this priority queue.
     */
    @Override
    public void clear() {
        list.clear();
    }
    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return
     */
    @Override
    public T poll() {
        if (list.size() == 0) return null;

        T temp = list.get(0);
        swap(0, size() - 1);
        list.remove(size() - 1);
        if (size() != 0) goDown(list.get(0), 0);

        return temp;
    }
    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }
}