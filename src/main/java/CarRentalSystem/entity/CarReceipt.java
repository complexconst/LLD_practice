package CarRentalSystem.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CarReceipt {
    Integer carId;
    LocalDateTime rentalDate;

    public CarReceipt(Integer carId, LocalDateTime rentalDate) {
        this.carId = carId;
        this.rentalDate = rentalDate;
    }
}
