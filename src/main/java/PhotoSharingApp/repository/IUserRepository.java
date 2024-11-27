package PhotoSharingApp.repository;


import PhotoSharingApp.entity.User;

public interface IUserRepository {

    public void addUser(User user);
    void deleteUser(Integer userId);
    User getUser(Integer userId);
    void replaceUser(User user);
}
