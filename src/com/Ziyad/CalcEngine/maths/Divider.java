package com.Ziyad.CalcEngine.maths;

import com.Ziyad.CalcEngine.InvalidStatementException;

public class Divider extends CalculateBase implements MathProcessing {
    public Divider(){}
    public Divider(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() throws InvalidStatementException {
        if (getRightVal() == 0) {
            throw new InvalidStatementException("Error: Dividing by zero");
        }
        double value = getLeftVal() / getRightVal();
        setResult(value);
    }

    @Override
    public String getKeyword() {
        return "divide";
    }

    @Override
    public char getSymbol() {
        return '/';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) throws InvalidStatementException {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
