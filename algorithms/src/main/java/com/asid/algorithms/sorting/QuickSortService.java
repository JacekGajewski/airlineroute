package com.asid.algorithms.sorting;

import com.asid.foundation.messages.StandardMessages;

import java.util.Comparator;
import java.util.List;

/**
 * Quick sort algorithm
 */
public class QuickSortService extends AbstractSortService {

    public static <T> SortResultDs<T> sort(List<T> list, Comparator<? super T> comparator) {

        long startTime  = System.currentTimeMillis();

        SortResultDs sortResultDs = new SortResultDs();

        sortResultDs.setResult(qSort(list, 0, list.size() - 1, comparator));

        long stopTime  = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        sortResultDs.setEstimatedTime(elapsedTime);

        return sortResultDs;
        //throw new UnsupportedOperationException(StandardMessages.METHOD_NOT_IMPLEMENTED);
    }

    public static <T> List qSort(List<T> list, int start, int end, Comparator<? super T> comparator){

        int pIndex;

        if(start < end){

            pIndex = partition(list, start, end, comparator);
            qSort(list, start, pIndex - 1, comparator);
            qSort(list,pIndex + 1, end, comparator);
        }
        return list;
    }

    public static <T> int partition(List<T> list, int start, int end, Comparator<? super T> comparator){

        T temp;
        T pivot = list.get(end);
        int pIndex = start;
        for(int i = start; i < end; i++){
            if(comparator.compare(list.get(i), pivot) == -1 ||
                    comparator.compare(list.get(i), pivot) == 0){
                temp = list.get(pIndex);
                list.set(pIndex, list.get(i));
                list.set(i, temp);
                pIndex++;
            }
        }
        temp = list.get(pIndex);
        list.set(pIndex, pivot);
        list.set(end, temp);
        return pIndex;
    }

}
