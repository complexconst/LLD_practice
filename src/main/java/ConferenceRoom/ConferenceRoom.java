package ConferenceRoom;

import ConferenceRoom.dao.AvailableRoomsDao;
import ConferenceRoom.dao.BookingsDao;
import ConferenceRoom.dao.Impl.AvailableRoomsDaoImpl;
import ConferenceRoom.dao.Impl.BookingsDaoImpl;
import ConferenceRoom.service.AdminService;
import ConferenceRoom.service.BookingService;

public class ConferenceRoom {
    AvailableRoomsDao availableRoomsDao = new AvailableRoomsDaoImpl();
    BookingsDao bookingsDao = new BookingsDaoImpl();
    AdminService adminService = new AdminService(availableRoomsDao);
    BookingService bookingService = new BookingService(adminService, bookingsDao);


    public ConferenceRoom() {

    }

    public void addBuilding(String building) {
        adminService.addBuilding(building);
    }
    public void addFloor(String building, String floor) {
        adminService.addFloor(building, floor);
    }
    public void addRoom(String buolding, String floor, String room) {
        adminService.addRoom(buolding, floor, room);
    }
    public Integer makeBooking(String building, String floor, String slot, String room) {
        return bookingService.addBooking(building, floor, slot, room);
    }
    public void searchRooms(String building, String floor, String slot) {
        adminService.searchRooms(building, floor, slot);
    }
    public void cancelBooking(Integer bookingId) {
        bookingService.cancelBooking(bookingId);
    }
    public void showAllBookings() {
        bookingService.getAllBookings();
    }
}
