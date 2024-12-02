package RestaurantManagementSystem.services;

import RestaurantManagementSystem.entity.Booking;
import RestaurantManagementSystem.enums.PaymentType;
import RestaurantManagementSystem.enums.Status;
import RestaurantManagementSystem.enums.TableType;
import RestaurantManagementSystem.repository.BookingRepository;

import java.time.LocalDateTime;

public class BookingService {

    BookingRepository bookingRepository;
    PaymentFactory paymentFactory;
    TableService tableService;
    static int globBookingId;


    public BookingService(PaymentFactory paymentFactory, TableService tableService, BookingRepository bookingRepository) {
        this.bookingRepository = new BookingRepository();
        this.paymentFactory = paymentFactory;
        this.tableService = tableService;
    }

    public Integer makeBooking(PaymentType paymentType, Integer customerId, TableType tableType, LocalDateTime startTime, LocalDateTime endTime) {

        var availableTables = tableService.getTableWithTypeAndStatus(tableType, Status.AVAILABLE);

        if(availableTables.isEmpty()) {
            System.out.println("No available tables found");
            return null;
        }
        else {
            globBookingId++;
            var tableId = availableTables.get(0);


            var booking = new Booking(globBookingId, tableId, customerId, startTime, endTime);

            var paymentService = paymentFactory.getPaymentService(paymentType);

            paymentService.acceptPayment();

            tableService.bookTable(tableId);
            bookingRepository.addBooking(globBookingId, booking);
            return globBookingId;
        }
    }

    public void cancelBooking(Integer bookingId) {
        bookingRepository.removeBooking(bookingId);
    }


    public void showAllBookings() {
        bookingRepository.showAllBookings();
    }

}
