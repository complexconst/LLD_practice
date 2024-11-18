package ParkingLot;

import ParkingLot.entities.vehicleType;

public class Main {
    public static void main(String[] args) {


        ParkingLot p = new ParkingLot(8, 6);
        int id1 = p.parkVehicle(vehicleType.TRUCK, "KA_16251", "black");
        p.getFreeSlots();
        System.out.println("Hello World");
        int id2 = p.parkVehicle(vehicleType.CAR, "KA_16252", "red");
        p.UnparkVehicle(id1);
        System.out.println(id1 + "" + id2);
        p.getFreeSlots();
    }


}
