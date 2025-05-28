package org.boundaries.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.boundaries.exception.JsonParsingException;

import static org.boundaries.constants.ExceptionMessages.INVALID_JSON_FORMAT;

public class JsonParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T parse(String json, TypeReference<T> classType) {
        try {
            return objectMapper.readValue(json, classType);
        } catch (JsonProcessingException e) {
            throw new JsonParsingException(String.format(INVALID_JSON_FORMAT, e.getMessage()));
        }
    }

}
