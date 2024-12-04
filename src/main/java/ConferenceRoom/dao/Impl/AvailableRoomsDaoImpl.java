package ConferenceRoom.dao.Impl;

import ConferenceRoom.dao.AvailableRoomsDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvailableRoomsDaoImpl implements AvailableRoomsDao {

    HashMap<String, HashMap<String, HashMap<String, List<String>>>> conferenceRooms;


    public AvailableRoomsDaoImpl() {
        conferenceRooms = new HashMap<>();
    }


    public void addBuilding(String building) {
        conferenceRooms.put(building, new HashMap<>());
    }



    public HashMap<String, HashMap<String, List<String>>> getBuilding(String building) {
        return conferenceRooms.get(building);
    }



    public void addFloor(String building, String floor) {
        conferenceRooms.get(building).put(floor, new HashMap<>());
    }

    public HashMap<String, List<String>> getFloor(String building, String floor) {
        return conferenceRooms.get(building).get(floor);
    }

    public void addRoom(String building, String floor, String slot, String room) {
        var rooms = conferenceRooms.get(building).get(floor).get(slot);
        if(rooms == null) {
            conferenceRooms.get(building).get(floor).put(slot, new ArrayList<>());
            rooms = conferenceRooms.get(building).get(floor).get(slot);
        }
        rooms.add(room);
        conferenceRooms.get(building).get(floor).put(slot, rooms);
    }


    public List<String> getRoom(String building, String floor, String slot) {
        return conferenceRooms.get(building).get(floor).get(slot);
    }

    public void removeRoom(String building, String floor, String slot, String room) {
        var rooms = conferenceRooms.get(building).get(floor).get(slot);
        rooms.remove(room);
        conferenceRooms.get(building).get(floor).put(slot, rooms);
    }
}
