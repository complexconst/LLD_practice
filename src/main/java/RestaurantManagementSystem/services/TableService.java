package RestaurantManagementSystem.services;

import RestaurantManagementSystem.enums.Status;
import RestaurantManagementSystem.enums.TableType;
import RestaurantManagementSystem.repository.TableRepository;

import java.util.List;

public class TableService {

    private TableRepository tableRepository;


    public TableService() {
        this.tableRepository = new TableRepository();
    }


    void bookTable(Integer tableId) {
        tableRepository.modifyStatus(tableId, Status.BOOKED);
    }


    void freeTable(Integer tableId) {
        tableRepository.modifyStatus(tableId, Status.AVAILABLE);
    }

    List<Integer> getTableWithTypeAndStatus(TableType tableType, Status status) {
        return tableRepository.getAvailableTablesOfTypeAndStatus(tableType, status);
    }

    void setStatus(Integer tableId, Status status) {
        tableRepository.modifyStatus(tableId, status);
    }
}
