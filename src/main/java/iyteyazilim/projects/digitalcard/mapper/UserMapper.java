package iyteyazilim.projects.digitalcard.mapper;

import iyteyazilim.projects.digitalcard.dto.UserDto;
import iyteyazilim.projects.digitalcard.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
            user.getId(),
            user.getName(),
            user.getSurname(),
            user.getEmail(),
            user.getImage()
        );
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setImage(userDto.getImage());
        return user;
    }
}
