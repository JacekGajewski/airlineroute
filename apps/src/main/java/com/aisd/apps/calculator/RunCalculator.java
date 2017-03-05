package com.aisd.apps.calculator;

import com.asid.algorithms.calculator.InfixNotationCalculator;
import com.asid.algorithms.calculator.InfixNotationCalculatorImpl;

import javax.swing.*;

/**
 * Start-up file.
 * Class starts calculator.
 * Do not modify this class if it is not necessary.
 */
public class RunCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Infix notation calculator");

        // prompt the user to enter their name
        String expression = JOptionPane.showInputDialog(frame, "Enter expression");
        if (expression != null) {
            try {
                InfixNotationCalculator calculator = new InfixNotationCalculatorImpl();
                double result = calculator.calculate(expression);

                JOptionPane.showMessageDialog(new JFrame(),
                        String.format("Result = %s", Double.toString(result)),
                        "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new JFrame(),
                        "An error occurred: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        System.exit(0);
    }
}

