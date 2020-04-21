package com.Ziyad.CalcEngine;

public class PowerOf implements MathProcessing {
    @Override
    public String getKeyword() {
        return "power";
    }

    @Override
    public char getSymbol() {
        return '^';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) throws InvalidStatementException {
        if (leftVal == 0 && rightVal == 0)
            throw new InvalidStatementException("0^0 is unspecified value");
        return Math.pow(leftVal, rightVal);
    }
}
