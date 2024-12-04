package ConferenceRoom.dao;

import java.util.HashMap;
import java.util.List;

public interface AvailableRoomsDao {


    public void addBuilding(String building);

    public void addFloor(String building, String floor);


    public void addRoom(String building, String floor, String slot, String room);
//    public List<String> searchRooms(String building, String floor, String slot);

    public HashMap<String, HashMap<String, List<String>>> getBuilding(String building);

    public HashMap<String, List<String>> getFloor(String building, String floor);


    public List<String> getRoom(String building, String floor, String slot);

    public void removeRoom(String building, String floor, String slot, String room);
}
