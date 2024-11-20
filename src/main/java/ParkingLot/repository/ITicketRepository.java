package ParkingLot.repository;

import ParkingLot.entities.Ticket;
import ParkingLot.entities.vehicleType;

public interface ITicketRepository {
    public Integer generateTicket(String regNo, Integer floorNum, vehicleType type, String color);

    public Ticket verifyTicket(Integer ticketId);
}
