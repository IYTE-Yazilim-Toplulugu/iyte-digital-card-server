package iyteyazilim.projects.digitalcard.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class CommunityDto {
    private String email;
    private String password;
}
