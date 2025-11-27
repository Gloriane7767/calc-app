package com.gloriane;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(15.0, Calculator.add(new int[]{5, 10}));
        assertEquals(30.0, Calculator.add(new int[]{10, 5, 15}));
        assertEquals(-5.0, Calculator.add(new int[]{-10, 5}));
        assertEquals(0.0, Calculator.add(new int[]{0, 0}));
    }

    @Test
    void testSubtraction() {
        assertEquals(-5.0, Calculator.subtract(new int[]{5, 10}));
        assertEquals(-10.0, Calculator.subtract(new int[]{10, 5, 15}));
        assertEquals(-15.0, Calculator.subtract(new int[]{-10, 5}));
        assertEquals(0.0, Calculator.subtract(new int[]{0, 0}));
    }

    @Test
    void testMultiplication() {
        assertEquals(50.0, Calculator.multiply(new int[]{5, 10}));
        assertEquals(750.0, Calculator.multiply(new int[]{10, 5, 15}));
        assertEquals(-50.0, Calculator.multiply(new int[]{-10, 5}));
        assertEquals(0.0, Calculator.multiply(new int[]{0, 5}));
    }

    @Test
    void testDivision() {
        assertEquals(0.5, Calculator.divide(new int[]{5, 10}));
        assertEquals(2.0, Calculator.divide(new int[]{10, 5}));
        assertEquals(-2.0, Calculator.divide(new int[]{-10, 5}));
        assertEquals(0.0, Calculator.divide(new int[]{0, 5}));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(new int[]{5, 0}));
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(new int[]{10, 5, 0}));
    }

    @Test
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.add(null));
        assertThrows(IllegalArgumentException.class, () -> Calculator.subtract(null));
        assertThrows(IllegalArgumentException.class, () -> Calculator.multiply(null));
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(null));
    }

    @Test
    void testEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.add(new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> Calculator.subtract(new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> Calculator.multiply(new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(new int[]{}));
    }

    @Test
    void testPower() {
        assertEquals(8.0, Calculator.power(2, 3));
        assertEquals(1.0, Calculator.power(5, 0));
        assertEquals(0.25, Calculator.power(2, -2));
    }

    @Test
    void testSqrt() {
        assertEquals(3.0, Calculator.sqrt(9));
        assertEquals(5.0, Calculator.sqrt(25));
        assertEquals(0.0, Calculator.sqrt(0));
        assertThrows(IllegalArgumentException.class, () -> Calculator.sqrt(-1));
    }

    @Test
    void testFactorial() {
        assertEquals(1, Calculator.factorial(0));
        assertEquals(1, Calculator.factorial(1));
        assertEquals(120, Calculator.factorial(5));
        assertThrows(IllegalArgumentException.class, () -> Calculator.factorial(-1));
        assertThrows(IllegalArgumentException.class, () -> Calculator.factorial(21));
    }

    @Test
    void testLog() {
        assertEquals(0.0, Calculator.log(1), 0.0001);
        assertEquals(Math.log(10), Calculator.log(10), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> Calculator.log(0));
        assertThrows(IllegalArgumentException.class, () -> Calculator.log(-1));
    }
}