package com.Ziyad.CalcEngine;

public class DynamicHelper {
    private MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers){
        this.handlers = handlers;
    }

    public String process(String statement) throws InvalidStatementException {
        String[] parts = statement.split(MathProcessing.SEPARATOR);

        if (parts.length != 3)
                throw new InvalidStatementException("Incorrect number of fields", statement);
        String keyword = parts[0];

        MathProcessing theHandler = null;
        for (MathProcessing handler : handlers) {
            if (keyword.equalsIgnoreCase(handler.getKeyword())) {
                theHandler = handler;
                break;
            }
        }
        if (theHandler == null)
            throw new InvalidStatementException("Invalid command", statement);

        double rightVal;
        double leftVal;
        try {
            leftVal = Double.parseDouble(parts[1]);
            rightVal = Double.parseDouble(parts[2]);
        }
        catch (NumberFormatException e) {
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }
        double result = theHandler.doCalculation(leftVal, rightVal);
        StringBuilder sb = new StringBuilder();
        sb.append(leftVal);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }
}
