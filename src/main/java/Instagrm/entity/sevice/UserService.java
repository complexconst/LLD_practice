package Instagrm.entity.sevice;

import Instagrm.entity.User;
import Instagrm.exception.UserNotFoundException;

import java.util.List;
import java.util.Map;

public class UserService {

    Map<Integer, User> users;


    public UserService(Map<Integer, User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void removeUser(Integer userId) {
        users.remove(userId);
    }

    public User getUser(Integer userId) {
        return users.get(userId);
    }

    public void followUser(Integer followingUserID, Integer followerUserID) {
        User followingUser = null, userToBeFollowed = null;
        try {
            followingUser = users.get(followingUserID);
            userToBeFollowed = users.get(followerUserID);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if(followingUser == null) {
            throw new UserNotFoundException("User which has to follow not found");
        }

        if(userToBeFollowed == null) {
            throw new UserNotFoundException("User which has to be followed not found");
        }

        List<Integer> followingOfUser = followingUser.getFollowing();
        followingOfUser.add(followerUserID);
        followingUser.setFollowing(followingOfUser);
        users.remove(followingUserID);
        users.put(followingUserID, followingUser);

        List<Integer> followersOfUserToFollow = userToBeFollowed.getFollowers();
        followersOfUserToFollow.add(followingUserID);
        userToBeFollowed.setFollowers(followersOfUserToFollow);
        users.remove(followerUserID);
        users.put(followerUserID, userToBeFollowed);

    }

    public void unfollowUser(Integer followingUserID, Integer followerUserID) {
        User followingUser = null, userToBeunFollowed = null;
        try {
            followingUser = users.get(followingUserID);
            userToBeunFollowed = users.get(followerUserID);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if(followingUser == null) {
            throw new UserNotFoundException("User which has to follow not found");
        }

        if(userToBeunFollowed == null) {
            throw new UserNotFoundException("User which has to be followed not found");
        }

        List<Integer> followingOfUser = followingUser.getFollowing();
        if(!followingOfUser.contains(followerUserID)) {
            throw new UserNotFoundException("User which has to be unfollowed not found");
        }
        followingOfUser.remove(followerUserID);
        followingUser.setFollowing(followingOfUser);
        users.remove(followingUserID);
        users.put(followingUserID, followingUser);

        List<Integer> followersOfUserToFollow = userToBeunFollowed.getFollowers();
        followersOfUserToFollow.remove(followingUserID);
        userToBeunFollowed.setFollowers(followersOfUserToFollow);
        users.remove(followerUserID);
        users.put(followerUserID, userToBeunFollowed);
    }
}
