package ParkingLot.strategies.impl;

import ParkingLot.entities.vehicleType;
import ParkingLot.repository.ISlotRepository;

public class SlotStrategy {

    ISlotRepository slotRepository;

    public SlotStrategy(ISlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }


    void AddSlots(Integer floorNum, Integer slotsPerFloor) {
        for(Integer floor = 1; floor <= floorNum; floor++) {
            for(Integer slotNum = 1; slotNum <= slotsPerFloor; slotNum++) {
                vehicleType type = null;
                if(slotNum == 1) {
                    type = vehicleType.TRUCK;
                }
                if(slotNum >= 2 && slotNum <= 3) {
                    type = vehicleType.BIKE;
                }
                if(slotNum >= 4) {
                    type = vehicleType.CAR;
                }

                slotRepository.AddSlot(floorNum, type);
            }
        }
    }

}
