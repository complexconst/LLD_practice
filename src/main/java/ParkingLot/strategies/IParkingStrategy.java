package ParkingLot.strategies;

import ParkingLot.entities.vehicleType;

public interface IParkingStrategy {
    Integer ParkVehicle(Integer floorNum, vehicleType type, String regNo, String color);
    void UnParkVehicle(Integer ticketId);
}
