package PhotoSharingApp.repository;

import PhotoSharingApp.entity.Post;

import java.util.List;

public interface IPostRepository {

    void addPost(Post post);

    void deletePost(Integer postId);

    Post getPost(Integer postId);

    List<Post> getAllPosts();

}
