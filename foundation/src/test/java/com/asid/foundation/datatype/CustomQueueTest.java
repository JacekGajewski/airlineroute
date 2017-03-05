package com.asid.foundation.datatype;

import com.asid.foundation.datastructure.list.CustomArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Queue;

/**
 * JUnit test for CustomQueueTest
 */
public class CustomQueueTest {
    private Queue<Integer> queue = null;

    @Before
    public void setUp() throws Exception {
        queue = new CustomQueue(new CustomArrayList());
    }

    @Test
    @Ignore /* remove this line and write other tests. */
    public void shouldAddToQueueSomeNumbers() {
        // Act
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //Assert
        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(1, (int) queue.peek());
        Assert.assertEquals(1, (int) queue.poll());
        Assert.assertEquals(2, (int) queue.poll());
        Assert.assertEquals(3, (int) queue.poll());
        Assert.assertEquals(true, queue.isEmpty());
    }
}