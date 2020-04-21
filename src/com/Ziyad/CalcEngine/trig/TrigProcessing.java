package com.Ziyad.CalcEngine.trig;

import com.Ziyad.CalcEngine.InvalidStatementException;

public interface TrigProcessing {
    String SEPARATOR = " ";
    String getKeyword();
    double doCalculation(double value) throws InvalidStatementException;
}
