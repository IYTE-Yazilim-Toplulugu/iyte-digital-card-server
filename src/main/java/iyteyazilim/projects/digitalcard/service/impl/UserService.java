package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.User;
import iyteyazilim.projects.digitalcard.repository.IUserRepository;
import iyteyazilim.projects.digitalcard.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void addUser(User user) {

    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

    @Override
    public void updateUser(Integer id, User user) {

    }

    @Override
    public void deleteUser(Integer id) {

    }
}
