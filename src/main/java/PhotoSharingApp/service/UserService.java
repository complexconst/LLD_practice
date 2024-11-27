package PhotoSharingApp.service;

import PhotoSharingApp.entity.Post;
import PhotoSharingApp.repository.IPostRepository;
import PhotoSharingApp.repository.IUserRepository;
import PhotoSharingApp.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserService implements IUserService {


    IPostRepository postRepository;
    IUserRepository userRepository;


    UserService() {
        postRepository = new PostRepository();
    }

    @Override
    public void uploadPost(Integer userId, Post post) {
        postRepository.addPost(post);

        var user = userRepository.getUser(userId);

        user.addPosts(post.getPostId());

        userRepository.replaceUser(user);
    }

    @Override
    public void removePost(Integer userId, Integer postId) {
        postRepository.deletePost(postId);

        var user = userRepository.getUser(userId);

        userRepository.replaceUser(user);
    }

    @Override
    public void updatePost(Integer userId, Integer postId) {
        var post = postRepository.getPost(postId);

        post.setPostContent(post.getPostContent().trim());
    }

    public List<Integer> getAllPostsForUser(Integer userId) {
        var listOfPosts = new ArrayList<Integer>();
        for(var post : postRepository.getAllPosts()) {
            if(Objects.equals(post.getUserId(), userId)) {
                listOfPosts.add(post.getPostId());
            }
        }
        return listOfPosts;
    }

    @Override
    public void likePost(Integer postId) {
        var post = postRepository.getPost(postId);

        Integer numOfLikes = post.getNumberOfLikes();
        numOfLikes++;

        post.setNumberOfLikes(numOfLikes);

        postRepository.deletePost(postId);
        postRepository.addPost(post);
    }

    @Override
    public void unlikePost(Integer postId) {
        var post = postRepository.getPost(postId);

        Integer numOfLikes = post.getNumberOfLikes();
        numOfLikes--;

        post.setNumberOfLikes(numOfLikes);

        postRepository.deletePost(postId);
        postRepository.addPost(post);
    }

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        var user = userRepository.getUser(userId);

        var following = user.getFollowing();

        following.add(userIdToFollow);

        user.setFollowing(following);

        var userToFollow = userRepository.getUser(userIdToFollow);

        var followers = userToFollow.getFollowers();
        followers.add(userId);

        userToFollow.setFollowers(followers);
    }

    public void unfollowUser(Integer userId, Integer userIdToFollow) {
        var user = userRepository.getUser(userId);

        var following = user.getFollowing();

        following.remove(userIdToFollow);

        user.setFollowing(following);

        var userToFollow = userRepository.getUser(userIdToFollow);

        var followers = userToFollow.getFollowers();
        followers.remove(userId);

        userToFollow.setFollowers(followers);
    }
}
