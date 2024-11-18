package ParkingLot;

import ParkingLot.entities.Ticket;
import ParkingLot.entities.vehicleType;

import java.util.TreeMap;


public class ParkingLot {
    TreeMap<Integer, TreeMap<vehicleType, Integer>> freeSlots;
    TreeMap<Integer, Ticket> tickets;
    static int ticketId = 0;
    private int noOfFloors;
    ParkingLot(int noOfFloors, int slotsPerFloor) {
        freeSlots = new TreeMap<>();
        tickets = new TreeMap<>();
        this.noOfFloors = noOfFloors;
        for(int i = 1; i <= noOfFloors; i++) {
            freeSlots.put(i, new TreeMap<>());
            System.out.println(freeSlots);
            for(int j = 1; j <= slotsPerFloor; j++) {
                if(j == 1) {
                    freeSlots.get(i).put(vehicleType.TRUCK, 1);
                }
                if(j <= 3 && j >= 2) {
                    freeSlots.get(i).merge(vehicleType.BIKE, 1, Integer::sum);
                }
                if(j >= 4) {
                    freeSlots.get(i).merge(vehicleType.CAR, 1, Integer::sum);
                }
            }
        }
    }

    public Integer parkVehicle(vehicleType type, String regNo, String color) {
        for(Integer i = 1;  i <= this.noOfFloors; i++) {
            if(freeSlots.get(i).containsKey(type)) {
                int curSlots = freeSlots.get(i).get(type);
                curSlots--;
                freeSlots.get(i).remove(type);
                if(curSlots > 0) {
                    freeSlots.get(i).put(type, curSlots);
                }
                tickets.put(ticketId++, new Ticket(i, regNo, type, color));
                System.out.println("Vehicle with Number " + regNo + ", color " + color  + " and type " + type + " parked successfully");
                return ticketId - 1;
            }
        }
        System.out.println("No free slots found");
        return null;
    }

    public void UnparkVehicle(Integer inputTicketId) {
        if(tickets.containsKey(inputTicketId)) {

            Ticket ticket = tickets.get(inputTicketId);

            freeSlots.get(ticket.getFloorNumber()).merge(ticket.getVehicleType(), 1, Integer::sum);
            tickets.remove(inputTicketId);

            System.out.println("Vehicle with Number" + ticket.getRegNo() + " and color " + ticket.getVehicleColor() + " has been unparked");
        }
        else {
            System.out.println("No vehicle found");
        }
    }

    public void getFreeSlots() {
        for(var entry : freeSlots.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
