package com.asid.algorithms.sorting;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractSortService {

    /**
     * Method compares two objects using a comparator
     *
     * @param o1
     * @param o2
     * @param comparator
     * @param <T>
     * @return
     */
    protected static <T> boolean less(T o1, T o2, Comparator<? super T> comparator) {

        return comparator.compare(o1,o2) < 0;
    }

    /**
     * Method swaps two objects in the list, using their position.
     *
     * @param list
     * @param o1Pos
     * @param o2Pos
     */
    protected static <T> void exch(List<T> list, int o1Pos, int o2Pos) {

        T a = list.get(o1Pos);
        T b = list.get(o2Pos);

        list.set(o1Pos, b);
        list.set(o2Pos, a);

    }

    /**
     * Method swaps two objects in the list, using their references.
     *
     * @param list
     * @param o1
     * @param o2
     */
    protected static <T> void exch(List<T> list, Object o1, Object o2) {

        int a = list.indexOf(o1);
        int b = list.indexOf(o2);

        list.set(a,(T) o2);
        list.set(b,(T) o1);

    }
}
