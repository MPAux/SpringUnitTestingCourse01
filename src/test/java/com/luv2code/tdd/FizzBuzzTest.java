package com.luv2code.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    // If number is divisible by 3, print Fizz

    @DisplayName("Divisible by 3")
    @Test
    @Order(1)
    void testForDivisibleBy3() {
       String expected = "Fizz";
       assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    // If number is divisible by 5, print Buzz

    @DisplayName("Divisible by 5")
    @Test
    @Order(2)
    void testForDivisibleBy5() {
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    // If number is divisible by 3 and 5, print FizzBuzz
    @DisplayName("Divisible by 3 and 5")
    @Test
    @Order(3)
    void testForDivisibleBy3And5() {
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    // If number is NOT divisible by 3 or 5, then print the number
    @DisplayName("Not Divisible by 3 or 5")
    @Test
    @Order(4)
    void testForNotDivisibleBy3And5() {
        String expected = "1";
        assertEquals(expected, FizzBuzz.compute(1), "Should return 1");
    }

    // Testing with data files
    @DisplayName("Testing with small data file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(5)
    void testSmallDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Should return " + expected);
    }

    @DisplayName("Testing with medium data file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(6)
    void testMediumDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Should return " + expected);
    }

    @DisplayName("Testing with large data file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(6)
    void testLargeDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Should return " + expected);
    }
}
