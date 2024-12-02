package RestaurantManagementSystem.entity;

import RestaurantManagementSystem.enums.TableType;

import java.time.LocalDateTime;

public class Booking {

    private int bookingId;
    private Integer tableId;
    private int customerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Booking(int bookingId, Integer tableId, int customerId, LocalDateTime startTime, LocalDateTime endTime ) {
        this.bookingId = bookingId;
        this.tableId = tableId;
        this.customerId = customerId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Booking ID: " + bookingId + "\n");
        sb.append("Table ID: " + tableId + "\n");
        sb.append("Customer ID: " + customerId + "\n");
        sb.append("Start Time: " + startTime + "\n");
        sb.append("End Time: " + endTime + "\n");
        return sb.toString();
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
