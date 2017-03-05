package com.asid.foundation.datastructure.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Example for students
 * JUnit test forCustomArrayList
 */
public class CustomArrayListTest {
    List<Integer> list = null;

    @Before
    public void setup() {
        list = new CustomArrayList();
    }

    @Test
    @Ignore /* remove this line and write other tests. */
    public void shouldAddOneElement() {
        // Pre
        list.clear();

        //Act
        list.add(2);
        list.add(3);

        //Assert
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(2, (int) list.get(0));
        Assert.assertEquals(3, (int) list.get(1));
    }
}
