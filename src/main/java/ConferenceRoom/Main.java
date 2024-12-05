package ConferenceRoom;

public class Main {
    public static void main(String[] args) {
        ConferenceRoom conferenceRoomm = new ConferenceRoom();

        conferenceRoomm.addBuilding("t-1");
        conferenceRoomm.addBuilding("t-2");
        conferenceRoomm.addBuilding("t-3");

        conferenceRoomm.addFloor("t-1", "1");
        conferenceRoomm.addFloor("t-1", "2");
        conferenceRoomm.addFloor("t-1", "3");

        conferenceRoomm.addFloor("t-2", "1");

        conferenceRoomm.addRoom("t-1", "2", "102");
        conferenceRoomm.addRoom("t-1", "2", "103");
        conferenceRoomm.addRoom("t-1", "2", "104");
        conferenceRoomm.addRoom("t-3", "1", "104");

        Integer b1 = conferenceRoomm.makeBooking("t-1", "2", "1:3", "102");
        Integer b2 = conferenceRoomm.makeBooking("t-1", "2", "1:3", "103");
        Integer b3 = conferenceRoomm.makeBooking("t-1", "2", "1:3", "104");
        conferenceRoomm.getBooking(b1);
        conferenceRoomm.getBooking(b2);
        conferenceRoomm.searchRooms("t-1", "2", "1:2");
        conferenceRoomm.cancelBooking(b1);
        conferenceRoomm.searchRooms("t-1", "2", "1:2");
        conferenceRoomm.showAllBookings();
    }
}
