package com.asid.foundation.datatype;

import com.asid.foundation.datastructure.list.CustomArrayList;
import com.asid.foundation.datastructure.list.CustomLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Deque;

/**
 * JUnit test for CustomStack
 */
public class CustomStackTest {

    Deque<Integer> stack = null;

    @Before
    public void setup() throws Exception {
        stack = new CustomStack(new CustomLinkedList());
    }

    @Test
    public void shouldAddToStackSomeNumbers() {
        // Act
        stack.push(1);
        stack.push(2);
        stack.push(3);

        //Assert
        Assert.assertEquals(3, (int) stack.pop());
        Assert.assertEquals(2, (int) stack.pop());
        Assert.assertEquals(1, (int) stack.pop());
        Assert.assertEquals(true, stack.isEmpty());
    }

}