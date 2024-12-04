package ConferenceRoom.dao.Impl;

import ConferenceRoom.dao.BookingsDao;
import ConferenceRoom.entity.Booking;

import java.util.HashMap;

public class BookingsDaoImpl implements BookingsDao {
    HashMap<Integer, Booking> bookings;


    public BookingsDaoImpl() {
        this.bookings = new HashMap<>();
    }


    public Integer addBooking(Booking booking) {
        bookings.put(booking.id(), booking);
        return booking.id();
    }

    public void removeBooking(Integer id) {
        bookings.remove(id);
    }

    public Booking getBooking(Integer id) {
        return bookings.get(id);
    }

    public HashMap<Integer, Booking> getAllBooking() {
        return bookings;
    }

}
