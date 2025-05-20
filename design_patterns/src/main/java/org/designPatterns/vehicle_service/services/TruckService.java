package org.designPatterns.vehicle_service.services;

public class TruckService implements VehicleService{

    @Override
    public void performService() {
        System.out.println("Truck Service");
    }
}
