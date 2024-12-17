package com.adjacentcountires;

import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class AdjacentCountry {

    public static String getCountryName(JsonObject countriesByCodeData, String countryCode) {
        if (countriesByCodeData.has(countryCode)) {
            return countriesByCodeData.get(countryCode).getAsString();
        } else {
            System.out.println("Invalid Country Code!");
            return null;
        }
    }

    public static JsonArray getAdjacentCountries(JsonObject adjacentCountriesData, String countryName) {
        return adjacentCountriesData.getAsJsonArray(countryName);
    }

    public static void displayAdjacentCountries(JsonArray adjacentCountries, String countryName) {
        if (adjacentCountries == null || adjacentCountries.size() == 0) {
            System.out.println("No adjacent countries for " + countryName);
        } else {
            System.out.println("Adjacent countries for " + countryName + ":");
            for (JsonElement country : adjacentCountries) {
                System.out.println(country.getAsString());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a country code: ");
        String countryCode = scanner.nextLine().toUpperCase();

        JsonObject countriesByCodeData = JsonFileReader.readJsonFile("countryCodes.json");
        JsonObject adjacentCountriesData = JsonFileReader.readJsonFile("adjacentCountries.json");

        String countryName = getCountryName(countriesByCodeData, countryCode);
        if (countryName != null) {
            JsonArray adjacentCountries = getAdjacentCountries(adjacentCountriesData, countryName);
            displayAdjacentCountries(adjacentCountries, countryName);
        }
    }
}