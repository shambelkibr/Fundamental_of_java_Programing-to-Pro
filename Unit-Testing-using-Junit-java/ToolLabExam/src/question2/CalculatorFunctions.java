package question2;

public class CalculatorFunctions {

    public int factorialNumber(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;  // base case
        }
        return n * factorialNumber(n - 1);  // recursive call
    }

    public int averageOfTwoNumber(int n, int m) {
        // Simple integer average
        return (n + m) / 2;
    }

    public int divideNumber(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;   // Integer division
    }
}

