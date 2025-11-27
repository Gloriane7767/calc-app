package com.gloriane;

public class Calculator {
    
    public static double add(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be null or empty");
        }
        
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }
    
    public static double subtract(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be null or empty");
        }
        
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }
    
    public static double multiply(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be null or empty");
        }
        
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result *= numbers[i];
        }
        return result;
    }
    
    public static double divide(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be null or empty");
        }
        
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new IllegalArgumentException("Division by zero is not allowed");
            }
            result /= numbers[i];
        }
        return result;
    }
    
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    public static double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }
    
    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (number > 20) {
            throw new IllegalArgumentException("Factorial overflow for numbers greater than 20");
        }
        
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
    
    public static double log(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Logarithm is not defined for non-positive numbers");
        }
        return Math.log(number);
    }
}