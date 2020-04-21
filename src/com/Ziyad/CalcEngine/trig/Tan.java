package com.Ziyad.CalcEngine.trig;

import com.Ziyad.CalcEngine.InvalidStatementException;

public class Tan implements TrigProcessing {
    @Override
    public String getKeyword() {
        return "tan";
    }

    @Override
    public double doCalculation(double value) throws InvalidStatementException {
        if (value%90 == 0 && value%180 != 0)
            throw new InvalidStatementException("Tan(" + value + ") is undefined");
        return Math.round(Math.tan(Math.toRadians(value))* 100) /100.0;
    }
}
