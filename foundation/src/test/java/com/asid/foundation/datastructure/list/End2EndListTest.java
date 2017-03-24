package com.asid.foundation.datastructure.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * End2End List implementation test
 */
public class End2EndListTest {
    private List<Integer> createEmptyList() {
        return new CustomLinkedList<>();
    }

    @Test
    public void shouldReturnSizeZeroIfListIsEmpty() {
        // Pre
        List<Integer> emptyList = createEmptyList();

        //Assert
        assertEquals(0, emptyList.size());
    }

    @Test
    public void shouldReturnEmptyIfListIsEmpty() {
        // Pre
        List<Integer> emptyList = createEmptyList();

        //Assert
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void shouldReturnSizeIfListIsNotEmpty() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(2));
        //Assert
        assertEquals(4, list.size());
    }

    @Test
    public void shouldReturnNotEmptyIfListIsNotEmpty() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(2));

        //Assert
        assertFalse(list.isEmpty());
    }

    @Test
    public void shouldAddElements() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(2));

        //Assert
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(2, (int) list.get(3));
    }

    @Test
    public void shouldAddElementsWithNullValue() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(null);
        list.add(new Integer(2));

        //Assert
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(null, list.get(2));
        assertEquals(2, (int) list.get(3));
    }

    @Test
    public void shouldCheckIfAddMethodReturnsTrue() {
        // Pre
        List<Integer> list = createEmptyList();
        boolean addStatus = list.add(new Integer(1));

        //Assert
        assertTrue(addStatus);
    }

    @Test
    public void shouldCheckIfListContainsElement() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(2));

        boolean result1 = list.contains(new Integer(3));
        boolean result2 = list.contains(new Integer(2));

        //Assert
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    public void shouldCheckIfLiistNotContainsElement() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(2));

        boolean result1 = list.contains(new Integer(-1));
        boolean result2 = list.contains(new Integer(4));

        //Assert
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    public void shouldCheckIteratorFunctions_1() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(2));

        //Act
        Iterator<Integer> iterator = list.iterator();

        //Assert
        assertNotNull(iterator);
        assertEquals(1, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, (int) iterator.next());
        assertEquals(3, (int) iterator.next());
        assertEquals(2, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldCheckIteratorFunctions_2() {
        // Pre
        List<Integer> list = createEmptyList();

        //Act
        Iterator<Integer> iterator = list.iterator();

        //Assert
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldRemoveElementsFromList() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(null);
        list.add(new Integer(2));
        list.add(new Integer(4));

        //Act
        boolean removeResult = list.remove(new Integer(2));

        //Assert
        assertEquals(4, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(null, list.get(1));
        assertEquals(2, (int) list.get(2));
        assertEquals(4, (int) list.get(3));


        assertTrue(removeResult);
    }

    @Test
    public void shouldRemoveElementOnCurrentPosition() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));

        //Act
        Integer removeResult = list.remove(1);

        //Assert
        assertEquals(3, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(4, (int) list.get(2));

        assertEquals(2, (int) removeResult);
    }

    @Test
    public void shouldNotRemoveElementIfNotExists() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));

        //Act
        boolean removeResult = list.remove(new Integer(10));

        //Assert
        assertFalse(removeResult);
        assertEquals(4, list.size());
    }

    @Test
    public void shouldNotRemoveElementIfPositionIsOutOfBound() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));

        //Act
        try {
            list.remove(10);
            fail("An IndexOutOfBoundsException should appear");
        } catch (IndexOutOfBoundsException e) {
        } catch (Exception e) {
            fail("An IndexOutOfBoundsException should appear");
        }
    }

    @Test
    public void shouldCheckIfRemoveReturnTrueIfElementExists() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));

        //Act
        boolean removeResult1 = list.remove(new Integer(2));
        boolean removeResult2 = list.remove(new Integer(4));

        //Assert
        assertTrue(removeResult1);
        assertTrue(removeResult2);
    }

    @Test
    public void shouldCheckIfRemoveReturnFalseIfElementNotExists() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));

        //Act
        boolean removeResult1 = list.remove(new Integer(20));


        //Assert
        assertFalse(removeResult1);
    }


    @Test
    public void shouldSetElementsOnPosition() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(null);
        list.add(new Integer(2));
        list.add(new Integer(4));

        //Act
        list.set(2, new Integer(20));
        list.set(3, new Integer(40));

        //Assert
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(20, (int) list.get(2));
        assertEquals(40, (int) list.get(3));
        assertEquals(4, (int) list.get(4));
    }

    @Test
    public void shouldNotSetElementsOnPosition() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(null);
        list.add(new Integer(2));
        list.add(new Integer(4));

        //Act
        try {
            list.set(6, new Integer(20));
            fail("An IndexOutOfBoundsException should appear");
        } catch (IndexOutOfBoundsException e) {
        } catch (Exception e) {
            fail("An IndexOutOfBoundsException should appear");
        }
    }


    @Test
    public void shouldIncreaseListSize() {
        // Pre
        List<Integer> list = createEmptyList();


        //Act
        for (int i=0;i<100000;i++){
            list.add(new Integer(i));
        }

        //Assert
        assertEquals(100000,list.size());
    }

    @Test
    public void shouldReduceListSize() {
        // Pre
        List<Integer> list = createEmptyList();


        //Act
        for (int i=0;i<1000;i++){
            list.add(new Integer(i));
        }

        for (int i=0;i<1000-10;i++){
            list.remove(new Integer(i));
        }

        //Assert
        assertEquals(10,list.size());
    }
}