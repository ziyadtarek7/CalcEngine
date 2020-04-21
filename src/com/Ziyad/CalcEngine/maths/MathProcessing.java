package com.Ziyad.CalcEngine.maths;

import com.Ziyad.CalcEngine.InvalidStatementException;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculation(double leftVal, double rightVal) throws InvalidStatementException;
}
