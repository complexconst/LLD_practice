package RewardSystemFlipkart.entity;

import java.util.*;

public class Event {
    int id;
    String name;
    Prize prize;
    Date date;
    Integer winnerId = null;
    Map<Integer, Bid> memberIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event(int id, String name, Prize prize) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        date = new Date();
        this.memberIds = new HashMap<>();
    }

    public Integer getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public Map<Integer, Bid> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(Map<Integer, Bid> memberIds) {
        this.memberIds = memberIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prize=" + prize.getName() +
                ", date=" + date +
                ", winnerId=" + winnerId +
                '}';
    }
}
