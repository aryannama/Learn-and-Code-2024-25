package com.atm.atm_simulator.exceptions;

import static com.atm.atm_simulator.constants.ExceptionMessages.SERVER_UNAVAILABLE;

public class ServerUnavailableException extends RuntimeException {
    public ServerUnavailableException() {
        super(SERVER_UNAVAILABLE);
    }
}
