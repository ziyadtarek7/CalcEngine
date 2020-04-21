package com.Ziyad.MyApp;

import com.Ziyad.CalcEngine.maths.*;
import com.Ziyad.CalcEngine.trig.*;
import com.Ziyad.CalcEngine.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean trig;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want trig functions? (Y) / (N) / (Q) to exit:");
            String statement = input.nextLine();
            if (statement.equalsIgnoreCase("y"))
                trig = true;
            else if (statement.equalsIgnoreCase("q")) break;
            else trig = false;

            System.out.println("Usage:");
            if (!trig) {
                System.out.println("available functions: add - subtract - multiply - divide - power - root");
                System.out.println("input example: multiply 63.0 85.0");
                DynamicHelper helper = new DynamicHelper(new MathProcessing[]{
                        new Adder(),
                        new Subtracter(),
                        new Multiplier(),
                        new Divider(),
                        new PowerOf(),
                        new Root(),
                });
                statement = input.nextLine();
                while (!statement.equalsIgnoreCase("q") && !statement.equalsIgnoreCase("b")) {
                    try {
                        String output = helper.process(statement);
                        System.out.println(output);
                        System.out.println("type q to exit, b to go back or enter another statement:");
                        statement = input.nextLine();
                    } catch (InvalidStatementException e) {
                        System.out.println(e.getMessage());
                        if (e.getCause() != null)
                            System.out.println("    Original exception: " + e.getCause().getMessage());
                        System.out.println("type q to exit or enter another statement:");
                        statement = input.nextLine();
                    }
                }
            } else {
                System.out.println("available functions: Sin - Cos - Tan - arcSin - arcCos - arcTan");
                System.out.println("input example: sin 45.0");
                TrigHelper helper = new TrigHelper(new TrigProcessing[]{
                        new Sin(),
                        new Cos(),
                        new Tan(),
                        new arcSin(),
                        new arcCos(),
                        new arcTan(),
                });

                statement = input.nextLine();
                while (!statement.equalsIgnoreCase("q") && !statement.equalsIgnoreCase("b")) {
                    try {
                        String output = helper.process(statement);
                        System.out.println(output);
                        System.out.println("type q to exit, b to go back or enter another statement:");
                        statement = input.nextLine();
                    } catch (InvalidStatementException e) {
                        System.out.println(e.getMessage());
                        if (e.getCause() != null)
                            System.out.println("    Original exception: " + e.getCause().getMessage());
                        System.out.println("type q to exit or enter another statement:");
                        statement = input.nextLine();
                    }
                }
            }
            if (statement.equalsIgnoreCase("q")) break;
        }
    }
}
