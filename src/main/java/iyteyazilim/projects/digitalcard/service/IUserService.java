package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.User;

import java.util.List;

public interface IUserService {
    public void addUser(User user);
    public List<User> getUsers();
    public User getUser(Integer id);
    public void updateUser(Integer id, User user);
    public void deleteUser(Integer id);
}
