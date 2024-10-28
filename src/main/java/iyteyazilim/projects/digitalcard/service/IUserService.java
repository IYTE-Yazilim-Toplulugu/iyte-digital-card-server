package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.User;
import iyteyazilim.projects.digitalcard.dto.UserLoginDto;

import java.util.List;

public interface IUserService {
    void addUser(User user);
    List<User> getUsers();
    User getUser(Long id);
    void updateUser(Long id, User user);
    void deleteUser(Long id);


    boolean validateWithIyte(UserLoginDto userLoginDto); // İYTE'ye kullanıcı doğrulaması için
    boolean isUserExist(String email); // Kullanıcı varlığını kontrol etmek için
}
