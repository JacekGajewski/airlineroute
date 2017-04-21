package com.asid.foundation.datastructure.symbolTable;

import com.asid.foundation.datastructure.list.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by tnt9 on 08.04.17.
 */
public class BinarySearchSTTest {

        public static BinarySearchST cos(){
            ArrayList<Node> list = new ArrayList<>();
            Comparator<Integer> comparator = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1 > o2){
                        return 1;
                    }else if(o1 < o2){
                        return -1;
                    }else return 0;
                }
            };
            BinarySearchST binarySearchST = new BinarySearchST(list, comparator);

            return binarySearchST;
        }

    @Test
    public void shouldCheckSizeAndEmptiness(){

        BinarySearchST binarySearchST = cos();

        Assert.assertEquals(0, binarySearchST.size());
        Assert.assertEquals(true, binarySearchST.isEmpty());
        Assert.assertEquals(false, binarySearchST.containsKey(5));


        binarySearchST.put(1, "Jeden");
        binarySearchST.put(2, "Dwa");
        binarySearchST.put(3, "Trzy");
        binarySearchST.put(4, "Cztery");

        Assert.assertEquals(4, binarySearchST.size());
        Assert.assertEquals(false, binarySearchST.isEmpty());
        Assert.assertEquals(false, binarySearchST.containsKey(5));


        binarySearchST.remove(1);
        binarySearchST.remove(2);
        binarySearchST.remove(3);
        binarySearchST.remove(4);

        Assert.assertEquals(0, binarySearchST.size());
        Assert.assertEquals(true, binarySearchST.isEmpty());
        Assert.assertEquals(false, binarySearchST.containsKey(5));

    }

    @Test
    public void shouldPutAndGet(){

        BinarySearchST binarySearchTreeST = cos();

        binarySearchTreeST.put(1, "Jeden");
        binarySearchTreeST.put(2, "Dwa");
        binarySearchTreeST.put(3, "Trzy");
        binarySearchTreeST.put(4, "Cztery");

        Assert.assertEquals(4, binarySearchTreeST.size());
        Assert.assertEquals(false, binarySearchTreeST.isEmpty());
        Assert.assertEquals(true, binarySearchTreeST.containsKey(1));
        Assert.assertEquals(true, binarySearchTreeST.containsKey(2));
        Assert.assertEquals(true, binarySearchTreeST.containsKey(3));
        Assert.assertEquals(true, binarySearchTreeST.containsKey(4));
        Assert.assertEquals(false, binarySearchTreeST.containsKey(5));
        Assert.assertEquals("Trzy", binarySearchTreeST.get(3));
        Assert.assertEquals(null, binarySearchTreeST.get(5));


        binarySearchTreeST.remove(4);

        Assert.assertEquals(3, binarySearchTreeST.size());
        Assert.assertEquals(false, binarySearchTreeST.containsKey(4));
    }


    }



