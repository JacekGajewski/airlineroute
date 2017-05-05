package com.asid.foundation.datastructure.symbolTable;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by tnt9 on 05.05.17.
 */
public class HashSearchSTTest {

    public static HashSearchST cos(){
        return new HashSearchST();
    }

    @org.junit.Test
    public void shouldCheckSizeAndEmptiness(){

        HashSearchST hashSearchST = cos();

        Assert.assertEquals(0, hashSearchST.size());
        Assert.assertEquals(true, hashSearchST.isEmpty());
        Assert.assertEquals(false, hashSearchST.containsKey(5));


        hashSearchST.put(1, "Jeden");
        hashSearchST.put(2, "Dwa");
        hashSearchST.put(3, "Trzy");
        hashSearchST.put(4, "Cztery");

        Assert.assertEquals(4, hashSearchST.size());
        Assert.assertEquals(false, hashSearchST.isEmpty());
        Assert.assertEquals(false, hashSearchST.containsKey(5));


        hashSearchST.remove(1);
        hashSearchST.remove(2);
        hashSearchST.remove(3);
        hashSearchST.remove(4);

        Assert.assertEquals(0, hashSearchST.size());
        Assert.assertEquals(true, hashSearchST.isEmpty());
        Assert.assertEquals(false, hashSearchST.containsKey(5));

    }
    @Test
    public void shouldPutAndGet(){

        HashSearchST hashSearchST = cos();

        hashSearchST.put(1, "Jeden");
        hashSearchST.put(2, "Dwa");
        hashSearchST.put(3, "Trzy");
        hashSearchST.put(4, "Cztery");

        Assert.assertEquals(4, hashSearchST.size());
        Assert.assertEquals(false, hashSearchST.isEmpty());
        Assert.assertEquals(true, hashSearchST.containsKey(1));
        Assert.assertEquals(true, hashSearchST.containsKey(2));
        Assert.assertEquals(true, hashSearchST.containsKey(3));
        Assert.assertEquals(true, hashSearchST.containsKey(4));
        Assert.assertEquals(false, hashSearchST.containsKey(5));
        Assert.assertEquals("Trzy", hashSearchST.get(3));
        Assert.assertEquals(null, hashSearchST.get(5));


        hashSearchST.remove(4);

        Assert.assertEquals(3, hashSearchST.size());
        Assert.assertEquals(false, hashSearchST.containsKey(4));
    }
}
