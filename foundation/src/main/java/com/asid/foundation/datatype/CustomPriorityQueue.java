package com.asid.foundation.datatype;

import com.asid.foundation.datastructure.list.CustomArrayList;

import java.util.Comparator;
import java.util.List;

/**
 * CustomPriorityQueue data type.
 */
public class CustomPriorityQueue<T> extends AbstractCustomPriorityQueueAdapter<T> {
    private Comparator<? super T> comparator = null;
    private List<T> list = null;
    /* (TODO Lab No. 5) Please introduce a sensible implementation */

    public CustomPriorityQueue(int initialCapacity, Comparator<? super T> comparator) {
        this.comparator = comparator;
        list = new CustomArrayList<>(initialCapacity);
    }

    @Override
    public int size() {
         /* (TODO Lab No. 5) Please introduce a sensible implementation */
        return 0;
    }

    @Override
    public boolean isEmpty() {
         /* (TODO Lab No. 5) Please introduce a sensible implementation */
        return false;
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param t
     * @return
     */
    @Override
    public boolean add(T t) {
         /* (TODO Lab No. 5) Please introduce a sensible implementation */
        return false;
    }

    /**
     * Removes all of the elements from this priority queue.
     */
    @Override
    public void clear() {
 /* (TODO Lab No. 5) Please introduce a sensible implementation */
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return
     */
    @Override
    public T poll() {
         /* (TODO Lab No. 5) Please introduce a sensible implementation */
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return
     */
    @Override
    public T peek() {
         /* (TODO Lab No. 5) Please introduce a sensible implementation */
        return null;
    }
}
