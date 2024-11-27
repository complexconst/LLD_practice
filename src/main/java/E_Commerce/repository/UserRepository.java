package E_Commerce.repository;

import E_Commerce.entity.User;

import java.util.HashMap;

public class UserRepository implements IUserRepository {

    HashMap<Integer, User> users;


    public UserRepository() {
        users = new HashMap<Integer, User>();
    }

    public void addUserId(Integer id, User user) {
        users.put(id, user);
    }

    public void removeUserId(Integer id) {
        users.remove(id);
    }


}
