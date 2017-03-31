package com.asid.algorithms.sorting;

import com.asid.foundation.messages.StandardMessages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Merge sort algorithm algorithm
 */
public class MergeSortService extends AbstractSortService {

    static long startTime = System.currentTimeMillis();

    public static <T> SortResultDs<T> sort(List<T> list, Comparator<? super T> comparator) {

        SortResultDs<T> sortResultDs = new SortResultDs<>();
        List<T> temp = new ArrayList<>();

        int n = list.size();
        if(n < 2){
            temp.add(list.get(0));
            sortResultDs.setResult(temp);
            return sortResultDs;
        }
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();

        int length = list.size()/2;
        int rest = list.size() - length;

        for (int i = 0; i < length; i++){
            left.add(list.get(i));
        }
        for (int i = 0; i < rest; i++){
            right.add(list.get(length + i));
        }

        sortResultDs.setResult(merge(sort(left, comparator).getResult(), sort(right, comparator).getResult(), comparator));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        sortResultDs.setEstimatedTime(elapsedTime);
        return sortResultDs;


        //throw new UnsupportedOperationException(StandardMessages.METHOD_NOT_IMPLEMENTED);
    }

    public static <T>List<T> merge(List<T> leftList, List<T> rightList, Comparator<? super T> comparator){

        List<T> result = new LinkedList<>();
        int i = 0;
        int j = 0;
        while(i < leftList.size() && j < rightList.size()){
            if(comparator.compare(leftList.get(i), rightList.get(j)) != -1){
                result.add(rightList.get(j));
                j++;
            }else{
                result.add(leftList.get(i));
                i++;
            }
        }
        while(i < leftList.size()){
           result.add(leftList.get(i));
           i++;
        }
        while(j < rightList.size()){
            result.add(rightList.get(j));
            j++;
        }
        return result;
    }
}