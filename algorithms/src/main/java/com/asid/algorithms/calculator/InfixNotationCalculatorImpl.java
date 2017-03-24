package com.asid.algorithms.calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Infix notation calculator
 */
public class InfixNotationCalculatorImpl implements InfixNotationCalculator {

    @Override
    public double calculate(String expression) {

        return count(toPostfix(expression));
    }

    public List<Object> toPostfix(String string) {
        Stack<Character> operators = new Stack<>();
        List<Object> eqation = new LinkedList<>();

        double num = 0;
        boolean haveNum = false;

        for (char s : string.toCharArray()) {
            if (s >= '0' && s <= '9') {
                num = num * 10 + s - '0';
                haveNum = true;
            } else {
                if(haveNum) {
                    eqation.add(num);
                }
                num = 0;
                haveNum = false;
                if (s == '(') {
                    operators.push('(');
                } else if (s == ')') {
                    while (operators.peek() != '(')
                        eqation.add(operators.pop());
                    operators.pop();
                } else {
                    while (!operators.isEmpty() && sign(s) <= sign(operators.peek()))
                        eqation.add(operators.pop());
                    operators.push(s);
                }
            }

        }
        if (haveNum)
            eqation.add(num);

        while (!operators.isEmpty())
            eqation.add(operators.pop());

        return eqation;
    }

    public int sign(char oper){

        switch(oper){
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default :
                return 0;
        }
    }

    public double count(List<Object> eqation) {

        Stack<Double> stack = new Stack<>();

        double a = 0;
        double b = 0;

        for (Object s : eqation) {
            if(s instanceof Character){
                char c = (Character) s;
                b = stack.pop();
                a = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                    default :
                        stack.push(a * b);
                }
            }else {
                stack.push( (double) s);
            }
        }
        return stack.pop();
    }
}
