package com.asid.foundation.datastructure.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

/**
 * Example for students
 * JUnit test forCustomArrayList
 */
public class CustomArrayListTest {
    List<Integer> list = null;
    List<Object> listObject = null;

    @Before
    public void setup() {
        list = new CustomArrayList();
        listObject = new CustomArrayList();

    }

    @Test
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
    @Test
    public void shouldBeEmpty(){
        //Pre
        list.clear();

        //Assert
        Assert.assertEquals(true, list.isEmpty());
    }
    @Test
    public void shouldGetIndex(){
        //Pre
        listObject.clear();
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        //Act
        listObject.add(a);
        listObject.add(b);

        //Assert
        Assert.assertEquals(1, listObject.indexOf(b));
    }

    @Test
    public void shouldContain(){
        //Pre
        listObject.clear();
        Object a = new CustomLinkedList<>();

        //Act
        listObject.add(a);

        //Assert
        Assert.assertEquals(true, listObject.contains(a));
    }
    @Test
    public void shouldSet() {
        //Pre
        listObject.clear();
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        //Act
        listObject.add(a);
        listObject.add(b);
        listObject.set(1, c);

        //Assert
        Assert.assertEquals(c, listObject.get(1));
    }
        @Test
        public void shouldRemove(){

        //Pre
        listObject.clear();
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        //Act
        listObject.add(a);
        listObject.add(b);
        listObject.set(1, c);
        listObject.remove(c);
        listObject.remove(0);

        Assert.assertEquals(0, list.size());
        }


}
