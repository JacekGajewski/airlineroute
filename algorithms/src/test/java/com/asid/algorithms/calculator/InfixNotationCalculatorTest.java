package com.asid.algorithms.calculator;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test for InfixNotationCalculator
 */
public class InfixNotationCalculatorTest {
    private final static double DELTA = 0.01;

    @Test
    @Ignore /* remove this line and write other tests. */
    public void shouldCalculateExpression1() {
        //Pre
        InfixNotationCalculator calc = new InfixNotationCalculatorImpl();

        //Act
        double result = calc.calculate("((2+7)/3+(14-3)*4)/2");

        //Assert
        Assert.assertEquals(23.5, result, DELTA);
    }
}