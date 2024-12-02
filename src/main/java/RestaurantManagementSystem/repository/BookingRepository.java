package RestaurantManagementSystem.repository;

import RestaurantManagementSystem.entity.Booking;

import java.util.HashMap;

public class BookingRepository {

    HashMap<Integer, Booking> bookings;

    public BookingRepository() {
        bookings = new HashMap<>();
    }

    public void addBooking(Integer bookingId, Booking booking) {
        bookings.put(bookingId, booking);
    }
    public Booking getBooking(Integer bookingId) {
        return bookings.get(bookingId);
    }
    public void removeBooking(Integer bookingId) {
        bookings.remove(bookingId);
    }

    public void showAllBookings() {
        System.out.println(bookings);
    }

}
