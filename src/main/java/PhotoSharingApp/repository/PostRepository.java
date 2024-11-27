package PhotoSharingApp.repository;

import PhotoSharingApp.entity.Post;

import java.util.ArrayList;
import java.util.HashMap;

public class PostRepository implements IPostRepository {

    HashMap<Integer, Post> posts;

    public PostRepository() {
        posts = new HashMap<>();
    }

    @Override
    public void addPost(Post post) {
        posts.put(post.getPostId(), post);
    }

    @Override
    public void deletePost(Integer postId) {
        posts.remove(postId);
    }


    @Override
    public Post getPost(Integer postId) {
        return posts.get(postId);
    }

    @Override
    public ArrayList<Post> getAllPosts() {
        return new ArrayList<>(posts.values());
    }
}
