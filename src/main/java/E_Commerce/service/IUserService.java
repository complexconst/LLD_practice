package E_Commerce.service;

import E_Commerce.entity.User;
import E_Commerce.repository.IUserRepository;
import E_Commerce.repository.UserRepository;

public interface IUserService {

    public Integer addUser(User user);
    public void removeUser(Integer userId);
}


class UserService implements IUserService {
    IUserRepository userRepository;
    static int userId = 1;

    public UserService() {
        this.userRepository = new UserRepository();
    }


    public Integer addUser(User user) {
        userRepository.addUserId(userId++, user);
        return userId - 1;
    }

    public void removeUser(Integer userId) {
        userRepository.removeUserId(userId);
    }

}