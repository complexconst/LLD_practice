package RestaurantManagementSystem.entity;

import RestaurantManagementSystem.enums.Status;
import RestaurantManagementSystem.enums.TableType;

public class Table {
    private int tableId;
    private TableType size;
    private Status status;


    public Table(int tableId, TableType size, Status status) {
        this.tableId = tableId;
        this.size = size;
        this.status = status;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TableType getSize() {
        return size;
    }

    public void setSize(TableType size) {
        this.size = size;
    }
}
