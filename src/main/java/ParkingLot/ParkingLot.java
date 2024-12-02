package ParkingLot;

import ParkingLot.entities.vehicleType;
import ParkingLot.strategies.IParkingStrategy;
import ParkingLot.strategies.ISlotStrategy;


public class ParkingLot {

    IParkingStrategy parkingStrategy;
    ISlotStrategy slotStrategy;
    private int noOfFloors;
    private int slotsPerFloor;


    public ParkingLot(int noOfFloors, int slotsPerFloor, IParkingStrategy parkingStrategy, ISlotStrategy slotStrategy) {
        this.noOfFloors = noOfFloors;
        this.parkingStrategy = parkingStrategy;
        this.slotStrategy = slotStrategy;

        this.slotStrategy.addSlots(noOfFloors, slotsPerFloor);
    }

    public Integer assignParkingSlot(String regN, vehicleType vehicleType, String color) {

        for(int floor = 1; floor <= noOfFloors; floor++) {
            var ticketId = parkingStrategy.ParkVehicle(floor, vehicleType, regN, color);
            if(ticketId != null) {
                return ticketId;
            }
        }
        return null;
    }


    public void unassignParkingSlot(Integer ticketId) {
        parkingStrategy.UnParkVehicle(ticketId);
    }
}
