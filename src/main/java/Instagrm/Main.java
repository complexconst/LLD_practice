package Instagrm;

import Instagrm.entity.User;

public class Main {
    public static void main(String[] args) {
        Instagram instagram = new Instagram();

        User u1 = new User(1, "ram", "ram@gmail");

        User u2 = new User(2, "shaam", "shaaam@gmail");

        User u3 = new User(3, "sam", "sam@gmail");
        User u4 = new User(4, "sammy", "darren@gmail");

        instagram.createUser(u1);
        instagram.createUser(u2);
        instagram.createUser(u3);
        instagram.createUser(u4);


        instagram.addFollower(1, 2);
        instagram.addFollower(1, 3);
        instagram.addFollower(1, 4);

        instagram.getFollower(2);
    }
}
