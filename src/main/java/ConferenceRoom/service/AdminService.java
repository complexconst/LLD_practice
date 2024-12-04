package ConferenceRoom.service;

import ConferenceRoom.dao.AvailableRoomsDao;
import ConferenceRoom.exception.NoBuildingFound;
import ConferenceRoom.exception.NoFloorFound;
import ConferenceRoom.exception.NoRoomFound;

import java.util.List;

public class AdminService {


    AvailableRoomsDao availableRoomsDao;

    public AdminService(AvailableRoomsDao availableRoomsDao) {
        this.availableRoomsDao = availableRoomsDao;
    }

    public void checkIfExists(String... checkParameters) {
        String buildingName = null, floor = null, slot = null, room = null;
        for(int i = 0; i < checkParameters.length; i++) {
            if(buildingName == null) buildingName = checkParameters[i];
            else {
                if(floor == null) floor = checkParameters[i];
                else {
                    if(slot == null) slot = checkParameters[i];
                    else room = checkParameters[i];
                }
            }
        }
        if(availableRoomsDao.getBuilding(buildingName) == null) {
            throw new NoBuildingFound("No building with name " + buildingName);
        }
        if(floor != null && availableRoomsDao.getFloor(buildingName, floor) == null) {
            throw new NoFloorFound("No Floor with name " + floor);
        }
        if(slot != null && floor != null && availableRoomsDao.getRoom(buildingName, floor, slot) == null) {
            throw new NoRoomFound("No Rooms with slot " + slot);
        }
        if(slot != null && floor != null && room != null) {
            var rooms = availableRoomsDao.getRoom(buildingName, floor, slot);
            if(room != null && !rooms.contains(room)) {
                throw new NoRoomFound("No room with name " + room);
            }
        }
    }

    public void addBuilding(String buildingName) {
        availableRoomsDao.addBuilding(buildingName);
    }

    String returnSlotFromIntegers(Integer i, Integer j) {
        StringBuilder sb = new StringBuilder(i.toString());
        sb.append(":");
        sb.append(j);
        return sb.toString();
    }

    public void addFloor(String buildingName, String floor) {
        try {
            checkIfExists(buildingName);
            availableRoomsDao.addFloor(buildingName, floor);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void addRoom(String buildingName, String floor, String roomName) {
        try {
            checkIfExists(buildingName, floor);
            for(Integer startTime = 0; startTime <= 24; startTime++) {
                for(Integer endTime = startTime + 1; endTime <= 24; endTime++) {
                    if(startTime == endTime) continue;
                    StringBuilder sb = new StringBuilder(startTime.toString());
                    sb.append(":");
                    sb.append(endTime.toString());
                    availableRoomsDao.addRoom(buildingName, floor, sb.toString(), roomName);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void addRoomWithSlot(String buildingName, String floor, String slot, String roomName) {
        try {
            checkIfExists(buildingName, floor);
            availableRoomsDao.addRoom(buildingName, floor, slot, roomName);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void searchRooms(String buildingName, String floor, String slot) {
        try {
            checkIfExists(buildingName, floor, slot);
            System.out.println(availableRoomsDao.getRoom(buildingName, floor, slot));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(String buildingName, String floor, String slot, String roomName) {
        try {
            checkIfExists(buildingName, floor, slot);
            availableRoomsDao.removeRoom(buildingName, floor, slot, roomName);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

//    public List<String> suggestRooms()

}
