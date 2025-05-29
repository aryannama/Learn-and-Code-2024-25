package org.tests.unittests;

import org.testng.annotations.Test;
import org.tests.DivisorCalculator;
import org.tests.dataprovider.DivisorDataProvider;

import static org.testng.Assert.assertEquals;

public class DivisorCalculatorTest {


    @Test(dataProvider = "validDivisorPair", dataProviderClass = DivisorDataProvider.class)
    public void testCountDivisorsPair_ValidPair(int number, int expected) {
        assertEquals(DivisorCalculator.countDivisorsPair(number), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCountDivisorsPair_NegativeInput() {
        DivisorCalculator.countDivisorsPair(-5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCountDivisorsPair_ZeroInput() {
        DivisorCalculator.countDivisorsPair(0);
    }
}