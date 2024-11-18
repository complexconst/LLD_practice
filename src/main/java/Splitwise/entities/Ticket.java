package Splitwise.entities;

public class Ticket {
    Integer floorNumber;
    String regNo;
    Splitwise.entities.vehicleType vehicleType;
    String vehicleColor;

    public Ticket(Integer floorNumber, String regNo, vehicleType vehicleType, String vehicleColor) {
        this.floorNumber = floorNumber;
        this.regNo = regNo;
        this.vehicleType = vehicleType;
        this.vehicleColor = vehicleColor;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public String getRegNo() {
        return regNo;
    }

    public Splitwise.entities.vehicleType getVehicleType() {
        return vehicleType;
    }
    public String getVehicleColor() {
        return vehicleColor;
    }
}
