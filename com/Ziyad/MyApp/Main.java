package com.Ziyad.MyApp;

import com.Ziyad.CalcEngine.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Usage:");
        System.out.println("available functions: add - subtract - multiply - divide - power - root");
        System.out.println("input example: multiply 63.0 85.0");
        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new Subtracter(),
                new Multiplier(),
                new Divider(),
                new PowerOf(),
                new Root(),
        });
        String statement = input.nextLine();
        while(!statement.equalsIgnoreCase("q")){
            try {
                String output = helper.process(statement);
                System.out.println(output);
                System.out.println("type q to exit or enter another statement:");
                statement = input.nextLine();
            }
            catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println("    Original exception: " + e.getCause().getMessage());
                break;
            }
        }
    }
}
