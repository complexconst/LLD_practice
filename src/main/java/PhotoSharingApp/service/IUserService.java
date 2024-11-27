package PhotoSharingApp.service;

import PhotoSharingApp.entity.Post;

import java.util.List;

public interface IUserService {


    public void uploadPost(Integer userId, Post post);


    public void removePost(Integer userId, Integer postId);

    public void updatePost(Integer userId, Integer postId);

    public List<Integer> getAllPostsForUser(Integer userId);


    public void likePost(Integer postId);

    public void unlikePost(Integer postId);


    public void followUser(Integer userId, Integer userIdToFollow);

    public void unfollowUser(Integer userId, Integer userIdToFollow);



}
