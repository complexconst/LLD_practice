package Instagrm.entity.sevice;

import Instagrm.entity.Post;

import java.util.Map;

public class PostService {

    Map<Integer, Post> posts;


    public PostService(Map<Integer, Post> posts) {
        this.posts = posts;
    }


    public void addcontent(Post post) {
        posts.put(post.getId(), post);
    }


}
