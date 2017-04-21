package com.asid.foundation.datastructure.symbolTable;

import com.asid.foundation.datastructure.list.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tnt9 on 08.04.17.
 */
public class SequentialSearchSTTest {

    public static SequentialSearchST cos(){
        LinkedList<Node> list = new LinkedList<>();
        SequentialSearchST sequentialSearchST = new SequentialSearchST(list);

        return sequentialSearchST;
    }

    @Test
    public void shouldCheckSizeAndEmptiness(){

        SequentialSearchST sequentialSearchST = cos();

        Assert.assertEquals(0, sequentialSearchST.size());
        Assert.assertEquals(true, sequentialSearchST.isEmpty());
        Assert.assertEquals(false, sequentialSearchST.containsKey(5));


        sequentialSearchST.put(1, "Jeden");
        sequentialSearchST.put(2, "Dwa");
        sequentialSearchST.put(3, "Trzy");
        sequentialSearchST.put(4, "Cztery");

        Assert.assertEquals(4, sequentialSearchST.size());
        Assert.assertEquals(false, sequentialSearchST.isEmpty());
        Assert.assertEquals(false, sequentialSearchST.containsKey(5));


        sequentialSearchST.remove(1);
        sequentialSearchST.remove(2);
        sequentialSearchST.remove(3);
        sequentialSearchST.remove(4);

        Assert.assertEquals(0, sequentialSearchST.size());
        Assert.assertEquals(true, sequentialSearchST.isEmpty());
        Assert.assertEquals(false, sequentialSearchST.containsKey(5));

    }

    @Test
    public void shouldPutAndGet(){

        SequentialSearchST sequentialSearchST = cos();

        sequentialSearchST.put(1, "Jeden");
        sequentialSearchST.put(2, "Dwa");
        sequentialSearchST.put(3, "Trzy");
        sequentialSearchST.put(4, "Cztery");

        Assert.assertEquals(4, sequentialSearchST.size());
        Assert.assertEquals(false, sequentialSearchST.isEmpty());
        Assert.assertEquals(true, sequentialSearchST.containsKey(1));
        Assert.assertEquals(true, sequentialSearchST.containsKey(2));
        Assert.assertEquals(true, sequentialSearchST.containsKey(3));
        Assert.assertEquals(true, sequentialSearchST.containsKey(4));
        Assert.assertEquals(false, sequentialSearchST.containsKey(5));
        Assert.assertEquals("Trzy", sequentialSearchST.get(3));
        Assert.assertEquals(null, sequentialSearchST.get(5));


        sequentialSearchST.remove(4);

        Assert.assertEquals(3, sequentialSearchST.size());
        Assert.assertEquals(false, sequentialSearchST.containsKey(4));
    }


}
