package com.asid.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Test for Insertion sort algorithm
 */
public class InsertionSortServiceTest {


    @Test
    public void shouldDoSth(){
        List<Integer> list = new LinkedList<>();

        list.add(2);
        list.add(8);
        list.add(122);
        list.add(9);
        list.add(4);
        list.add(-27);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return 1;
                }else if(o1 < o2){
                    return -1;
                }else return 0;
            }
        };
        InsertionSortService insertionSortService = new InsertionSortService();
        SortResultDs sortResultDs = insertionSortService.sort(list, comparator);

        Assert.assertEquals(6, sortResultDs.getResult().size());
        Assert.assertEquals(4, sortResultDs.getResult().indexOf(9));
        Assert.assertEquals(-27, sortResultDs.getResult().get(0));
        Assert.assertTrue(sortResultDs.getResult().contains(-27));



    }


}