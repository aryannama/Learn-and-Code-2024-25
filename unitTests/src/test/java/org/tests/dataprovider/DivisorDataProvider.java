package org.tests.dataprovider;

import org.testng.annotations.DataProvider;

public class DivisorDataProvider {

    @DataProvider(name = "validDivisorPair")
    public Object[][] validDivisorPair(){
        return new Object[][]{
                {3,1},
                {15,2},
                {100,15}
        };
    }

}
