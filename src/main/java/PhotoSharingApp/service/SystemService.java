package PhotoSharingApp.service;

import PhotoSharingApp.entity.User;
import PhotoSharingApp.repository.IUserRepository;

public class SystemService implements  ISystemService{

    IUserRepository userRepository;


    SystemService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user){
        userRepository.addUser(user);
    }

    @Override
    public void deleteUser(Integer userId){
        userRepository.deleteUser(userId);
    }
}
