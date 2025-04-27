package week1;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Simple Calculator!");
        System.out.print("Enter a number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter an operator (+, -, *, /): ");
        String operator = input.next();
        System.out.print("Enter another number: ");
        double num2 = input.nextDouble();
        input.close();
        
        double result;
        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        } else if (operator.equals("/")) {
            result = num1 / num2;
        } else {
            System.out.println("Error: Invalid operator!");
            return;
        }
        
        System.out.println("Result: " + result);
    }
}
