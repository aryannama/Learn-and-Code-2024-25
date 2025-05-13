package org.tests;

public class DivisorCalculator {

    public static int countDivisorsPair(int maxNumber) {
        if (maxNumber <= 0) throw new IllegalArgumentException("number must be positive");
        int result = 0;
        for (int n = 2; n < maxNumber; n++) {
            if (countDivisors(n) == countDivisors(n + 1)) {
                result++;
            }
        }
        return result;
    }

    private static int countDivisors(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                count += (number / i == i) ? 1 : 2;
            }
        }
        return count;
    }
}
