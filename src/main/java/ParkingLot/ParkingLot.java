package ParkingLot;

import ParkingLot.entities.vehicleType;
import ParkingLot.strategies.IParkingStrategy;


public class ParkingLot {

    IParkingStrategy parkingStrategy;
    private int noOfFloors;
    private int slotsPerFloor;
    ParkingLot(int noOfFloors, int slotsPerFloor, IParkingStrategy parkingStrategy) {
        this.noOfFloors = noOfFloors;
        this.parkingStrategy = parkingStrategy;

    }

    public Integer assignParkingSlot(String regN, vehicleType vehicleType, String color) {

        for(int floor = 1; floor <= noOfFloors; floor++) {
            var ticketId = parkingStrategy.ParkVehicle(floor, vehicleType, regN, color);
            if(ticketId != null) {
                return ticketId;
            }
        }
    }
}
