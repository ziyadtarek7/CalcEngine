package com.Ziyad.CalcEngine.trig;

import com.Ziyad.CalcEngine.InvalidStatementException;

public class TrigHelper {
    private TrigProcessing[] handlers;

    public TrigHelper(TrigProcessing[] handlers){
        this.handlers = handlers;
    }

    public String process(String statement) throws InvalidStatementException {
        String[] parts = statement.split(TrigProcessing.SEPARATOR);

        if (parts.length != 2)
            throw new InvalidStatementException("Incorrect number of fields", statement);
        String keyword = parts[0];

        TrigProcessing theHandler = null;
        for (TrigProcessing handler : handlers) {
            if (keyword.equalsIgnoreCase(handler.getKeyword())) {
                theHandler = handler;
                break;
            }
        }
        if (theHandler == null)
            throw new InvalidStatementException("Invalid command", statement);
        double value;
        try {
            value = Double.parseDouble(parts[1]);
        }
        catch (NumberFormatException e) {
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }
        double result = theHandler.doCalculation(value);
        StringBuilder sb = new StringBuilder();
        sb.append(theHandler.getKeyword());
        sb.append("(").append(value).append(") = ").append(result);
        return sb.toString();
    }
}
