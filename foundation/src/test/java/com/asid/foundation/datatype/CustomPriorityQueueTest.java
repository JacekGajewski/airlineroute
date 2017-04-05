package com.asid.foundation.datatype;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Queue;

/**
 * Test for CustomPriorityQueue
 */
public class CustomPriorityQueueTest {
    private final static double DELTA = 0.01;

    @Test
    public void shouldAddAndRemoveNumbersAscending() {
        //Pre
        Queue<Integer> q = new CustomPriorityQueue<>(10, (n1, n2) -> n1.compareTo(n2));

        //Act
        q.add(20);
        q.add(3);
        q.add(1);
        q.add(10);
        q.add(2);

        //Assert
        Assert.assertEquals(1, q.poll(), DELTA);
        Assert.assertEquals(2, q.poll(), DELTA);
        Assert.assertEquals(3, q.poll(), DELTA);
        Assert.assertEquals(10, q.peek(), DELTA);
        Assert.assertEquals(10, q.poll(), DELTA);
        Assert.assertEquals(20, q.poll(), DELTA);
    }


    @Test
    public void shouldAddAndRemoveNumbersDescending() {
        //Pre
        Queue<Integer> q = new CustomPriorityQueue<>(10, (n1, n2) -> n2.compareTo(n1));

        //Act
        q.add(20);
        q.add(3);
        q.add(1);
        q.add(10);
        q.add(2);

        //Assert
        Assert.assertEquals(20, q.poll(), DELTA);
        Assert.assertEquals(10, q.poll(), DELTA);
        Assert.assertEquals(3, q.poll(), DELTA);
        Assert.assertEquals(2, q.peek(), DELTA);
        Assert.assertEquals(2, q.poll(), DELTA);
        Assert.assertEquals(1, q.poll(), DELTA);
    }
}