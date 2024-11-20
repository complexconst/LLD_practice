package ParkingLot;

import ParkingLot.entities.vehicleType;
import ParkingLot.repository.ISlotRepository;
import ParkingLot.repository.SlotRepository;
import ParkingLot.strategies.IParkingStrategy;
import ParkingLot.strategies.ISlotStrategy;
import ParkingLot.strategies.impl.ParkingStrategy;
import ParkingLot.strategies.impl.SlotStrategy;

public class Main {
    public static void main(String[] args) {

        ISlotRepository slotRepository = new SlotRepository();
        IParkingStrategy pStrategy = new ParkingStrategy(slotRepository);
        ISlotStrategy sStrategy = new SlotStrategy(slotRepository);
        ParkingLot p = new ParkingLot(1, 6, pStrategy, sStrategy);
        Integer id1 = p.assignParkingSlot("KA-1233", vehicleType.TRUCK, "Grey");
        Integer id2 = p.assignParkingSlot("MP-1233", vehicleType.CAR, "Grey");
        Integer id3 = p.assignParkingSlot("UP-1235", vehicleType.TRUCK, "Grey");

        p.unassignParkingSlot(id1);
//        if(id == null) {
//            System.out.println("No slots found");
//        }
//        else System.out.println(id);

    }


}
