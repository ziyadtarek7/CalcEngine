package com.Ziyad.CalcEngine.maths;

import com.Ziyad.CalcEngine.InvalidStatementException;

public class Root implements MathProcessing {
    @Override
    public String getKeyword() {
        return "root";
    }

    @Override
    public char getSymbol() {
        return '√';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) throws InvalidStatementException {
        if (rightVal < 0)
            throw new InvalidStatementException("Root of negative value is not real");
        return Math.pow(rightVal, 1/leftVal);
    }
}
