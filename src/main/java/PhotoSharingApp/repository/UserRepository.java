package PhotoSharingApp.repository;


import PhotoSharingApp.entity.User;

import java.util.HashMap;

public class UserRepository implements IUserRepository {

    HashMap<Integer, User> users;

    public UserRepository() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void deleteUser(Integer userId) {
        users.remove(userId);
    }

    public User getUser(Integer userId) {
        return users.get(userId);
    }

    public void replaceUser(User user) {
        users.replace(user.getId(), user);
    }

}
