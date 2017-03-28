package com.asid.algorithms.sorting;

import com.asid.foundation.messages.StandardMessages;

import java.util.*;

/**
 * Insertion sort algorithm
 */
public class InsertionSortService extends AbstractSortService {

    public static <T> SortResultDs<T> sort(List<T> list, Comparator<? super T> comparator) {

        SortResultDs sortResultDs = new SortResultDs();
        List<T> temp = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        /*if(comparator.compare(list.get(0), list.get(1)) == 1){
            temp.add(0, list.get(1));
            temp.add(1, list.get(0));
        }else{
            temp.add(0, list.get(0));
            temp.add(1, list.get(1));
        }*/

        for(T l : list){
            if(temp.size() < 2){
                if(temp.isEmpty()) {
                    temp.add(l);
                    continue;
                }else{
                    if(comparator.compare(l , temp.get(0)) == 1){
                        temp.add(l);
                    }else temp.add(0, l);
                    continue;
                }
            }
            if(comparator.compare(l , temp.get(0)) == -1) {
                temp.add(0, l);
                continue;
            }
            for(int i = 0; i < temp.size(); i++){
                if(comparator.compare(l , temp.get(i)) == 1 &&
                        i + 1 == temp.size()){
                    temp.add(i + 1, l);
                    break;

                }else if((comparator.compare(l , temp.get(i)) == 1 ||
                        comparator.compare(l , temp.get(i)) == 0) &&
                        (comparator.compare(l , temp.get(i + 1)) == -1 ||
                        comparator.compare(l , temp.get(i + 1)) == 0)){
                    temp.add(i + 1, l);
                    break;
                }
            }
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        sortResultDs.setEstimatedTime(elapsedTime);
        sortResultDs.setResult(temp);
        return sortResultDs;
        //throw new UnsupportedOperationException(StandardMessages.METHOD_NOT_IMPLEMENTED);
    }
}
