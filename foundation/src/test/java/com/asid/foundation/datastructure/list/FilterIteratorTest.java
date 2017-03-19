package com.asid.foundation.datastructure.list;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Ignore;
        import org.junit.Test;

        import java.io.FileNotFoundException;
        import java.io.InterruptedIOException;
        import java.util.IntSummaryStatistics;
        import java.util.List;
        import java.util.NoSuchElementException;
        import java.util.Objects;
        import java.util.function.Predicate;
        import java.util.logging.Filter;

        import static org.junit.Assert.*;
        import static org.junit.Assert.fail;

public class FilterIteratorTest {

    private List<Integer> createEmptyList(){

        return new CustomLinkedList<>();
    }

    @Test
    public void shouldHaveNext(){
        //Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));

        FilterIterator<Integer> it = new FilterIterator<>(list, (x) -> x==1);

        //Assert
        assertTrue(it.hasNext());
    }
    @Test
    public void shouldBeEmpty(){
        //Pre
        List<Integer> list = createEmptyList();

        FilterIterator<Integer> it = new FilterIterator<>(list, (x) -> x==1);

        //Assert
        assertFalse(it.hasNext());
    }
    @Test
    public void shouldBeBigger(){
        //Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(2));

        FilterIterator<Integer> it = new FilterIterator<>(list, (x) -> x>2);

        //Assert
        assertTrue(it.hasNext());
        assertEquals(3, (int)it.next());

    }
    @Test
    public void shouldBeSmaller(){
        //Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(2));

        FilterIterator<Integer> it = new FilterIterator<>(list, (x) -> x<2);

        //Assert
        assertTrue(it.hasNext());
        assertEquals(1, (int)it.next());

    }
    @Test
    public void shouldCatchException() {
        // Pre
        List<Integer> list = createEmptyList();
        list.add(new Integer(1));
        list.add(new Integer(2));

        FilterIterator<Integer> it = new FilterIterator<>(list, (x) -> x>20);

        //Act
        try {
            it.remove();
            fail("An UnsupportedOperationException should appear");
        } catch (UnsupportedOperationException e) {
        } catch (Exception e) {
            fail("An UnsupportedOperationException should appear");
        }
        try {
            it.next();
            fail("NoSuchElementException should appear");
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            fail("NoSuchElementException should appear");
        }
    }
    /*@Test
    public void shouldDoDatabase(){
        //Pre
        DataLoaderImpl loader = new DataLoaderImpl();

        loader.loadAllData("/home/tnt9/Downloads/airlineroute/algorithms/resources/airports.dat",
                "/home/tnt9/Downloads/airlineroute/algorithms/resources/airlines.dat",
                "/home/tnt9/Downloads/airlineroute/algorithms/resources/routes.dat");

    }*/


}
