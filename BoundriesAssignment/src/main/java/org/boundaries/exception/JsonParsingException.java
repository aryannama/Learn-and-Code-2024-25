package org.boundaries.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JsonParsingException extends RuntimeException {
    private static final Logger LOGGER = LogManager.getLogger(JsonParsingException.class);

    public JsonParsingException(String message) {
        super(message);
        LOGGER.error(message);
    }
}
