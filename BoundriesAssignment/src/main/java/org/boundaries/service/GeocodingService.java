package org.boundaries.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.boundaries.config.Configuration;
import org.boundaries.dto.Coordinates;
import org.boundaries.exception.PlaceNotFoundException;
import org.boundaries.utils.APIClient;
import org.boundaries.utils.JsonParser;

import java.net.http.HttpResponse;
import java.util.List;

public class GeocodingService {

    public Coordinates getCoordinates(String place) {
        String url = String.format(Configuration.getProperty("geocoding.api.url"), place.replace(" ", "+"));

        HttpResponse<String> response = APIClient.get(url);

        List<Coordinates> coordinates = JsonParser.parse(response.body(), new TypeReference<>() {});

        if (coordinates.isEmpty()) {
            throw new PlaceNotFoundException(place);
        }

        return coordinates.get(0);
    }
}
