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
        public void shouldDoSth(){

            BinarySearchST binarySearchST = cos();

            binarySearchST.put(1, "Jeden");
            binarySearchST.put(2, "Dwa");
            binarySearchST.put(3, "Trzy");
            binarySearchST.put(4, "Cztery");

            Assert.assertEquals(4, binarySearchST.size());
            Assert.assertEquals(false, binarySearchST.isEmpty());
            Assert.assertEquals(true, binarySearchST.containsKey(2));
            Assert.assertEquals("Trzy", binarySearchST.get(3));

            binarySearchST.remove(4);

            Assert.assertEquals(3, binarySearchST.size());
            Assert.assertEquals(false, binarySearchST.containsKey(4));



        }


    }



