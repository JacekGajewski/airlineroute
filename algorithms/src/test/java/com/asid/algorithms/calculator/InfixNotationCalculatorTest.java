package com.asid.algorithms.calculator;

import com.asid.algorithms.database.DataLoader;
import com.asid.algorithms.database.DataLoaderImpl;
import com.asid.algorithms.database.InmemmoryDataBase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test for InfixNotationCalculator
 */
public class InfixNotationCalculatorTest {
    private final static double DELTA = 0.01;

    @Test
   // @Ignore /* remove this line and write other tests. */
    public void shouldCalculateExpression1() {
        //Pre
        InfixNotationCalculator calc = new InfixNotationCalculatorImpl();

        //Act
        double result = calc.calculate("((2+7)/3+(14-3)*4)/2"); // 27+3/143-4*+2/

        //Assert
        Assert.assertEquals(23.5, result, DELTA);
    }
    @Test
    @Ignore
    public void shouldReadAllData(){
        DataLoader loader = new DataLoaderImpl();

        loader.loadAllData("/home/tnt9/Downloads/airlineroute/algorithms/resources/airports.dat",
                "/home/tnt9/Downloads/airlineroute/algorithms/resources/airlines.dat",
                "/home/tnt9/Downloads/airlineroute/algorithms/resources/routes.dat");

        Assert.assertTrue(InmemmoryDataBase.getInstance().getRoutes().size() > 1);
    }
}