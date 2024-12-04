package Instagrm.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private List<Integer> followers;
    private List<Integer> following;


    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public List<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(List<Integer> following) {
        this.following = following;
    }

}
