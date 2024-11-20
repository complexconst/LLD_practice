package ParkingLot.repository;

import ParkingLot.entities.vehicleType;

public interface ISlotRepository {
    void addSlot(Integer floorNum, vehicleType vehicleType);
    void removeSlot(Integer floorNum, vehicleType vehicleType);
    public Integer slotsOnFloor(Integer floorNum, vehicleType vehicleType);
}
