package com.Ziyad.CalcEngine.trig;

import com.Ziyad.CalcEngine.InvalidStatementException;

public class Sin implements TrigProcessing {
    @Override
    public String getKeyword() {
        return "sin";
    }

    @Override
    public double doCalculation(double value) throws InvalidStatementException {
        return Math.round(Math.sin(Math.toRadians(value))* 100) /100.0;
    }
}
