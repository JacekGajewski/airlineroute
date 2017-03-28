package com.asid.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * Test for selection sort algorithm.
 */
public class SelectionSortServiceTest {


    @Test
    public void shouldDoSth(){
        SelectionSortService test = new SelectionSortService();

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(-4);
        list.add(123);
        list.add(4);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return 1;
                }else if(o1<o2){
                    return -1;
                }
                return 0;
            }
        };

        SortResultDs<Integer> sort = test.sort(list, comparator);

        Assert.assertEquals(-4,(int) sort.getResult().get(0));
        Assert.assertEquals(1,(int) sort.getResult().get(1));
        Assert.assertEquals(123,(int) sort.getResult().get(5));





    }




}