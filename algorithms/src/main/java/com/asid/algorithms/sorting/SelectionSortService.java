package com.asid.algorithms.sorting;

import com.asid.foundation.messages.StandardMessages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Selection sort algorithm.
 */
public class SelectionSortService extends AbstractSortService {

    public static <T> SortResultDs<T> sort(List<T> list, Comparator<? super T> comparator) {

        long startTime = System.currentTimeMillis();
        SortResultDs<T> resultDs = new SortResultDs<>();
        List<T> temp = new ArrayList<>();
        T sth = list.get(0);
        for(int i = 0; i<list.size(); i++) {
            for (T t : list) {
                if (comparator.compare(t, sth) == 1) {
                    sth = t;
                }
            }
            temp.add(i, sth);
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        resultDs.setResult(temp);
        resultDs.setEstimatedTime(elapsedTime);

        return resultDs;

        //throw new UnsupportedOperationException(StandardMessages.METHOD_NOT_IMPLEMENTED);
    }
}

