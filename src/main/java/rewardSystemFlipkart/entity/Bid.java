package RewardSystemFlipkart.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bid {
    int memberId;
    int eventId;
    LocalDateTime bidTime;
    List<Integer> bidAmts;

    public Bid(int memberId, int eventId) {
        this.memberId = memberId;
        this.eventId = eventId;
        this.bidTime = LocalDateTime.now();
        this.bidAmts = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getEventId() {
        return eventId;
    }

    public List<Integer> getBidAmts() {
        return bidAmts;
    }

    public void setBidAmts(List<Integer> bidAmts) {
        this.bidAmts = bidAmts;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }
}
