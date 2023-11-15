package calculator;

import java.io.Console;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        DecimalFormat format = new DecimalFormat("#.##");

        double firstNumber = 0;
        double secondNumber = 0;
        String operator = "";
        double answer = 0;
        
        Console cons = System.console();

        System.out.println("Welcome.");

        while (true) {
            String line = cons.readLine("> ");
            line = line.trim().toLowerCase();
            String[] terms = line.split(" ");
            
            if (line.equals("exit")) {
                System.out.println("Bye bye");
                break;
            }

            if (terms[0].equals("$last") && terms[2].equals("$last")) {
                firstNumber = answer;
                secondNumber = answer;
            } else if (terms[2].equals("$last")) {
                firstNumber = Double.parseDouble(terms[0]);
                secondNumber = answer;
            } else if (terms[0].equals("$last")) {
                firstNumber = answer;
                secondNumber = Double.parseDouble(terms[2]);
            } else {
                firstNumber = Double.parseDouble(terms[0]);
                secondNumber = Double.parseDouble(terms[2]);
            }

            operator = terms[1];

            switch (operator) {
                case "+":
                    answer = firstNumber + secondNumber;
                    break;
                case "-":
                    answer = firstNumber - secondNumber;
                    break;
                case "*":
                    answer = firstNumber * secondNumber;
                    break;
                case "/":
                    answer = firstNumber / secondNumber;
                    break;
                default:
                    System.out.println("Invalid Operator. Available Operator: +, -, *, /");
            }
            System.out.println(format.format(answer));
        }
    }
}