package com.atm.atm_simulator.service;

import java.time.LocalTime;

import static com.atm.atm_simulator.constants.Server.SERVER_DOWN_FROM;
import static com.atm.atm_simulator.constants.Server.SERVER_DOWN_TILL;

public class Server {
    public static boolean isServerAvailable() {
        LocalTime currentTime = LocalTime.now();
        return currentTime.isBefore(SERVER_DOWN_FROM) || currentTime.isAfter(SERVER_DOWN_TILL);
    }
}
