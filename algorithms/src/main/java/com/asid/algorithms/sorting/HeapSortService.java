package com.asid.algorithms.sorting;

import com.asid.foundation.datastructure.list.CustomArrayList;
import com.asid.foundation.datatype.CustomPriorityQueue;
import com.asid.foundation.messages.StandardMessages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * HeapSort sort algorithm
 */
public class HeapSortService extends AbstractSortService {

    public static <T> SortResultDs<T> sort(List<T> list, Comparator<? super T> comparator) {

        long startTime = System.currentTimeMillis();
        SortResultDs sortResultDs = new SortResultDs();

        List<T> temp = new CustomArrayList<>();

        CustomPriorityQueue<T> customPriorityQueue = new CustomPriorityQueue(list.size(), comparator);

        for (T t : list){
            customPriorityQueue.add(t);
        }
        int j = customPriorityQueue.size();
        for(int i = 0; i < j; i++){
            temp.add(customPriorityQueue.poll());
        }
        sortResultDs.setResult(temp);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        sortResultDs.setEstimatedTime(elapsedTime);

        return sortResultDs;
        //throw new UnsupportedOperationException(StandardMessages.METHOD_NOT_IMPLEMENTED);
    }
}
