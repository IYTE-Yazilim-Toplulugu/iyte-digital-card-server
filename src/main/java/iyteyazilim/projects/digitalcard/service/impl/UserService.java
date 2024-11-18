package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.User;
import iyteyazilim.projects.digitalcard.repository.IUserRepository;
import iyteyazilim.projects.digitalcard.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iyteyazilim.projects.digitalcard.dto.UserLoginDto;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            userRepository.save(existingUser);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean validateWithIyte(UserLoginDto userLoginDto) {
        // İYTE'ye doğrulama isteği göndermek için gerekli kodu buraya ekleyin.
        // Örnek olarak basit bir kontrol:
        return "iyte.edu.tr".equals(userLoginDto.getEmail().split("@")[1]);
    }

    @Override
    public boolean isUserExist(String email) {
        // Kullanıcıyı email ve öğrenci numarasına göre kontrol et
        return userRepository.findByEmail(email).isPresent();
    }


}
