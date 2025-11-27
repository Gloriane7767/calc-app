package com.gloriane;
import java.util.Scanner;

public class DemoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // get input
                System.out.println("===== Welcome to My Calculator App =====");

                System.out.println("How many numbers do you want to calculate with?");
                int count = scanner.nextInt();
                
                if (count <= 0) {
                    throw new IllegalArgumentException("Number count must be positive");
                }

                int[] numbers = new int[count];

                for (int i = 0; i < count; i++) {
                    System.out.println("Enter number " + (i + 1) + ":");
                    numbers[i] = scanner.nextInt();
                }

                System.out.println("Select operation (+, -, *, /, ^, sqrt, !, log):");
                String operation = scanner.next();
                
                if (!operation.matches("[+\\-*/^]|sqrt|!|log")) {
                    throw new IllegalArgumentException("Invalid operation: " + operation);
                }

                double result;

                // switch statement for calculation
                switch (operation) {
                    case "+":
                        result = Calculator.add(numbers);
                        break;
                    case "-":
                        result = Calculator.subtract(numbers);
                        break;
                    case "*":
                        result = Calculator.multiply(numbers);
                        break;
                    case "/":
                        result = Calculator.divide(numbers);
                        break;
                    case "^":
                        if (count != 2) throw new IllegalArgumentException("Power requires exactly 2 numbers");
                        result = Calculator.power(numbers[0], numbers[1]);
                        break;
                    case "sqrt":
                        if (count != 1) throw new IllegalArgumentException("Square root requires exactly 1 number");
                        result = Calculator.sqrt(numbers[0]);
                        break;
                    case "!":
                        if (count != 1) throw new IllegalArgumentException("Factorial requires exactly 1 number");
                        result = Calculator.factorial(numbers[0]);
                        break;
                    case "log":
                        if (count != 1) throw new IllegalArgumentException("Logarithm requires exactly 1 number");
                        result = Calculator.log(numbers[0]);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation: " + operation);
                }
                // show result
                if (operation.equals("!")) {
                    System.out.println("The result is: " + (long)result);
                } else {
                    System.out.println("The result is: " + result);
                }

                // ask to continue
                System.out.println("Do you want to perform another calculation? (y/n):");
                char again = scanner.next().charAt(0);
                if (again == 'y' || again == 'Y') {
                    // continue loop
                } else {
                    System.out.println("Thank you for using the calculator!");
                    break;
                }
                
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please try again.");
                scanner.nextLine(); // clear invalid input
            }
        }
        scanner.close();
    }
}