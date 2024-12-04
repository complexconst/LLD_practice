package Instagrm.entity;

public class Post {
    private int id;
    private String title;
    private String content;
    private int userId;
    private int numOfLikes;

    public Post(int id, String title, String content, int userId, int numOfLikes) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.numOfLikes = numOfLikes;
    }

    public int getId() {
        return id;
    }
}
