package com.asid.foundation.datastructure.symbolTable;

import com.asid.foundation.datastructure.list.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by tnt9 on 21.04.17.
 */
public class BinarySearchTreeSTTest {

        public static BinarySearchTreeST cos(){
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
            BinarySearchTreeST binarySearchTreeST = new BinarySearchTreeST(comparator);

            return binarySearchTreeST;
        }
    @Test
    public void shouldCheckSizeAndEmptiness(){

        BinarySearchTreeST binarySearchTreeST = cos();

        Assert.assertEquals(0, binarySearchTreeST.size());
        Assert.assertEquals(true, binarySearchTreeST.isEmpty());
        Assert.assertEquals(false, binarySearchTreeST.containsKey(5));


        binarySearchTreeST.put(1, "Jeden");
        binarySearchTreeST.put(2, "Dwa");
        binarySearchTreeST.put(3, "Trzy");
        binarySearchTreeST.put(4, "Cztery");

        Assert.assertEquals(4, binarySearchTreeST.size());
        Assert.assertEquals(false, binarySearchTreeST.isEmpty());
        Assert.assertEquals(false, binarySearchTreeST.containsKey(5));


        binarySearchTreeST.remove(1);
        binarySearchTreeST.remove(2);
        binarySearchTreeST.remove(3);
        binarySearchTreeST.remove(4);

        Assert.assertEquals(0, binarySearchTreeST.size());
        Assert.assertEquals(true, binarySearchTreeST.isEmpty());
        Assert.assertEquals(false, binarySearchTreeST.containsKey(5));

    }

        @Test
        public void shouldPutAndGet(){

            BinarySearchTreeST binarySearchTreeST = cos();

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