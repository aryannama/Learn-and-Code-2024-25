package com.atm.atm_simulator.util;

import java.util.Random;

public class CardUtil {

    public static String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));
        }

        return cardNumber.toString();
    }

    public static int generatePin() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }
}
