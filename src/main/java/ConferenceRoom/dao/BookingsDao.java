package ConferenceRoom.dao;

import ConferenceRoom.entity.Booking;

import java.util.HashMap;

public interface BookingsDao {

    public Integer addBooking(Booking booking);

    public void removeBooking(Integer id);

    public Booking getBooking(Integer id);

    public HashMap<Integer, Booking> getAllBooking();
}
