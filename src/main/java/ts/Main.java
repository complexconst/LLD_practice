package ts;

import Instagrm.entity.User;

import java.time.LocalDateTime;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "", "");

        String s = user.toString();
        String ans = String.format("%s", user);
        System.out.println(ans);
    }
}
