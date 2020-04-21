package com.Ziyad.CalcEngine;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculation(double leftVal, double rightVal) throws InvalidStatementException;
}
