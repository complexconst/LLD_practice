package ConferenceRoom.service;

import ConferenceRoom.dao.BookingsDao;
import ConferenceRoom.entity.Booking;
//import.Booking;

public class BookingService {

    AdminService adminService;
    BookingsDao bookingsDao;
    static int globBookingId = 0;


    public BookingService(AdminService adminService, BookingsDao bookingsDao) {
        this.adminService = adminService;
        this.bookingsDao = bookingsDao;
    }



    public Integer addBooking(String building, String floor, String slot, String room) {
        try {
            adminService.checkIfExists(building, floor, slot, room);
            String slots[] = slot.split(":");
            for(Integer i = 0; i <= Integer.parseInt(slots[1]); i++) {
                for(Integer j = Integer.parseInt(slots[1]); j <= 24; j++) {
                    if(i == j) continue;
                    var reqSlot = adminService.returnSlotFromIntegers(i, j);
                    adminService.deleteRoom(building, floor, reqSlot, room);
                }
            }
            for(Integer i = Integer.parseInt(slots[0]); i <= Integer.parseInt(slots[1]); i++) {
                for(Integer j = i + 1; j <= Integer.parseInt(slots[1]); j++) {
                    if(i == j) continue;
                    var reqSlot = adminService.returnSlotFromIntegers(i, j);
                    adminService.deleteRoom(building, floor, reqSlot, room);
                }
            }
            Booking booking = new Booking(globBookingId++, building, floor, slot, room);
            return bookingsDao.addBooking(booking);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cancelBooking(Integer bookingId) {
        try {
            Booking booking = bookingsDao.getBooking(bookingId);
            adminService.checkIfExists(booking.building(), booking.floor(), booking.slot());
            var building = booking.building();
            var floor = booking.floor();
            var slot = booking.slot();
            var room = booking.room();
            String slots[] = slot.split(":");
            for(Integer i = 0; i <= Integer.parseInt(slots[1]); i++) {
                for(Integer j = Integer.parseInt(slots[1]); j <= 24; j++) {
                    if(i == j) continue;
                    var reqSlot = adminService.returnSlotFromIntegers(i, j);
                    adminService.addRoomWithSlot(booking.building(), booking.floor(), reqSlot, booking.room());
                }
            }
            for(Integer i = Integer.parseInt(slots[0]); i <= Integer.parseInt(slots[1]); i++) {
                for(Integer j = i + 1; j <= Integer.parseInt(slots[1]); j++) {
                    if(i == j) continue;
                    var reqSlot = adminService.returnSlotFromIntegers(i, j);
                    adminService.addRoomWithSlot(booking.building(), booking.floor(), reqSlot, booking.room());
                }
            }
            bookingsDao.removeBooking(booking.id());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Booking getBooking(Integer bookingId) {
        try {
            return bookingsDao.getBooking(bookingId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getAllBookings() {
        System.out.println(bookingsDao.getAllBooking());
    }

}
