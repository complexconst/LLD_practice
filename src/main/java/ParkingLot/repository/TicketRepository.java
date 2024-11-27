package ParkingLot.repository;

import ParkingLot.entities.Ticket;
import ParkingLot.entities.vehicleType;

import java.util.TreeMap;

public class TicketRepository implements ITicketRepository {

    TreeMap<Integer, Ticket> tickets;
    static int ticketId;

    public TicketRepository() {
        tickets = new TreeMap<>();
        ticketId = 1;
    }
    @Override
    public Integer generateTicket(String regNo, Integer floorNum, vehicleType type, String color) {
        try {
            tickets.put(ticketId++, new Ticket(floorNum, regNo, type, color));
        return ticketId - 1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Ticket verifyTicket(Integer ticketId) {
        if(tickets.containsKey(ticketId)) {
            return tickets.get(ticketId);
        }
        return null;
    }
}
