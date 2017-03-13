package com.asid.foundation.datastructure.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;

public class CustomLinkedListTest {


    private List<Object> emptyO() {
        return new CustomLinkedList<>();
    }
    private List<Integer> emptyI() {
        return new CustomLinkedList<>();
    }




    @Test
    public void shouldAddOneElement() {
        List<Integer> list = emptyI();

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

        List<Integer> list = emptyI();

        Assert.assertEquals(true, list.isEmpty());
    }
    @Test
    public void shouldGetIndex() {
        //Pre
        List<Integer> list = emptyI();

        //Act
        list.add(new Integer(1));
        list.add(new Integer(2));

        //Assert
        Assert.assertEquals(-1, list.indexOf(new Integer(3)));
    }
        @Test
        public void shouldContain(){
            //Pre
            List<Object> listObject = emptyO();
//            Object a = new CustomLinkedList<>();

            //Act
//            listObject.add(a);

            //Assert
//            Assert.assertEquals(true, listObject.contains(a));
        }
    @Test
    public void shouldSet() {
        //Pre
        List<Object> listObject = emptyO();
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
        List<Object> listObject = emptyO();
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        //Act
        listObject.add(a);
        listObject.add(b);
        listObject.set(1, c);
        listObject.remove(c);


        Assert.assertEquals(1, listObject.size());
    }



}