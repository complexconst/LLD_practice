package PhotoSharingApp.service;

import PhotoSharingApp.entity.User;

public interface ISystemService {

    void createUser(User user);

    void deleteUser(Integer userId);
}
