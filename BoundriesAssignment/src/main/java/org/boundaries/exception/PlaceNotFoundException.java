package org.boundaries.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.boundaries.constants.ExceptionMessages.PLACE_NOT_FOUND;

public class PlaceNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LogManager.getLogger(PlaceNotFoundException.class);

    public PlaceNotFoundException(String place) {
        super(String.format(PLACE_NOT_FOUND, place));
        LOGGER.error(String.format(PLACE_NOT_FOUND, place));
    }
}
