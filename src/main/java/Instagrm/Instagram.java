package Instagrm;

import Instagrm.entity.Post;
import Instagrm.entity.User;
import Instagrm.entity.sevice.UserService;

import java.util.HashMap;
import java.util.Map;

public class Instagram {

    Map<Integer, User> users;
    UserService userService;


    public Instagram() {
        this.users = new HashMap<Integer, User>();
        userService = new UserService(users);
    }

    void createUser(User user) {
        userService.addUser(user);
    }

    void addFollower(Integer userId, Integer followerId) {
        userService.followUser(userId, followerId);
    }

    void removeFollower(Integer userId, Integer followerId) {
        userService.unfollowUser(userId, followerId);
    }

    void getFollower(Integer userId) {
        User user = userService.getUser(userId);
        System.out.println(user.getFollowers());
    }

    void getFollowing(Integer userId) {
        User user = userService.getUser(userId);
        System.out.println(user.getFollowing());
    }

    void uploadPost(Post post) {

    }

}
