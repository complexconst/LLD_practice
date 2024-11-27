package E_Commerce.repository;

import E_Commerce.entity.User;

public interface IUserRepository {
    public void addUserId(Integer id, User user);
    public void removeUserId(Integer id);
}
