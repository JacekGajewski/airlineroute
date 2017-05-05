package com.asid.foundation.datastructure.symbolTable;

import org.junit.Assert;


/**
 * Created by tnt9 on 05.05.17.
 */
public class RedBlackBinarySearchTreeSTTest {

    public static RedBlackBinarySearchTreeST cos(){
        return new RedBlackBinarySearchTreeST();
    }

    @org.junit.Test
    public void shouldCheckSizeAndEmptiness(){

        RedBlackBinarySearchTreeST redBlackBinarySearchTreeST = cos();

        Assert.assertEquals(0, redBlackBinarySearchTreeST.size());
        Assert.assertEquals(true, redBlackBinarySearchTreeST.isEmpty());
        Assert.assertEquals(false, redBlackBinarySearchTreeST.containsKey(5));


        redBlackBinarySearchTreeST.put(1, "Jeden");
        redBlackBinarySearchTreeST.put(2, "Dwa");
        redBlackBinarySearchTreeST.put(3, "Trzy");
        redBlackBinarySearchTreeST.put(4, "Cztery");

        Assert.assertEquals(4, redBlackBinarySearchTreeST.size());
        Assert.assertEquals(false, redBlackBinarySearchTreeST.isEmpty());
        Assert.assertEquals(false, redBlackBinarySearchTreeST.containsKey(5));


        redBlackBinarySearchTreeST.remove(1);
        redBlackBinarySearchTreeST.remove(2);
        redBlackBinarySearchTreeST.remove(3);
        redBlackBinarySearchTreeST.remove(4);

        Assert.assertEquals(0, redBlackBinarySearchTreeST.size());
        Assert.assertEquals(true, redBlackBinarySearchTreeST.isEmpty());
        Assert.assertEquals(false, redBlackBinarySearchTreeST.containsKey(5));

    }
    @org.junit.Test
    public void shouldPutAndGet(){

        RedBlackBinarySearchTreeST redBlackBinarySearchTreeST = cos();

        redBlackBinarySearchTreeST.put(1, "Jeden");
        redBlackBinarySearchTreeST.put(2, "Dwa");
        redBlackBinarySearchTreeST.put(3, "Trzy");
        redBlackBinarySearchTreeST.put(4, "Cztery");

        Assert.assertEquals(4, redBlackBinarySearchTreeST.size());
        Assert.assertEquals(false, redBlackBinarySearchTreeST.isEmpty());
        Assert.assertEquals(true, redBlackBinarySearchTreeST.containsKey(1));
        Assert.assertEquals(true, redBlackBinarySearchTreeST.containsKey(2));
        Assert.assertEquals(true, redBlackBinarySearchTreeST.containsKey(3));
        Assert.assertEquals(true, redBlackBinarySearchTreeST.containsKey(4));
        Assert.assertEquals(false, redBlackBinarySearchTreeST.containsKey(5));
        Assert.assertEquals("Trzy", redBlackBinarySearchTreeST.get(3));
        Assert.assertEquals(null, redBlackBinarySearchTreeST.get(5));


        redBlackBinarySearchTreeST.remove(4);

        Assert.assertEquals(3, redBlackBinarySearchTreeST.size());
        Assert.assertEquals(false, redBlackBinarySearchTreeST.containsKey(4));
    }
}
