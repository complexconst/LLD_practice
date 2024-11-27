package RestaurantManagementSystem.repository;

import RestaurantManagementSystem.entity.Table;
import RestaurantManagementSystem.enums.Status;
import RestaurantManagementSystem.enums.TableType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TableRepository {

    HashMap<Integer, Table> tables;

    public TableRepository() {
        tables = new HashMap<>();
    }

    public void addTable(Integer tableId, Table table) {
        tables.put(tableId, table);
    }


    public Table getTable(Integer tableId) {
        return tables.get(tableId);
    }


    public void removeTable(Integer tableId) {
        tables.remove(tableId);
    }

    public List<Integer> getAvailableTablesOfTypeAndStatus(TableType type, Status status) {
        List<Integer> availableTables = new ArrayList<>();
        for (Table table : tables.values()) {
            if(table.getSize() == type && table.getStatus() == status) {
                availableTables.add(table.getTableId());
            }
        }
        return availableTables;
    }

    public void modifyStatus(Integer tableId, Status newStatus) {
        tables.get(tableId).setStatus(newStatus);
    }


}
