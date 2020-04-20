package com.Ziyad.MyApp;

import com.Ziyad.CalcEngine.*;

public class Main {

    public static void main(String[] args) {
        String[] statements = {
                "add 25.0 92.0",
                "power 0.0 0.0",
                "divide 100.0 0.0",
                "root 2.0 25.0"
        };
        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new Subtracter(),
                new Multiplier(),
                new Divider(),
                new PowerOf(),
                new Root(),
        });
        for (String statement: statements) {
            try {
                String output = helper.process(statement);
                System.out.println(output);
            }
            catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println("    Original exception: " + e.getCause().getMessage());
            }
        }
    }
}
