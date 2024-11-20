package ParkingLot.strategies.impl;

import ParkingLot.entities.vehicleType;
import ParkingLot.repository.ISlotRepository;
import ParkingLot.repository.SlotRepository;
import ParkingLot.strategies.ISlotStrategy;

public class SlotStrategy implements ISlotStrategy {

    ISlotRepository slotRepository;

    public SlotStrategy(ISlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }


    public void addSlots(Integer floorNum, Integer slotsPerFloor) {
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

                slotRepository.addSlot(floor, type);
            }
        }
    }

}
