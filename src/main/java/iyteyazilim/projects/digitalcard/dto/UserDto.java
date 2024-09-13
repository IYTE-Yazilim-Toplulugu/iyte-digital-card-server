package iyteyazilim.projects.digitalcard.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String image;
}
