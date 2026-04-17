package question2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorFunctionsTest {

    CalculatorFunctions calc = new CalculatorFunctions();

    @Nested
    @DisplayName("Factorial Function Tests")
    class FactorialTests {

        @Test
        @DisplayName("Factorial of positive number (5 is 120)")
        void testFactorialPositive() {
            assertEquals(120, calc.factorialNumber(5));
        }

        @Test
        @DisplayName("Factorial of zero  is  return 1")
        void testFactorialZero() {
            assertEquals(1, calc.factorialNumber(0));
        }

        @Test
        @DisplayName("Factorial of negative number should throw exception")
        void testFactorialNegative() {
            assertThrows(IllegalArgumentException.class, () -> calc.factorialNumber(-3));
        }
    }

    @Nested
    @DisplayName("Average Function Tests")
    class AverageTests {

        @Test
        @DisplayName("Correct average of two positive numbers")
        void testAveragePositive() {
            assertEquals(5, calc.averageOfTwoNumber(4, 6));
        }

        @Test
        @DisplayName("Average of negative numbers should work correctly")
        void testAverageNegative() {
            assertEquals(-5, calc.averageOfTwoNumber(-6, -4));
        }

        @Test
        @DisplayName("Average when both numbers are the same")
        void testAverageSameValue() {
            assertEquals(7, calc.averageOfTwoNumber(7, 7));
        }
    }

    @Nested
    @DisplayName("Division Function Tests")
    class DivisionTests {

        @Test
        @DisplayName("Correct division of two numbers")
        void testDivisionCorrect() {
            assertEquals(5, calc.divideNumber(10, 2));
        }

        @Test
        @DisplayName("Division with negative numbers")
        void testDivisionNegative() {
            assertEquals(-4, calc.divideNumber(-8, 2));
        }

//        @Test
//        @DisplayName("Division by zero should throw ArithmeticException")
//        void testDivisionByZero() {
//            assertThrows(ArithmeticException.class, () -> calc.divideNumber(5, 0));
//        }
    }
}
