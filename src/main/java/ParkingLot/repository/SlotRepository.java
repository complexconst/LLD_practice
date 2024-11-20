package ParkingLot.repository;

import ParkingLot.entities.vehicleType;

import java.util.TreeMap;

public class SlotRepository implements ISlotRepository {

    TreeMap<Integer, TreeMap<vehicleType, Integer>> freeSlots;

    public SlotRepository() {
        freeSlots = new TreeMap<>();
    }


    public void addSlot(Integer floorNum, vehicleType vehicleType) {
        TreeMap<vehicleType, Integer> slots = freeSlots.get(floorNum);
        slots.merge(vehicleType, 1, (v1, v2) -> v1 + v2);
    }

    public void removeSlot(Integer floorNum, vehicleType vehicleType) {
        TreeMap<vehicleType, Integer> slots = freeSlots.get(floorNum);
        Integer curSlots = slots.get(vehicleType);
        freeSlots.get(floorNum).remove(vehicleType);
        curSlots--;
        if(curSlots > 0) {
            freeSlots.get(floorNum).put(vehicleType, curSlots);
        }
    }

    public Integer slotsOnFloor(Integer floorNum, vehicleType vehicleType) {
        TreeMap<vehicleType, Integer> slots = freeSlots.get(floorNum);
        if(slots.containsKey(vehicleType)) {
            return slots.get(vehicleType);
        }
        return 0;
    }

}
