package org.designPatterns.vehicle_service.services;

public class CarService implements VehicleService{

    @Override
    public void performService() {
        System.out.println("Car Service");
    }
}
