package org.designPatterns.vehicle_service.factory;

import org.designPatterns.vehicle_service.constants.VehicleType;
import org.designPatterns.vehicle_service.services.BikeService;
import org.designPatterns.vehicle_service.services.CarService;
import org.designPatterns.vehicle_service.services.TruckService;
import org.designPatterns.vehicle_service.services.VehicleService;

public class VehicleServiceFactory {
    public static VehicleService getVehicleService(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE:
                return new BikeService();
            case CAR:
                return new CarService();
            case TRUCK:
                return new TruckService();
            default:
                throw new IllegalArgumentException("Invalid Vehicle Type");
        }
    }
}
