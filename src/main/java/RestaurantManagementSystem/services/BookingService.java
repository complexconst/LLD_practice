package RestaurantManagementSystem.services;

import RestaurantManagementSystem.entity.Booking;
import RestaurantManagementSystem.enums.Status;
import RestaurantManagementSystem.enums.TableType;
import RestaurantManagementSystem.repository.BookingRepository;

import java.time.LocalDateTime;

public class BookingService {

    BookingRepository bookingRepository;
    TableService tableService;
    PaymentService paymentService;
    static int globBookingId;


    public BookingService() {
        this.bookingRepository = new BookingRepository();
    }

    public Integer makeBooking(Integer customerId, TableType tableType, LocalDateTime startTime, LocalDateTime endTime) {

        var availableTables = tableService.getTableWithTypeAndStatus(tableType, Status.AVAILABLE);

        if(availableTables.isEmpty()) {
            System.out.println("No available tables found");
            return null;
        }
        else {
            globBookingId++;
            var tableId = availableTables.get(0);


            var booking = new Booking(globBookingId, tableId, customerId, startTime, endTime);

            // payment code Pending

            tableService.bookTable(tableId);
            bookingRepository.addBooking(globBookingId, booking);
            return globBookingId;
        }
    }

    public void cancelBooking(Integer bookingId) {
        bookingRepository.removeBooking(bookingId);
    }

}
