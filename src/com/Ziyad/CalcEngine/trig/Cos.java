package com.Ziyad.CalcEngine.trig;

import com.Ziyad.CalcEngine.InvalidStatementException;

public class Cos implements TrigProcessing {
    @Override
    public String getKeyword() {
        return "cos";
    }

    @Override
    public double doCalculation(double value) throws InvalidStatementException {
        return Math.round(Math.cos(Math.toRadians(value))* 100) /100.0;
    }
}
