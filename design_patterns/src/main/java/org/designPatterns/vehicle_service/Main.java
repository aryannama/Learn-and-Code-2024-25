package org.designPatterns.vehicle_service;

import org.designPatterns.vehicle_service.constants.VehicleType;
import org.designPatterns.vehicle_service.factory.VehicleServiceFactory;
import org.designPatterns.vehicle_service.services.VehicleService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the vehicle type:");
        VehicleType vehicleType = VehicleType.valueOf(scanner.nextLine().trim().toUpperCase());

        VehicleService vehicleService = VehicleServiceFactory.getVehicleService(vehicleType);
        vehicleService.performService();

        scanner.close();
    }
}
