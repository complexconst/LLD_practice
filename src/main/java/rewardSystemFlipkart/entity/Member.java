package rewardSystemFlipkart.entity;

import java.util.ArrayList;
import java.util.List;

public class Member {
    int id;
    String name;
    int supercoins;
    List<Bid> bids;

    public Member(int id, String name, int supercoins) {
        this.id = id;
        this.name = name;
        this.supercoins = supercoins;
        bids = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupercoins() {
        return supercoins;
    }

    public void setSupercoins(int supercoins) {
        this.supercoins = supercoins;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}
