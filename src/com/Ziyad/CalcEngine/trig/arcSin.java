package com.Ziyad.CalcEngine.trig;

import com.Ziyad.CalcEngine.InvalidStatementException;

public class arcSin implements TrigProcessing {
    @Override
    public String getKeyword() {
        return "arcSin";
    }

    @Override
    public double doCalculation(double value) throws InvalidStatementException {
        if (value > 1 || value < -1)
            throw new InvalidStatementException("Invalid value, enter a number between -1 and 1");
        return Math.round(Math.toDegrees(Math.asin(value)) * 100) / 100.0;
    }
}
