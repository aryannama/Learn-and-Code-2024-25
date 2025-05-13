package com.atm.atm_simulator.exceptions;

import static com.atm.atm_simulator.constants.ExceptionMessages.DAILY_LIMIT_EXCEEDED;

public class DailyLimitExceededException extends RuntimeException{
    public DailyLimitExceededException() {
        super(DAILY_LIMIT_EXCEEDED);
    }
}
