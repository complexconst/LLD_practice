package RestaurantManagementSystem.services;

import RestaurantManagementSystem.entity.Table;
import RestaurantManagementSystem.enums.Status;
import RestaurantManagementSystem.enums.TableType;
import RestaurantManagementSystem.repository.TableRepository;

import java.util.List;

public class TableService {

    private TableRepository tableRepository;


    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }


    void bookTable(Integer tableId) {
        tableRepository.modifyStatus(tableId, Status.BOOKED);
    }

    public void addTable(Integer tableId) {
        Table table = new Table(tableId, TableType.MEDIUM, Status.AVAILABLE);
        tableRepository.addTable(tableId, table);
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
