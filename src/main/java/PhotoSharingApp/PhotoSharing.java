package PhotoSharingApp;

import PhotoSharingApp.entity.Post;
import PhotoSharingApp.entity.User;
import PhotoSharingApp.service.ISystemService;
import PhotoSharingApp.service.IUserService;
import PhotoSharingApp.service.UserService;

public class PhotoSharing {

    IUserService userService;
    ISystemService systemService;
    static Integer globUserId = 1;
    static Integer globPostId = 1;

    PhotoSharing(UserService userService) {
        this.userService = userService;
    }



    void registerUser(String name, String email) {
        var user = new User(globUserId++, name, email);

        systemService.createUser(user);
    }

    void deleteAccount(Integer userId) {
        systemService.deleteUser(userId);
    }

    void like(Integer postId) {
        userService.likePost(postId);
    }

    void unlike(Integer postId) {
        userService.unlikePost(postId);
    }

    void upload(Integer userId, Post post) {
        userService.uploadPost(userId, post);
    }

    void follow(Integer userId, Integer userFollowId) {
        userService.followUser(userId, userFollowId);
    }

    void unfollow(Integer userId, Integer userFollowId) {
        userService.unfollowUser(userId, userFollowId);
    }


}
