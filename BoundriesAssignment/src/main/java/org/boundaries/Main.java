package org.boundaries;

import org.boundaries.dto.Coordinates;
import org.boundaries.service.GeocodingService;

import java.util.Scanner;

import static org.boundaries.constants.Messages.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GeocodingService geocodingService = new GeocodingService();

        System.out.print(ENTER_PLACE_NAME);
        String place = scanner.nextLine();

        Coordinates coordinates = geocodingService.getCoordinates(place);

        System.out.printf(LATITUDE, coordinates.getLat());
        System.out.printf(LONGITUDE, coordinates.getLon());

        scanner.close();
    }
}
