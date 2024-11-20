package ParkingLot.strategies.impl;

import ParkingLot.entities.Ticket;
import ParkingLot.entities.vehicleType;
import ParkingLot.repository.ISlotRepository;
import ParkingLot.repository.ITicketRepository;
import ParkingLot.strategies.IParkingStrategy;

public class ParkingStrategy implements IParkingStrategy {

    ISlotRepository slotRepository;
    ITicketRepository ticketRepository;

    ParkingStrategy(ISlotRepository slotRepository, ITicketRepository ticketRepository) {
        this.slotRepository = slotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Integer ParkVehicle(Integer floorNum, vehicleType type, String regNo, String color) {
        Integer slotsAvailable = slotRepository.slotsOnFloor(floorNum, type);
        if(slotsAvailable == 0) {
            System.out.println("No free slots found");
            return null;
        }
        slotRepository.removeSlot(floorNum, type);

        Integer ticketId = ticketRepository.generateTicket(regNo, floorNum, type, color);

        System.out.println("Vehicle with regNo. " + regNo + " has been parked with ticketid " + ticketId);
        return ticketId;
    }



    public void UnParkVehicle(Integer ticketId) {
        Ticket ticket = ticketRepository.verifyTicket(ticketId);

        if(ticket == null) {
            System.out.println("No ticket found");
        }
        slotRepository.addSlot(ticket.getFloorNumber(), ticket.getVehicleType());
        System.out.println("Vehicle with regNo. " + ticket.getRegNo() + " has been unparked");
    }
}
