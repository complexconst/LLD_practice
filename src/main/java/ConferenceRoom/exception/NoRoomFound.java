package ConferenceRoom.exception;

public class NoRoomFound extends RuntimeException {
    public NoRoomFound(String message) {
        super(message);
    }
}
