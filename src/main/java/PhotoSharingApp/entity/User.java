package PhotoSharingApp.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    Integer id;
    String name;
    String email;
    List<Integer> following;
    List<Integer> followers;
    List<Integer> posts;

    public User(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.posts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Integer> getFollowing() {
        return following;
    }
    public void setFollowing(List<Integer> following) {
        this.following = following;
    }
    public List<Integer> getFollowers() {
        return followers;
    }
    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }
    public List<Integer> getPosts() {
        return posts;
    }
    public void addPosts(Integer postId) {
        this.posts.add(postId);
    }
}
